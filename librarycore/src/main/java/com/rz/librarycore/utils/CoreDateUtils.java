package com.rz.librarycore.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CoreDateUtils {
    public static String getFormattedDate(String argStrDate, String argInDateFormat) throws ParseException, NullPointerException {
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

    public static String getFormattedDate(String argStrDate, String argInDateFormat, String argOutDateFormat) throws ParseException, NullPointerException {
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

    public static boolean isValidDate(String argDateString, String argDateFormat) {
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
}