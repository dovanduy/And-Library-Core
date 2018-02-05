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
        SecureKeyManager.onSecurityChanged(context);
    }
}
