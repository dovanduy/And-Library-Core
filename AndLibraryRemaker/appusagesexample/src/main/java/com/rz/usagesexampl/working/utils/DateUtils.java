package com.rz.usagesexampl.working.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static String methodName = "methodName-var";
    /*@Deprecated
    public static String getDateFormat(String argDate) throws ParseException {
        methodName = "String getDateFormat(String argDate)";
        return CoreDateUtils.getDateFormat(argDate);
    }*/

    public static String getFormattedDate(String argStrDate, String argInDateFormat) throws ParseException, NullPointerException {
        methodName = "String getFormattedDate(String argStrDate, String argInDateFormat)";
        return CoreDateUtils.getFormattedDate(argStrDate, argInDateFormat);
    }

    public static String getFormattedDate(String argStrDate, String argInDateFormat, String argOutDateFormat) throws ParseException, NullPointerException {
        methodName = "String getFormattedDate(String argStrDate, String argInDateFormat, String argOutDateFormat)";
        return CoreDateUtils.getFormattedDate(argStrDate, argInDateFormat, argOutDateFormat);
    }

    public static boolean isValidDate(String argDateString, String argDateFormat) {
        methodName = "boolean isValidDate(String argDateString, String argDateFormat)";
        return CoreDateUtils.isValidDate(argDateString, argDateFormat);
    }
}
