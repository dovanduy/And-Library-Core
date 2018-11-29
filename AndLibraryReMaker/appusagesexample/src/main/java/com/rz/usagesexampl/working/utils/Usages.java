package com.rz.usagesexampl.working.utils;

import java.text.ParseException;

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
}
