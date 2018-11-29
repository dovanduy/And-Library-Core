package com.rz.usagesexampl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rz.usagesexampl.working.utils.AppUtils;
import com.rz.usagesexampl.working.DateUtils;

import java.text.ParseException;


public class ActSplash extends AppCompatActivity {
    private Activity activity;
    private Context context;
    private String CLASS_NAME;
    private boolean isDependencyWait = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash);
        activity = this;
        context = this;
        CLASS_NAME = this.getClass().getName();
        onUsagesDateUtils();
    }

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

    private void onAppUtils() {
        AppUtils.getAppVersion(context);
        AppUtils.getAppVersionCode(context);
        AppUtils.logDebug("TAG", "MESSAGE");
        AppUtils.getDisplaySize(context);
        AppUtils.isURLAvailable("URL");
    }
}
//https://github.com/bintray/gradle-bintray-plugin/issues/88
//https://stackoverflow.com/questions/33668021/bintray-unable-to-upload-files-maven-group-artifact-or-version-defined-in-the
//https://www.petrikainulainen.net/programming/gradle/getting-started-with-gradle-creating-a-multi-project-build/
//https://docs.gradle.org/current/userguide/maven_plugin.html
//https://stackoverflow.com/questions/45078381/gradle-library-with-multiple-modules
