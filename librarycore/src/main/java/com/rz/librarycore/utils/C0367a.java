package com.rz.librarycore.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

class C0367a {
    private static final String[] f1106a = new String[]{"dd/MM/yyyy", "dd/MM/yyyy hh:mm:ss", "dd/MM/yyyy HH:mm:ss", "dd/MM/yyyy'T'HH:mm:ss.SSS'Z'", "dd/MM/yyyy'T'HH:mm:ss.SSSZ", "dd/MM/yyyy'T'HH:mm:ss.SSS", "dd/MM/yyyy'T'HH:mm:ssZ", "dd/MM/yyyy'T'HH:mm:ss", "yyyy-MM-dd", "yyyy-MM-dd hh:mm:ss", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss'Z'", "yyyy-MM-dd'T'HH:mm:ssZ", "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "yyyy-MM-dd'T'HH:mm:ss.SSSZ", "MM/dd/yyyy", "MM/dd/yyyy hh:mm:ss", "MM/dd/yyyy HH:mm:ss", "MM/dd/yyyy'T'HH:mm:ss.SSS'Z'", "MM/dd/yyyy'T'HH:mm:ss.SSSZ", "MM/dd/yyyy'T'HH:mm:ss.SSS", "MM/dd/yyyy'T'HH:mm:ssZ", "MM/dd/yyyy'T'HH:mm:ss", "yyyy:MM:dd HH:mm:ss", "yyyyMMdd"};

    protected static String m1386a(String str, String str2) throws ParseException, NullPointerException {
        if (m1388a(str) || m1388a(str2)) {
            throw new NullPointerException();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(simpleDateFormat.parse(str));
        } catch (ParseException e) {
            throw e;
        }
    }

    protected static String m1387a(String str, String str2, String str3) throws ParseException, NullPointerException {
        if (m1388a(str) || m1388a(str2) || m1388a(str3)) {
            throw new NullPointerException();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        try {
            return new SimpleDateFormat(str3).format(simpleDateFormat.parse(str));
        } catch (ParseException e) {
            throw e;
        }
    }

    protected static boolean m1389b(String str, String str2) {
        if (m1388a(str) || m1388a(str2)) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        try {
            simpleDateFormat.parse(str);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private static boolean m1388a(String str) {
        if (str == null) {
            return true;
        }
        str = str.replaceAll("\\s+", "");
        return str.trim().isEmpty() || str.equalsIgnoreCase("null");
    }
}
