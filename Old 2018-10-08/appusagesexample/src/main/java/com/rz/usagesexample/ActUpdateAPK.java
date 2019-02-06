package com.rz.usagesexample;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rz.librarycore.downshift.BootUpDownload;
import com.rz.librarycore.downshift.DigitizeDownload;

public class ActUpdateAPK extends AppCompatActivity {
    private Activity activity;
    private Context context;
    private Button sysBtnOnConnection;
    private Button sysBtnOnManager;
    private String fileUrl = "http://androidpala.com/tutorial/app-debug.apk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_update_apk);
        activity = this;
        context = this;
        sysBtnOnConnection = (Button) findViewById(R.id.sysBtnOnConnection);
        sysBtnOnManager = (Button) findViewById(R.id.sysBtnOnManager);
        sysBtnOnConnection.setOnClickListener(new ButtonClickListener());
        sysBtnOnManager.setOnClickListener(new ButtonClickListener());
    }

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View argView) {
            long btnId = argView.getId();
            if (btnId == R.id.sysBtnOnConnection) {
                DigitizeDownload digitizeDownload = new DigitizeDownload(activity, context);
                digitizeDownload.onExecute(fileUrl, "And-Library-Core.apk");
            } else if (btnId == R.id.sysBtnOnManager) {
                BootUpDownload bootUpDownload = new BootUpDownload(activity, context);
                bootUpDownload.onExecute(fileUrl, "And-Library-Core.apk", "And Library Core - Update", "New Update APK, don't close before download complete.");
            }
        }
    }
}
/*
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
*/