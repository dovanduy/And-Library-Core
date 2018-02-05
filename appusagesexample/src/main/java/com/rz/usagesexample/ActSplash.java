package com.rz.usagesexample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rz.librarycore.apppackage.APPStaticPackageInfo;
import com.rz.librarycore.http.HTTPMethod;
import com.rz.librarycore.http.OnFeedHTTPEventListenerHandler;
import com.rz.librarycore.http.PowerFeedHTTPAsyncTask;
import com.rz.librarycore.log.LogWriter;
import com.rz.librarycore.log.SecureKeyManager;
import com.rz.librarycore.storage.SharePrefPrivateHandler;

import java.util.Arrays;
import java.util.HashMap;

public class ActSplash extends AppCompatActivity {
    private Activity activity;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash);
        activity = this;
        context = this;
        /////
        /////
        SharePrefPrivateHandler sharePrefHandler = new SharePrefPrivateHandler(context, APPStaticPackageInfo.getPackageName(context));
        //sharePrefHandler.clearAll();
        //sharePrefHandler.setValue("is_private_data_force_update", true);
        SecureKeyManager.onSetAppIsRunFirstTime(context);
        /////
        startActivity(new Intent(context, ActSharePref.class));
        finish();
        /////
        HashMap<String, String> urlHeaders = new HashMap<String, String>();
        HashMap<String, String> urlRequestParameters = new HashMap<String, String>();
        /*urlHeaders.put("head1", "headeValue1");
        urlHeaders.put("head2", "headeValue2");*/
        urlRequestParameters.put("auth_key", "paramValue1");
        urlRequestParameters.put("package_name", "me.apphive.doordekhaetui");
        urlRequestParameters.put("app_version", "201712.0.4");
        /*powerFeedHTTPAsyncTask
                .setHTTPMethod(HTTPMethod.POST)
                .setUrlHeader(urlHeaders)
                .setURLParameters(urlRequestParameters)
                .onExecute(context, "http://jagoron24.com/app-tv-bangla-url.php");*/
    }

    PowerFeedHTTPAsyncTask powerFeedHTTPAsyncTask = new PowerFeedHTTPAsyncTask(new OnFeedHTTPEventListenerHandler() {
        @Override
        public void onPreExecute() {
        }

        @Override
        public Object doInBackground(String... argURLParams) {
            LogWriter.Log("RETURNED_VALUE: " + String.valueOf(argURLParams));
            if (argURLParams instanceof String[]) {
                String[] strArray = (String[]) argURLParams;
                System.out.println("RETURNED_VALUE********: " + Arrays.toString(strArray));
                // System.out.println(obj);
            }
            return argURLParams;
        }

        @Override
        public void onPostExecute(Object argResult) {
            //LogWriter.Log("onPostExecute: " + Arrays.toString(argResult) + "");
        }

        @Override
        public void onProgressUpdate(Integer... argProgressValue) {
        }

        @Override
        public void onCancelled() {
        }
    });
}
