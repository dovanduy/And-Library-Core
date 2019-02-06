package com.rz.librarycore.utils;

import java.text.ParseException;

public class DateUtils {

    public static String getFormattedDate(String argStrDate, String argInDateFormat) throws ParseException, NullPointerException {
        return C0367a.m1386a(argStrDate, argInDateFormat);
    }

    public static String getFormattedDate(String argStrDate, String argInDateFormat, String argOutDateFormat) throws ParseException, NullPointerException {
        return C0367a.m1387a(argStrDate, argInDateFormat, argOutDateFormat);
    }

    public static boolean isValidDate(String argDateString, String argDateFormat) {
        return C0367a.m1389b(argDateString, argDateFormat);
    }
}
