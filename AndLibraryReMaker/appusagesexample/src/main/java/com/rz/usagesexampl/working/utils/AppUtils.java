package com.rz.usagesexampl.working.utils;

import android.content.Context;
import android.graphics.Point;

/**
 * Created by Rz Rasel on 2016/09/16.
 */
public class AppUtils {
    private static String methodName = "methodName-var";

    public static String getAppVersion(Context argContext) {
        methodName = "getAppVersion(Context argContext)";
        return CoreAppUtils.getAppVersion(argContext);
    }

    public static int getAppVersionCode(Context argContext) {
        methodName = "getAppVersionCode(Context argContext)";
        return CoreAppUtils.getAppVersionCode(argContext);
    }

    public static void logDebug(String argTag, String argMessage) {
        methodName = "logDebug(String argTag, String argMessage)";
        CoreAppUtils.logDebug(argTag, argMessage);
    }

    public static Point getDisplaySize(Context argContext) {
        methodName = "getDisplaySize(Context argContext)";
        return CoreAppUtils.getDisplaySize(argContext);
    }

    //|----|------------------------------------------------------------|
    public static boolean isURLAvailable(String argURL) {
        methodName = "isURLAvailable(String argURL)";
        return CoreAppUtils.isURLAvailable(argURL);
    }
    //|----|------------------------------------------------------------|
}