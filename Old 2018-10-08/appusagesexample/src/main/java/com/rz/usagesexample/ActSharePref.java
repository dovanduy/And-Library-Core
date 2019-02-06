package com.rz.usagesexample;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;

import com.rz.librarycore.apppackage.APPStaticPackageInfo;
import com.rz.librarycore.certificate.CertificateSHA1Fingerprint;
import com.rz.librarycore.hardware.DeviceInfo;
import com.rz.librarycore.inetapi.DeviceIPApi;
import com.rz.librarycore.log.LogWriter;
import com.rz.librarycore.log.SecureKeyManager;
import com.rz.librarycore.storage.SharePrefPrivateHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ActSharePref extends AppCompatActivity {
    private Activity activity;
    private Context context;
    //private SharePrefPrivateHandler sharePrefHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_share_pref);
        activity = this;
        context = this;
        LogWriter.Log(APPStaticPackageInfo.getPackageName(context));
        //
        /*SecureKeyManager secureKeyManager = new SecureKeyManager(activity, context);
        SharePrefPrivateHandler sharePrefHandler = new SharePrefPrivateHandler(context, APPStaticPackageInfo.getPackageName(context));
        //sharePrefHandler.clearAll();
        //sharePrefHandler.setValue("is_private_data_force_update", true);
        SecureKeyManager.onSetAppIsRunFirstTime(context);
        sharePrefHandler.printAllKeyValue();
        //////
        //////
        SecureKeyManager.onSecurityChanged(context);*/
        /*//////
        //////
        HashMap<String, String> map1 = new HashMap<String, String>();
        HashMap<String, String> map2 = new HashMap<String, String>();
        HashMap<String, String> map3 = new HashMap<String, String>();
        map1.put("map-111", "111");
        map1.put("map-122", "222");
        map1.put("map-133", "333");
        map2.put("map-244", "444");
        map2.put("map-255", "555");
        map2.put("map-266", "666");
        map3.putAll(map1);
        map3.putAll(map2);
        LogWriter.Log("Map Data: " + map3.toString());*/
    }
}
