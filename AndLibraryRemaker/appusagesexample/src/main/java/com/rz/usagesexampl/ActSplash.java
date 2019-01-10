package com.rz.usagesexampl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rz.usagesexampl.hardware.DeviceInfo;
import com.rz.usagesexampl.imagepicker.CRUDPathManager;
import com.rz.usagesexampl.imagepicker.DirectoryPathManager;
import com.rz.usagesexampl.imagepicker.exception.CoreException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <h1>ActSplash</h1>
 * <p>
 * Use for object memory cache
 * </p>
 *
 * @author Rz Rasel (Md. Rashed - Uz - Zaman)
 * @version 100.00.01
 * @since 2018-12-17
 */

public class ActSplash extends AppCompatActivity {
    private Activity activity;
    private Context context;
    private String CLASS_NAME;
    private boolean isDependencyWait = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash);
        activity = this;
        context = this;
        CLASS_NAME = this.getClass().getName();
        //onUseMemoryCache();
        /*HashMap<String, String> allMappedValue = new DeviceInfo(activity, context).getAllMappedValue();
        System.out.println(allMappedValue.toString());*/
        /*Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        startActivity(intent);*/
        DirectoryPathManager directoryPathManager = new DirectoryPathManager(context)
                .withDirectory(".test")
                .withPackage(false);
        System.out.println("DIRECTORY: " + directoryPathManager.getSystemDirectory());
        System.out.println("DIRECTORY: " + directoryPathManager.getCacheDirectory());
        try {
            CRUDPathManager.onCreateDirectories(context, directoryPathManager.getSystemDirectory());
            CRUDPathManager.onCreateDirectories(context, directoryPathManager.getCacheDirectory());
        } catch (CoreException e) {
            e.printStackTrace();
        }
    }

    private void onUseMemoryCache() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Value001");
        arrayList.add("Value002");
        arrayList.add("Value003");
        arrayList.add("Value004");
        arrayList.add("Value005");
        String cacheKey = "cacheKey";
        /*try {
            MemoryCache.setCache(context, cacheKey, arrayList);
            ArrayList<String> arrayList1 = (ArrayList<String>) MemoryCache.getCache(context, cacheKey);
            System.out.println("SIZE: " + arrayList1.size());
            MemoryCache.onDeleteCache(context, cacheKey);
            MemoryCache.onClearAll(context);
        } catch (IOException ex) {
            //ex.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            //ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            //ex.printStackTrace();
        }*/
    }

    private void onAppUtils() {
        /*AppUtils.getAppVersion(context);
        AppUtils.getAppVersionCode(context);
        AppUtils.logDebug("TAG", "MESSAGE");
        AppUtils.getDisplaySize(context);
        AppUtils.isURLAvailable("URL");*/
    }
}
//https://github.com/bintray/gradle-bintray-plugin/issues/88
//https://stackoverflow.com/questions/33668021/bintray-unable-to-upload-files-maven-group-artifact-or-version-defined-in-the
//https://www.petrikainulainen.net/programming/gradle/getting-started-with-gradle-creating-a-multi-project-build/
//https://docs.gradle.org/current/userguide/maven_plugin.html
//https://stackoverflow.com/questions/45078381/gradle-library-with-multiple-modules
