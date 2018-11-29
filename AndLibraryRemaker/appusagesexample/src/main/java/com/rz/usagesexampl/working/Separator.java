package com.rz.usagesexampl.working;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

import com.rz.usagesexampl.ActTestTwo;
import com.rz.usagesexampl.done.log.LogWriter;
import com.rz.usagesexampl.done.redirect.RedirectWindow;
import com.rz.usagesexampl.done.jxml.JSONFastParser;

public class Separator {
    private Activity activity;
    private Context context;
    private String CLASS_NAME = this.getClass().getName();
    private boolean isDependencyWait = false;

    public Separator(Activity argActivity, Context argContext) {
        activity = argActivity;
        context = argContext;
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
