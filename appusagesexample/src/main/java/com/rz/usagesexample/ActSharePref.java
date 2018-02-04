package com.rz.usagesexample;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rz.librarycore.apppackage.APPStaticPackageInfo;
import com.rz.librarycore.hardware.DeviceInfo;
import com.rz.librarycore.inetapi.DeviceIPApi;
import com.rz.librarycore.log.LogWriter;
import com.rz.librarycore.storage.SharePrefPrivateHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ActSharePref extends AppCompatActivity {
    private Activity activity;
    private Context context;
    private SharePrefPrivateHandler sharePrefHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_share_pref);
        activity = this;
        context = this;
        LogWriter.Log(APPStaticPackageInfo.getPackageName(context));
        sharePrefHandler = new SharePrefPrivateHandler(context, APPStaticPackageInfo.getPackageName(context));
        //sharePrefHandler.clearAll();
        //sharePrefHandler.setValue("test", "Test");
        new InitializeSecurity(activity, context);
        sharePrefHandler.printAllKeyValue();
        /*DeviceInfo deviceInfo = new DeviceInfo(activity, context);
        LogWriter.Log(deviceInfo.getDeviceBuildID());
        LogWriter.Log(deviceInfo.getDeviceID());
        LogWriter.Log(deviceInfo.getDeviceUUID(1010));*/
    }

    //Initialization
    public class InitializeSecurity {
        private Activity activity;
        private Context context;
        private SharePrefPrivateHandler onSharePreference;
        private SimpleDateFormat simpleDateFormat;
        private DeviceIPApi deviceIPApi;
        private DeviceInfo deviceInfo;
        public final static String KeyDeviceHardWareIp = "device_hardware_ip";
        public final static String KeyDeviceGlobalNetIp = "device_global_net_ip";
        public final static String KeyDeviceBuildId = "device_build_id";
        public final static String KeyDeviceAndroidId = "device_android_id";
        public final static String KeyDeviceNetLatitude = "device_net_latitude";
        public final static String KeyDeviceNetLongitude = "device_net_longitude";
        public final static String KeyDeviceNetCountry = "device_net_country";
        public final static String KeyPrivateDataDate = "private_data_date";
        public final static String KeyPDataForceUpdate = "is_private_data_force_update";
        public final static String KeySecurityEntryDate = "security_entry_date";
        public final static String KeyFCMId = "fcm_id";
        public String ValSecureHardIp = "";

        public InitializeSecurity(Activity argActivity, Context argContext) {
            activity = argActivity;
            context = argContext;
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            onSharePreference = new SharePrefPrivateHandler(context, APPStaticPackageInfo.getPackageName(context));
            Object objHardIp = onSharePreference.getValue(KeyDeviceHardWareIp);
            if (objHardIp == null) {
                //LogWriter.Log("IP is: " + objHardIp.toString());
                onSetPrivateData();
            } else {
                try {
                    Object objSecurityEntryDate = onSharePreference.getValue(KeySecurityEntryDate);
                    Date lastSyncDate = simpleDateFormat.parse(objSecurityEntryDate.toString());
                    Date nowDate = new Date();
                    long diffInMillies = Math.abs(nowDate.getTime() - lastSyncDate.getTime());
                    long dayDiff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                    LogWriter.Log(dayDiff + " dayDIFFF");
                } catch (ParseException e) {
                    //e.printStackTrace();
                    LogWriter.Log("Error: " + e);
                }
            }
        }

        private void onSetPrivateData() {
            deviceIPApi = new DeviceIPApi(context);
            deviceInfo = new DeviceInfo(activity, context);
            deviceIPApi.getApparentIPAddress(new DeviceIPApi.OnHTTPIPEventListenerHandler() {
                @Override
                public void onPostExecute(HashMap<String, String> argResult) {
                    //LogWriter.Log(argResult.toString());
                    onPrivateDataEntry(argResult);
                    onSharePreference.setValue(KeySecurityEntryDate, simpleDateFormat.format(new Date()));
                }
            });
        }

        private void onPrivateDataEntry(HashMap<String, String> argResult) {
            onSharePreference.setValue(KeyDeviceHardWareIp, deviceIPApi.getInterfaceIPAddress())
                    .setValue(KeyDeviceGlobalNetIp, argResult.get("ip"))
                    .setValue(KeyDeviceBuildId, deviceInfo.getDeviceBuildID())
                    .setValue(KeyDeviceAndroidId, deviceInfo.getDeviceID())
                    .setValue(KeyDeviceNetLatitude, argResult.get("latitude"))
                    .setValue(KeyDeviceNetLongitude, argResult.get("longitude"))
                    .setValue(KeyDeviceNetCountry, argResult.get("country"))
                    .setValue(KeyPDataForceUpdate, false)
                    .setValue(KeyPrivateDataDate, simpleDateFormat.format(new Date()));
        }

    }
}
