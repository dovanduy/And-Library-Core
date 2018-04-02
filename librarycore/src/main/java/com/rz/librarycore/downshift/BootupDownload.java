package com.rz.librarycore.downshift;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;

import java.io.File;

public class BootUpDownload {
    private Activity activity;
    private Context context;

    public void BootUpDownload(Context argContext) {
        context = argContext;
    }

    private static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    public void OnDownloadManager(String argURL, String argTitle, String argDescription) {
        if (Build.VERSION.SDK_INT >= 23) {
            int REQUEST = 112;
            //String[] PERMISSIONS = {android.Manifest.permission.WRITE_EXTERNAL_STORAGE};
            String[] PERMISSIONS = {android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE};
            if (!hasPermissions(context, PERMISSIONS)) {
                ActivityCompat.requestPermissions((Activity) context, PERMISSIONS, REQUEST);
                return;
            }
        }
        //get destination to update file and set Uri
        //TODO: First I wanted to store my update .apk file on internal storage for my app but apparently android does not allow you to open and install
        //aplication with existing package from there. So for me, alternative solution is Download directory in external storage. If there is better
        //solution, please inform us in comment
        String destination = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/";
        String fileName = "AppName.apk";
        destination += fileName;
        final Uri uri = Uri.parse("file://" + destination);

        //Delete update file if exists
        File file = new File(destination);
        if (file.exists())
            //file.delete() - test this, I think sometimes it doesnt work
            file.delete();

        //get url of app on server
        //String url = context.getString(R.string.update_app_url);
        //url = "http://androidpala.com/tutorial/app-debug.apk";

        //set downloadmanager
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(argURL));
        request.setTitle(argTitle);
        request.setDescription(argDescription);

        //set destination
        request.setDestinationUri(uri);

        // get download service and enqueue file
        final DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        final long downloadId = manager.enqueue(request);

        //set BroadcastReceiver to install app when .apk is downloaded
        BroadcastReceiver onComplete = new BroadcastReceiver() {
            public void onReceive(Context ctxt, Intent intent) {
                Intent install = new Intent(Intent.ACTION_VIEW);
                install.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                install.setDataAndType(uri, manager.getMimeTypeForDownloadedFile(downloadId));
                //intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                context.startActivity(install);

                context.unregisterReceiver(this);
                //activity.finish();
            }
        };
        //register receiver for when .apk download is compete
        context.registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }
}
//http://androidpala.com/install-android-app-programmatically/
//http://www.javacodex.com/Date-and-Time/Add-Time-To-A-Timestamp
//https://github.com/ivijaykumaar/Remainder/blob/master/app/src/main/java/com/atom/remainder/NewEventAct.java
//https://github.com/dharmakshetri/HappyBirthDay
//https://www.javacodegeeks.com/2012/09/android-alarmmanager-tutorial.html
//https://github.com/AbhinayB/Medical-Remainder/tree/master/MedicalAlert/app/src/main/java/com/example/medicalalert
//https://www.youtube.com/watch?v=cODKB9fApXk