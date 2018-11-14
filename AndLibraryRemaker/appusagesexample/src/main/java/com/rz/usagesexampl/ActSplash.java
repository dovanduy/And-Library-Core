package com.rz.usagesexampl;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rz.mashup.MashUp;
import com.rz.roundimage.RoundImage;

public class ActSplash extends AppCompatActivity {
    private Activity activity;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash);
        activity = this;
        context = this;
        RoundImage.onSayHi();
        MashUp.onSayHi();
        //RedirectWindow redirectWindow = new RedirectWindow(activity, context);
        //Bundle bundle = new Bundle();
        RedirectWindow redirectWindow = RedirectWindow.getInstance(activity, context);
        redirectWindow.withRedirect(ActSplash.class);
        redirectWindow.withBundle(savedInstanceState)
                .withFlag()
                .runRedirect()
                .disposeWindow();
    }
}
//https://github.com/bintray/gradle-bintray-plugin/issues/88
//https://stackoverflow.com/questions/33668021/bintray-unable-to-upload-files-maven-group-artifact-or-version-defined-in-the
//https://www.petrikainulainen.net/programming/gradle/getting-started-with-gradle-creating-a-multi-project-build/
//https://docs.gradle.org/current/userguide/maven_plugin.html
//https://stackoverflow.com/questions/45078381/gradle-library-with-multiple-modules
