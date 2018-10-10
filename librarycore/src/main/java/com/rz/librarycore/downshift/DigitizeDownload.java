package com.rz.librarycore.downshift;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Rz Rasel on 2018-04-01.
 */
public class DigitizeDownload {
    private Activity activity;
    private Context context;
    private ProgressDialog progressDialog;
    private String fileUrl;
    private String fileName;

    public DigitizeDownload(Activity argActivity, Context argContext) {
        activity = argActivity;
        context = argContext;
        /*activity = this;
        context = this;*/
        /*TextView heading = (TextView) findViewById(R.id.heading);
        Button updateBtn = (Button) findViewById(R.id.btn);
        heading.setText("App Version: " + AppVersion);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadNewVersion().execute();
            }
        });*/
    }

    public void onExecute(String argFileUrl, String argFileName) {
        if (Build.VERSION.SDK_INT >= 23) {
            int REQUEST = 112;
            //String[] PERMISSIONS = {android.Manifest.permission.WRITE_EXTERNAL_STORAGE};
            String[] PERMISSIONS = {android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE};
            if (!hasPermissions(context, PERMISSIONS)) {
                ActivityCompat.requestPermissions((Activity) context, PERMISSIONS, REQUEST);
                Toast.makeText(context, "For permission can't execute. Try again", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        fileUrl = argFileUrl;
        fileName = argFileName;
        new DownloadFile().execute(fileUrl);
    }

    private boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    public class DownloadFile extends AsyncTask<String, Integer, Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(context);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Downloading...");
            progressDialog.setIndeterminate(true);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

        }

        protected void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate(progress);
            progressDialog.setIndeterminate(false);
            progressDialog.setMax(100);
            progressDialog.setProgress(progress[0]);
            String msg = "";
            if (progress[0] > 99) {
                msg = "Finishing... ";
            } else {
                msg = "Downloading... " + progress[0] + "%";
            }
            progressDialog.setMessage(msg);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            progressDialog.dismiss();
            /*if (result) {
                Toast.makeText(getApplicationContext(), "Update Done", Toast.LENGTH_SHORT).show();
            } else {

                Toast.makeText(getApplicationContext(), "Error: Try Again", Toast.LENGTH_SHORT).show();
            }*/

        }

        @Override
        protected Boolean doInBackground(String... argParamUrl) {
            Boolean flag = false;
            try {
                //"http://androidpala.com/tutorial/app-debug.apk"
                String strUrl = argParamUrl[0];
                URL url = new URL(strUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setDoOutput(true);
                conn.connect();
                String localSdCardFilePath = Environment.getExternalStorageDirectory() + "/Download/";
                File file = new File(localSdCardFilePath);
                file.mkdirs();
                File outputFile = new File(file, fileName);

                if (outputFile.exists()) {
                    outputFile.delete();
                }

                FileOutputStream fos = new FileOutputStream(outputFile);
                InputStream is = conn.getInputStream();

                int total_size = 1431692;//size of apk
                total_size = conn.getContentLength();

                byte[] buffer = new byte[1024];
                int len1 = 0;
                int per = 0;
                int downloaded = 0;
                while ((len1 = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len1);
                    downloaded += len1;
                    per = (int) (downloaded * 100 / total_size);
                    publishProgress(per);
                }
                fos.close();
                is.close();
                OpenNewVersion(localSdCardFilePath);
                flag = true;
            } catch (Exception e) {
                //Log.e(TAG, "Update Error: " + e.getMessage());
                flag = false;
            }
            return flag;
        }
    }

    public void OpenNewVersion(String argLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(new File(argLocation + fileName)), "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
//http://www.mysamplecode.com/2013/05/android-update-application.html