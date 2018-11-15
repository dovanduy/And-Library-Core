package com.rz.usagesexampl;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rz.mashup.MashUp;
import com.rz.roundimage.RoundImage;

public class ActSplash extends AppCompatActivity {
    private Activity activity;
    private Context context;
    private boolean isDependencyWait = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash);
        activity = this;
        context = this;
        /*RoundImage.onSayHi();
        MashUp.onSayHi();*/
        //RedirectWindow redirectWindow = new RedirectWindow(activity, context);
        String tag = "TEST_TAG";
        LogWriter.isDebug = true;
        LogWriter.Log("Test log log");
        LogWriter.Log(tag, "Test log log");
        LogWriter.dLog("Test log d");
        LogWriter.dLog(tag, "Test log d");
        LogWriter.eLog("Test log e");
        LogWriter.eLog(tag, "Test log e");
        LogWriter.iLog("Test log i");
        LogWriter.iLog(tag, "Test log i");
        LogWriter.vLog("Test log v");
        LogWriter.vLog(tag, "Test log v");
        LogWriter.wtfLog("Test log wtf");
        LogWriter.wtfLog(tag, "Test log wtf");
    }
}
//https://github.com/bintray/gradle-bintray-plugin/issues/88
//https://stackoverflow.com/questions/33668021/bintray-unable-to-upload-files-maven-group-artifact-or-version-defined-in-the
//https://www.petrikainulainen.net/programming/gradle/getting-started-with-gradle-creating-a-multi-project-build/
//https://docs.gradle.org/current/userguide/maven_plugin.html
//https://stackoverflow.com/questions/45078381/gradle-library-with-multiple-modules
