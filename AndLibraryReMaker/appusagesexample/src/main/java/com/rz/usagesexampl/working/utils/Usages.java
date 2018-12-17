package com.rz.usagesexampl.working.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.HashMap;

public class Usages {
    public void onUsagesDateUtils() {
        String strDate = "2018-11-22";
        try {
            //System.out.println(DateUtils.getDateFormat(strDate));
            System.out.println(DateUtils.getFormattedDate(strDate, "yyyy-MM-dd"));
            System.out.println(DateUtils.getFormattedDate(strDate, "yyyy-MM-dd", "dd/MM/yyyy HH:mm:ss"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(DateUtils.isValidDate(strDate, "yyyy-MM-dd"));
    }

    private void useUtils() {
        String abc = "null";
        if (Utils.isNullOrEmpty(abc)) {
            System.out.println("NULL_VALUE_FOUND");
        }
        System.out.println("CACHE_SIZE: " + Utils.getCacheSize());
        abc = "check it";
        try {
            abc = Utils.getBase64Encode(abc);
            System.out.println("BASE64: " + abc);
            abc = Utils.getBase64Decode(abc);
            System.out.println("BASE64: " + abc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void onUsagesURLBuilder() throws UnsupportedEncodingException {
        URLBuilder urlBuilder = new URLBuilder();
        urlBuilder.withParameter("key1", "Value1")
                .withParameter("key2", "Value2")
                .withParameter("key3", "Value2")
                .withParameter("key3", "Value4")
                .withParameter("key4", "")
                .withParameter("key5", "Value5");
        System.out.println(urlBuilder.getURLParameter());
        System.out.println(urlBuilder.getURLParameter(true));
        HashMap<String, String> urlParameters = new HashMap<>();
        urlParameters.put("key1", "Value1");
        urlParameters.put("key2", "Value2");
        urlParameters.put("key3", "Value2");
        urlParameters.put("key3", "Value4");
        urlParameters.put("key4", "");
        urlParameters.put("key5", "Value5");
        System.out.println(URLBuilder.getURLParameter(urlParameters));
        System.out.println(URLBuilder.getURLParameter(urlParameters, true));
        //https://stackoverflow.com/questions/1921514/how-to-run-a-runnable-thread-in-android-at-defined-intervals
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(URLBuilder.isURLAlive("https://rzrasel.net/"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //System.out.println(URLBuilder.isJson("{asfasf,asdfaf}"));
    }
}
