package com.rz.usagesexampl.working;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

import com.rz.usagesexampl.ActTestTwo;
import com.rz.usagesexampl.done.log.LogWriter;
import com.rz.usagesexampl.done.redirect.RedirectWindow;
import com.rz.usagesexampl.working.jxml.JSONFastParser;

import org.json.JSONException;

import java.util.HashMap;
import java.util.List;

public class Separator {
    private Activity activity;
    private Context context;
    private String CLASS_NAME = this.getClass().getName();
    private boolean isDependencyWait = false;

    public Separator(Activity argActivity, Context argContext) {
        activity = argActivity;
        context = argContext;
    }

    private void onJson() {
        String jsonObjectString = "{\"id\":4,\"reproductive_health_problem\":[{\"url\":\"http://103.108.144.134:8003/hmsapi/reproductive_health_problem/1/\",\"id\":1,\"name\":\"Hormone-related problems\",\"bn_name\":\"হরমোন জনিত সমস্যা\",\"gender\":\"cow\",\"description\":\"হরমোন জনিত সমস্যা\"}],\"genetic_disease\":[{\"url\":\"http://103.108.144.134:8003/hmsapi/disease/1/\",\"id\":1,\"name\":\"Premature abortion\",\"bn_name\":\"অকাল গর্ভপাত\",\"type\":\"g\",\"description\":\"\"}],\"insurance_company\":{\"url\":\"http://103.108.144.134:8003/hmsapi/farm/3/\",\"id\":3,\"name\":\"Shurjomukhi\",\"bn_name\":\"সূর্যমুখী\"},\"insurance_type\":{\"url\":\"http://103.108.144.134:8003/hmsapi/insurance_type/3/\",\"id\":3,\"name\":\"Theft\",\"bn_name\":\"চুরি\"},\"bolus\":{\"url\":\"http://103.108.144.134:8003/hmsapi/bolus/4/\",\"id\":4,\"type\":\"BB\",\"bolus_number\":\"B-004\",\"description\":\"\"},\"cow_type\":{\"url\":\"http://103.108.144.134:8003/hmsapi/cow_type/3/\",\"id\":3,\"name\":\"Jersey\",\"bn_name\":\"জার্সি\",\"description\":\"জার্সি\"},\"farm\":{\"url\":\"http://103.108.144.134:8003/hmsapi/farm/2/\",\"id\":2,\"name\":\"Shurjo R & D\",\"bn_name\":\"সূর্য আর এন্ড ডি\",\"farm_no\":\"02\",\"thana\":2,\"farmer\":[2],\"address\":\"\"},\"group\":{\"id\":3,\"location\":\"Uttora\",\"name\":\"Less milk producers\",\"bn_name\":\"কম দুধ উৎপাদনকারী\",\"feeds\":\"fresh\",\"animal_farm\":2},\"genetic_percentage\":{\"url\":\"http://103.108.144.134:8003/hmsapi/genetic_percentage/3/\",\"id\":3,\"name\":\"87.5\",\"bn_name\":\"৮৭.৫\"},\"cow_image\":[{\"url\":\"http://103.108.144.134:8003/hmsapi/cow_image/10/\",\"id\":10,\"cow\":4,\"type\":\"L\",\"image\":\"http://103.108.144.134:8003/media/cow-image/download.png\"},{\"url\":\"http://103.108.144.134:8003/hmsapi/cow_image/11/\",\"id\":11,\"cow\":4,\"type\":\"R\",\"image\":\"http://103.108.144.134:8003/media/cow-image/images_10.jpg\"},{\"url\":\"http://103.108.144.134:8003/hmsapi/cow_image/12/\",\"id\":12,\"cow\":4,\"type\":\"F\",\"image\":\"http://103.108.144.134:8003/media/cow-image/images_1.jpg\"}],\"bolused_date\":\"2018-05-01\",\"cow_name\":\"Priyanka\",\"ear_tag\":\"Er-10004\",\"age\":\"9.00\",\"weight\":\"54.00\",\"previous_farm\":\"Na\",\"gender\":\"cow\",\"insurance_number\":\"1005\",\"reproductive_health\":true,\"avg_milk_production\":\"3.000\",\"is_lacting\":true,\"number_of_offsprings\":2,\"last_offsprings_delivered_date\":\"2018-06-02\"}";
        String jsonArrayString = "[{\"url\":\"http://103.108.144.134:8003/hmsapi/reproductive_health_problem/1/\",\"id\":1,\"name\":\"Hormone-related problems\",\"bn_name\":\"হরমোন জনিত সমস্যা\",\"gender\":\"cow\",\"description\":\"হরমোন জনিত সমস্যা\"}]";
        try {
            HashMap<String, Object> jsonHashMapData = com.rz.usagesexampl.working.jxml.JSONFastParser.JSONObjectFeed(jsonObjectString);
            List<Object> jsonListData = com.rz.usagesexampl.working.jxml.JSONFastParser.JSONArrayFeed(jsonArrayString);
            System.out.println(jsonHashMapData.toString());
            System.out.println(jsonListData.toString());
            if (com.rz.usagesexampl.working.jxml.JSONFastParser.isMap(jsonHashMapData)) {
            }
            if (com.rz.usagesexampl.working.jxml.JSONFastParser.isList(jsonListData)) {
            }
            System.out.println("getObjectByKey: " + com.rz.usagesexampl.working.jxml.JSONFastParser.getObjectByKey(jsonHashMapData, "reproductive_health_problem"));
            System.out.println("getHashMapByKey: " + com.rz.usagesexampl.working.jxml.JSONFastParser.getHashMapByKey(jsonHashMapData, "reproductive_health_problem"));
            System.out.println("getArrayListMapByKey: " + com.rz.usagesexampl.working.jxml.JSONFastParser.getArrayListMapByKey(jsonHashMapData, "reproductive_health_problem"));
            System.out.println("getArrayListByKey: " + JSONFastParser.getArrayListByKey(jsonHashMapData, "reproductive_health_problem"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void onLog() {
        String TAG = "TEST_TAG";
        LogWriter.isDebug = true;
        LogWriter.Log("Test log log");
        LogWriter.Log(TAG, "Test log log");
        LogWriter.dLog("Test log d");
        LogWriter.dLog(TAG, "Test log d");
        LogWriter.eLog("Test log e");
        LogWriter.eLog(TAG, "Test log e");
        LogWriter.iLog("Test log i");
        LogWriter.iLog(TAG, "Test log i");
        LogWriter.vLog("Test log v");
        LogWriter.vLog(TAG, "Test log v");
        LogWriter.wtfLog("Test log wtf");
        LogWriter.wtfLog(TAG, "Test log wtf");
        LogWriter.isDebug = true;
        LogWriter.Write.Log(CLASS_NAME, "Test log log");
        LogWriter.Write.Log(CLASS_NAME, TAG, "Test log log");
        LogWriter.Write.dLog(CLASS_NAME, "Test log d");
        LogWriter.Write.dLog(CLASS_NAME, TAG, "Test log d");
        LogWriter.Write.eLog(CLASS_NAME, "Test log e");
        LogWriter.Write.eLog(CLASS_NAME, TAG, "Test log e");
        LogWriter.Write.iLog(CLASS_NAME, "Test log i");
        LogWriter.Write.iLog(CLASS_NAME, TAG, "Test log i");
        LogWriter.Write.vLog(CLASS_NAME, "Test log v");
        LogWriter.Write.vLog(CLASS_NAME, TAG, "Test log v");
        LogWriter.Write.wtfLog(CLASS_NAME, "Test log wtf");
        LogWriter.Write.wtfLog(CLASS_NAME, TAG, "Test log wtf");
    }

    private void onRedirectWindow() {
        Bundle bundle = new Bundle();
        /*RedirectWindow redirectWindow = RedirectWindow.getInstance(activity, context);
        redirectWindow.withBundle(bundle)
                .withFlag()
                .disposeWindow()
                .run(ActTestTwo.class, 5000);*/
        RedirectWindow redirectWindow = RedirectWindow.getInstance(activity, context);
        redirectWindow.withBundle(bundle)
                .withFlag()
                .disposeWindow()
                .run(ActTestTwo.class);
        redirectWindow.withBundle(bundle)
                .withFlag()
                .disposeWindow()
                .run(ActTestTwo.class, 5000);
        redirectWindow.withBundle(bundle)
                .withFlag()
                .disposeWindow()
                .run(ActTestTwo.class, 5000, new RedirectWindow.OnEventListener() {
                    @Override
                    public boolean onDependencyWait() {
                        return isDependencyWait;
                    }
                });
        new Handler().postDelayed(new Runnable() {
            public void run() {
                isDependencyWait = true;
            }
        }, 10000);
    }
}
