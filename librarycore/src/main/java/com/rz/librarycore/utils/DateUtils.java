package com.rz.librarycore.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static boolean isValidDate(String argDateString, String argDateFormat) {
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(argDateFormat);
        try {
            simpleDateFormat.parse(argDateString);
            System.out.println("DEBUG_LOG_PRINT: IS_DATE_VALIDATE " + argDateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static String getFormattedDate(String argStrDate, String argInDateFormat) {
        /*SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");*/
        SimpleDateFormat dateFormatter = new SimpleDateFormat(argInDateFormat);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = dateFormatter.parse(argStrDate);
            //Date date = Date.parse(argStrDate);
            return simpleDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getFormattedDate(String argStrDate, String argInDateFormat, String argOutDateFormat) {
        /*SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");*/
        SimpleDateFormat dateFormatter = new SimpleDateFormat(argInDateFormat);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(argOutDateFormat);
        try {
            Date date = dateFormatter.parse(argStrDate);
            //Date date = Date.parse(argStrDate);
            return simpleDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
