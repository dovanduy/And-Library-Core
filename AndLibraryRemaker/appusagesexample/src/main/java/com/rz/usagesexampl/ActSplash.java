package com.rz.usagesexampl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.rz.usagesexampl.done.log.LogWriter;
import com.rz.usagesexampl.done.RedirectWindow;


public class ActSplash extends AppCompatActivity {
    private Activity activity;
    private Context context;
    private String CLASS_NAME = this.getClass().getName();
    private boolean isDependencyWait = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash);
        activity = this;
        context = this;
        onRedirectWindow();
        /*RoundImage.onSayHi();
        MashUp.onSayHi();*/
        onLog();
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
        /*redirectWindow.withBundle(bundle)
                .withFlag()
                .disposeWindow()
                .run(ActTestTwo.class);*/
        /*redirectWindow.withBundle(bundle)
                .withFlag()
                .disposeWindow()
                .run(ActTestTwo.class, 5000);*/
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
//https://github.com/bintray/gradle-bintray-plugin/issues/88
//https://stackoverflow.com/questions/33668021/bintray-unable-to-upload-files-maven-group-artifact-or-version-defined-in-the
//https://www.petrikainulainen.net/programming/gradle/getting-started-with-gradle-creating-a-multi-project-build/
//https://docs.gradle.org/current/userguide/maven_plugin.html
//https://stackoverflow.com/questions/45078381/gradle-library-with-multiple-modules
