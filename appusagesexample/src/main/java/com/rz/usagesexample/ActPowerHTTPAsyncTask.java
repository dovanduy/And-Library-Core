package com.rz.usagesexample;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rz.librarycore.apppackage.APPStaticPackageInfo;
import com.rz.librarycore.http.HTTPMethod;
import com.rz.librarycore.http.OnFeedHTTPEventListenerHandler;
import com.rz.librarycore.http.PowerFeedHTTPAsyncTask;
import com.rz.librarycore.log.LogWriter;
import com.rz.librarycore.log.SecureKeyManager;
import com.rz.librarycore.storage.SharePrefPrivateHandler;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class ActPowerHTTPAsyncTask extends AppCompatActivity {
    private Activity activity;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_power_httpasync_task);
        activity = this;
        context = this;
        /////
        //////////////
        //onGetMethodOne();
        //////////////
        //onGetMethodTwo();
        //////////////
        onPostMethodOne();
        //////////////
    }

    public static class PrepareHTTPRequest {
        private Context context;
        //private HashMap<String, String> mapConstantParameters = new HashMap<>();

        public PrepareHTTPRequest(Context argContext) {
            context = argContext;
        }

        public void onExecute() {
            //
        }

        public static HashMap<String, String> getURLPostParameters(Context argContext) {
            Format staticFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            HashMap<String, String> urlRequestParameters = new HashMap<>();
            SharePrefPrivateHandler statPreferences = null;
            statPreferences = new SharePrefPrivateHandler(argContext, APPStaticPackageInfo.getPackageName(argContext));
            urlRequestParameters.put("auth_key", statPreferences.getValue(SecureKeyManager.KeyAppAuthKey) + "");
            urlRequestParameters.put("package_name", APPStaticPackageInfo.getPackageName(argContext));
            urlRequestParameters.put("app_version_code", APPStaticPackageInfo.getVersionCode(argContext) + "");
            urlRequestParameters.put("app_version_name", APPStaticPackageInfo.getVersionName(argContext));
            urlRequestParameters.put("app_global_ip", statPreferences.getValue(SecureKeyManager.KeyDeviceGlobalNetIp) + "");
            urlRequestParameters.put("app_hardware_ip", statPreferences.getValue(SecureKeyManager.KeyDeviceHardWareIp) + "");
            urlRequestParameters.put("app_net_lat", statPreferences.getValue(SecureKeyManager.KeyDeviceNetLatitude) + "");
            urlRequestParameters.put("app_net_lng", statPreferences.getValue(SecureKeyManager.KeyDeviceNetLongitude) + "");
            urlRequestParameters.put("app_net_country", statPreferences.getValue(SecureKeyManager.KeyDeviceNetCountry) + "");
            urlRequestParameters.put("app_primary_id", statPreferences.getValue(SecureKeyManager.KeyDevicePrimaryId) + "");
            urlRequestParameters.put("app_secondary_id", statPreferences.getValue(SecureKeyManager.KeyDeviceSecondaryId) + "");
            urlRequestParameters.put("app_request_time", staticFormat.format(new Date()));
            return urlRequestParameters;
        }
    }

    private void onPostMethodOne() {
        SharePrefPrivateHandler sharePrefHandler = new SharePrefPrivateHandler(context, APPStaticPackageInfo.getPackageName(context));
        HashMap<String, String> urlHeaders = new HashMap<String, String>();
        HashMap<String, String> urlRequestParameters = new HashMap<String, String>();
        /*urlHeaders.put("head1", "headeValue1");
        urlHeaders.put("head2", "headeValue2");*/
        /*urlRequestParameters.put("auth_key_test", sharePrefHandler.getValue(SecureKeyManager.KeyAppAuthKey) + "");
        urlRequestParameters.put("package_name_test", APPStaticPackageInfo.getPackageName(context));
        urlRequestParameters.put("app_version_code_test", APPStaticPackageInfo.getVersionCode(context) + "");
        urlRequestParameters.put("app_version_name_test", APPStaticPackageInfo.getVersionName(context));*/
        urlRequestParameters.putAll(PrepareHTTPRequest.getURLPostParameters(context));
        PowerFeedHTTPAsyncTask powerFeedHTTPAsyncTask = new PowerFeedHTTPAsyncTask(new OnFeedHTTPEventListenerHandler() {
            @Override
            public void onPreExecute() {
            }

            @Override
            public Object doInBackground(String... argURLParams) {
                LogWriter.Log("RETURNED_VALUE: " + String.valueOf(argURLParams));
                if (argURLParams instanceof String[]) {
                    /*String[] strArray = (String[]) argURLParams;
                    System.out.println("RETURNED_VALUE********: " + Arrays.toString(strArray));*/
                    String[] strArray = (String[]) argURLParams;
                    //String urlData = Arrays.toString(strArray);
                    String urlData = strArray[0];
                    System.out.println("RETURNED_VALUE_DO_IN_BACK: " + urlData);
                    // System.out.println(obj);
                    //onJSONParse(urlData);
                    // System.out.println(obj);
                }
                return "i call again";
            }

            @Override
            public void onPostExecute(Object argResult) {
                //LogWriter.Log("onPostExecute: " + Arrays.toString(argResult) + "");
                if (argResult instanceof String[]) {
                    String[] strArray = (String[]) argResult;
                    System.out.println("RETUREND_VALUE********: " + Arrays.toString(strArray));
                    //System.out.println(obj);
                }
                LogWriter.Log("onPostExecute: " + argResult + "");
            }

            @Override
            public void onProgressUpdate(Integer... argProgressValue) {
            }

            @Override
            public void onCancelled() {
            }
        });
        powerFeedHTTPAsyncTask
                .setHTTPMethod(HTTPMethod.POST)
                .setUrlHeader(urlHeaders)
                .setURLParameters(urlRequestParameters)
                .onExecute(context, "http://jagoron24.com/app-tv-bangla-url.php");
    }

    private void onGetMethodOne() {
        PowerFeedHTTPAsyncTask powerFeedHTTPAsyncTask = new PowerFeedHTTPAsyncTask();
        powerFeedHTTPAsyncTask.onExecute(context, "http://jagoron24.com/");
    }

    private void onGetMethodTwo() {
        PowerFeedHTTPAsyncTask powerFeedHTTPAsyncTask = new PowerFeedHTTPAsyncTask(new OnFeedHTTPEventListenerHandler() {
            @Override
            public void onPreExecute() {
            }

            @Override
            public Object doInBackground(String... argURLParams) {
                LogWriter.Log("RETURNED_VALUE: " + String.valueOf(argURLParams));
                if (argURLParams instanceof String[]) {
                    String[] strArray = (String[]) argURLParams;
                    System.out.println("RETURNED_VALUE: " + Arrays.toString(strArray));
                    // System.out.println(obj);
                }
                return argURLParams;
            }

            @Override
            public void onPostExecute(Object argResult) {
                LogWriter.Log("onPostExecute" + argResult + "");
            }

            @Override
            public void onProgressUpdate(Integer... argProgressValue) {
            }

            @Override
            public void onCancelled() {
            }
        });
        powerFeedHTTPAsyncTask.onExecute(context, "https://raw.githubusercontent.com/rzrasel/And-Library-Core/master/appusagesexample/src/main/assets/PowerFeedHTTP.html");
    }
}
