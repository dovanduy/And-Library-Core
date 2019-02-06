package com.rz.librarycore.apppackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by Rz Rasel on 2016/11/25.
 */

public class APPStaticPackageInfo {
    public static String getPackageName(Context argContext) {
        PackageManager packageManager = argContext.getPackageManager();
        String packageName = null;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(argContext.getPackageName(), PackageManager.GET_META_DATA);
            if (packageInfo != null) {
                packageName = packageInfo.packageName;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
        return packageName;
    }

    public static String getVersionName(Context argContext) {
        PackageManager packageManager = argContext.getPackageManager();
        try {
            //PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            PackageInfo packageInfo = packageManager.getPackageInfo(argContext.getPackageName(), PackageManager.GET_META_DATA);
            //return packageInfo.versionCode;
            //packageInfo.packageName;
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }

    public static int getVersionCode(Context argContext) {
        PackageManager packageManager = argContext.getPackageManager();
        try {
            //PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            PackageInfo packageInfo = packageManager.getPackageInfo(argContext.getPackageName(), PackageManager.GET_META_DATA);
            //return packageInfo.versionCode;
            //packageInfo.packageName;
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }
}