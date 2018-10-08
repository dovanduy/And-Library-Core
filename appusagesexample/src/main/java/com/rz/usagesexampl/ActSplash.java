package com.rz.usagesexampl;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rz.librarycore.redirect.RedirectWindow;

public class ActSplash extends AppCompatActivity {
    private Activity activity;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash);
        activity = this;
        context = this;
        RedirectWindow redirectWindow = new RedirectWindow(context);
        Bundle bundleExtras = new Bundle();
        redirectWindow.setBundle(bundleExtras);
    }
}