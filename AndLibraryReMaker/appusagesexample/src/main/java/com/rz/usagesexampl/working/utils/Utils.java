package com.rz.usagesexampl.working.utils;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

public class Utils {
    private static String methodName = "methodName-var";
    public static boolean isNullOrEmpty(String argValue) {
        methodName = "boolean isNullOrEmpty(String argValue)";
        return CoreUtils.isNullOrEmpty(argValue);
    }

    public static int getCacheSize() {
        methodName = "int getCacheSize()";
        return CoreUtils.getCacheSize();
    }

    public static String getBase64Encode(String argString) throws UnsupportedEncodingException {
        methodName = "String getBase64Encode(String argString) throws UnsupportedEncodingException";
        return CoreUtils.getBase64Encode(argString);
    }

    public static String getBase64Decode(String argString) throws UnsupportedEncodingException {
        methodName = "String getBase64Decode(String argString) throws UnsupportedEncodingException";
        return CoreUtils.getBase64Decode(argString);
    }
}
