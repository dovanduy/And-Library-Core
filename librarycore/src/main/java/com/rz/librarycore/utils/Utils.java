package com.rz.librarycore.utils;

import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Utils {
    public static boolean isNullOrEmpty(String argValue) {
        if (argValue == null) {
            return true;
        }
        argValue = argValue.replaceAll("\\s+", "");
        if (argValue.trim().isEmpty()) {
            return true;
        }
        if (argValue.equalsIgnoreCase("null")) {
            return true;
        }
        return false;
    }

    public static void printDigits(int argNum) {
        /*if (argNum / 10 > 0) {
            printDigits(argNum / 10);
        }*/
        //System.out.printf("DEBUG_LOG_PRINT: number %d ", argNum % 10);
        //System.out.println("DEBUG_LOG_PRINT: number " + argNum % 10);
        if (argNum / 10 > 0) {
            printDigits(argNum / 10);
        }
        System.out.println("DEBUG_LOG_PRINT: number " + argNum % 10);
        /*if (argNum > 0) {
            System.out.println("DEBUG_LOG_PRINT: number " + argNum % 10);
            printDigits(argNum / 10);
        }*/
    }

    public static int getCacheSize() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        // use 1/8th of the available memory for this memory cache.
        return maxMemory / 8;
    }

    public static String getBase64Encode(String argString) {
        try {
            byte[] byteArray = argString.getBytes("UTF-8");
            return Base64.encodeToString(byteArray, Base64.DEFAULT);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getBase64Decode(String argString) {
        try {
            byte[] byteArray = Base64.decode(argString, Base64.DEFAULT);
            return new String(byteArray, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getURLParameter(HashMap<String, String> argHashMap) throws UnsupportedEncodingException {
        final String DEFAULT_ENCODING = "UTF-8";
        if (argHashMap != null) {
            return onPrepareParameter(argHashMap, false);
        }
        return null;
    }

    public static String getURLParameter(HashMap<String, String> argHashMap, boolean argIsRemoveEmpty) throws UnsupportedEncodingException {
        final String DEFAULT_ENCODING = "UTF-8";
        if (argHashMap != null) {
            return onPrepareParameter(argHashMap, argIsRemoveEmpty);
        }
        return null;
    }

    private static String onPrepareParameter(HashMap<String, ?> argHashMap, boolean argIsRemoveEmpty) throws UnsupportedEncodingException {
        final String DEFAULT_ENCODING = "UTF-8";
        if (argHashMap != null) {
            SortedMap<String, ?> sortedMap = new TreeMap<>(argHashMap);
            StringBuilder stringBuilder = new StringBuilder();
            Iterator<? extends Map.Entry<String, ?>> iterator = sortedMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, ?> entry = iterator.next();
                String key = entry.getKey();
                if (!isNullOrEmpty(key)) {
                    Object value = entry.getValue();
                    if (argIsRemoveEmpty && !isNullOrEmpty(value + "")) {
                        stringBuilder.append(URLEncoder.encode(key, DEFAULT_ENCODING));
                        stringBuilder.append("=");
                        String valueAsString = value != null ? URLEncoder.encode(value.toString(), DEFAULT_ENCODING) : "";
                        stringBuilder.append(valueAsString);
                        if (iterator.hasNext()) {
                            stringBuilder.append('&');
                        }
                    } else if (!argIsRemoveEmpty) {
                        stringBuilder.append(URLEncoder.encode(key, DEFAULT_ENCODING));
                        stringBuilder.append("=");
                        String valueAsString = value != null ? URLEncoder.encode(value.toString(), DEFAULT_ENCODING) : "";
                        stringBuilder.append(valueAsString);
                        if (iterator.hasNext()) {
                            stringBuilder.append('&');
                        }
                    }
                }
            }
            return stringBuilder.toString();
        }
        /*HashMap<String, String> mapItems = new HashMap<>();
        mapItems.put("str_01", "String01");
        mapItems.put("str_06", "String06");
        mapItems.put("str_03", "String03");
        mapItems.put("str_04", "");
        mapItems.put("", "String05");
        mapItems.put("str_02", "String02");
        mapItems.put("str_02", "String02d");
        try {
            System.out.println("URL_PARAM_STRING: " + Utils.getURLParameter(mapItems));
            System.out.println("URL_PARAM_STRING: " + Utils.getURLParameter(mapItems, true));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        return null;
        //https://www.geeksforgeeks.org/sortedmap-java-examples/
    }
}
