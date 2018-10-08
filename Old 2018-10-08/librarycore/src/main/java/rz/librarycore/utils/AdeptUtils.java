package rz.librarycore.utils;

import android.text.Html;
import android.text.Spanned;
import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdeptUtils {
    public static boolean isNullOrEmpty(String argValue) {
        if (argValue == null) {
            return true;
        }
        if (argValue.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static Spanned fromHtml(String argValue) {
        if (isNullOrEmpty(argValue)) {
            return null;
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            return Html.fromHtml(argValue, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(argValue);
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

    public static int getCacheSize() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        // use 1/8th of the available memory for this memory cache.
        return maxMemory / 8;
    }
}
/*
// Encode data on your side using BASE64
byte[] bytesEncoded = Base64.encodeBase64(str.getBytes());
System.out.println("encoded value is " + new String(bytesEncoded));

// Decode data on other side, by processing encoded data
byte[] valueDecoded = Base64.decodeBase64(bytesEncoded);
System.out.println("Decoded value is " + new String(valueDecoded));
*/