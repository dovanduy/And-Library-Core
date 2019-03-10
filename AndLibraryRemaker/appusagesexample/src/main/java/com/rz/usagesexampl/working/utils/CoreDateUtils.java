package com.rz.usagesexampl.working.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class CoreDateUtils {
    private static final String[] dateFormats = {
            "dd/MM/yyyy",
            "dd/MM/yyyy hh:mm:ss",
            "dd/MM/yyyy HH:mm:ss",
            "dd/MM/yyyy'T'HH:mm:ss.SSS'Z'",
            "dd/MM/yyyy'T'HH:mm:ss.SSSZ",
            "dd/MM/yyyy'T'HH:mm:ss.SSS",
            "dd/MM/yyyy'T'HH:mm:ssZ",
            "dd/MM/yyyy'T'HH:mm:ss",
            "yyyy-MM-dd",
            "yyyy-MM-dd hh:mm:ss",
            "yyyy-MM-dd HH:mm:ss",
            "yyyy-MM-dd'T'HH:mm:ss'Z'",
            "yyyy-MM-dd'T'HH:mm:ssZ",
            "yyyy-MM-dd'T'HH:mm:ss",
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
            "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
            "MM/dd/yyyy",
            "MM/dd/yyyy hh:mm:ss",
            "MM/dd/yyyy HH:mm:ss",
            "MM/dd/yyyy'T'HH:mm:ss.SSS'Z'",
            "MM/dd/yyyy'T'HH:mm:ss.SSSZ",
            "MM/dd/yyyy'T'HH:mm:ss.SSS",
            "MM/dd/yyyy'T'HH:mm:ssZ",
            "MM/dd/yyyy'T'HH:mm:ss",
            "yyyy:MM:dd HH:mm:ss",
            "yyyyMMdd",
    };
    private static String methodName = "methodName-var";

    /*public static void main(String[] args) {
        String yyyyMMdd = "20110917";
        parse(yyyyMMdd);
    }*/

    /*protected static String getDateFormat(String argDate) throws ParseException {
        methodName = "String getDateFormat(String argDate)";
        if (argDate != null) {
            for (String format : dateFormats) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
                try {
                    simpleDateFormat.parse(argDate);
                    //System.out.println("Printing the value of " + format);
                    return format;
                } catch (ParseException ex) {
                    //System.out.println("Not use " + format);
                    throw ex;
                }
            }
        }
        //https://stackoverflow.com/questions/7579227/how-to-get-the-given-date-string-formatpattern-in-java
        return null;
    }*/

    protected static String getFormattedDate(String argStrDate, String argInDateFormat) throws ParseException, NullPointerException {
        methodName = "String getFormattedDate(String argStrDate, String argInDateFormat)";
        if (isNullOrEmpty(argStrDate) || isNullOrEmpty(argInDateFormat)) {
            throw new NullPointerException();
        }
        /*SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");*/
        SimpleDateFormat dateFormatter = new SimpleDateFormat(argInDateFormat);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = dateFormatter.parse(argStrDate);
            //Date date = Date.parse(argStrDate);
            return simpleDateFormat.format(date);
        } catch (ParseException ex) {
            //ex.printStackTrace();
            throw ex;
        }
        //return null;
    }

    protected static String getFormattedDate(String argStrDate, String argInDateFormat, String argOutDateFormat) throws ParseException, NullPointerException {
        methodName = "String getFormattedDate(String argStrDate, String argInDateFormat, String argOutDateFormat)";
        if (isNullOrEmpty(argStrDate) || isNullOrEmpty(argInDateFormat) || isNullOrEmpty(argOutDateFormat)) {
            throw new NullPointerException();
        }
        /*SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");*/
        SimpleDateFormat dateFormatter = new SimpleDateFormat(argInDateFormat);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(argOutDateFormat);
        try {
            Date date = dateFormatter.parse(argStrDate);
            //Date date = Date.parse(argStrDate);
            return simpleDateFormat.format(date);
        } catch (ParseException ex) {
            //ex.printStackTrace();
            throw ex;
        }
        //return null;
    }

    protected static boolean isValidDate(String argDateString, String argDateFormat) {
        methodName = "boolean isValidDate(String argDateString, String argDateFormat)";
        if (isNullOrEmpty(argDateString) || isNullOrEmpty(argDateFormat)) {
            return false;
        }
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(argDateFormat);
        try {
            simpleDateFormat.parse(argDateString);
            //System.out.println("DEBUG_LOG_PRINT: IS_DATE_VALIDATE " + argDateString);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    private static boolean isNullOrEmpty(String argValue) {
        methodName = "boolean isNullOrEmpty(String argValue)";
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
}