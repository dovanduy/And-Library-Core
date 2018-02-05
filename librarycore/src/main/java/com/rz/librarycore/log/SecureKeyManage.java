package com.rz.librarycore.log;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.rz.librarycore.apppackage.APPStaticPackageInfo;
import com.rz.librarycore.certificate.CertificateSHA1Fingerprint;
import com.rz.librarycore.hardware.DeviceInfo;
import com.rz.librarycore.inetapi.DeviceIPApi;
import com.rz.librarycore.storage.SharePrefPrivateHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rz Rasel on 2018-02-05.
 */

public class SecureKeyManage {
    private Activity activity;
    private Context context;
    private SharePrefPrivateHandler onSharePreference;
    private SimpleDateFormat simpleDateFormat;
    private DeviceIPApi deviceIPApi;
    private DeviceInfo deviceInfo;
    private long asyncDelayTime = 1000 * 60 * 2; // 1000 * 60 * 2;
    private Message message = new Message();
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

    public SecureKeyManage(Activity argActivity, Context argContext) {
        activity = argActivity;
        context = argContext;
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        onSharePreference = new SharePrefPrivateHandler(context, APPStaticPackageInfo.getPackageName(context));
        asyncDelayTime = 1000 * 30;
        asyncHandler.sendEmptyMessage(0);
    }

    Thread asyncThread = new Thread(new Runnable() {
        @Override
        public void run() {
            //message = new Message();
            Bundle bundle = new Bundle();
            Integer value = 1;
            bundle.putInt("KEY", value);
            message.setData(bundle);
            //message.what = 1;
            asyncHandler.sendMessage(message);
        }
    });
    Handler asyncHandler = new Handler() {
        @Override
        public void handleMessage(Message argMessage) {
            Bundle bundle = argMessage.getData();
            if (argMessage.what == 0) {
                //updateUI();
                onSecurityKeyInitialization();
                onSharePreference.printAllKeyValue();
                LogWriter.Log("GET 0");
                message = new Message();
                message.what = 1;
            } else {
                //showErrorDialog();
                LogWriter.Log("GET OTHER " + argMessage.what);
                message = new Message();
                message.what = 0;
            }
            this.postDelayed(asyncThread, asyncDelayTime);
        }
    };

    private void onSecurityKeyInitialization() {
        Object objHardIp = onSharePreference.getValue(KeyDeviceHardWareIp);
        if (objHardIp == null) {
            //LogWriter.Log("IP is: " + objHardIp.toString());
            LogWriter.Log("Hardware IP is null.");
            onSetPrivateData();
            onSetDeviceData();
        } else {
            try {
                Object objSecurityEntryDate = onSharePreference.getValue(KeySecurityEntryDate);
                Object objForceUpdate = onSharePreference.getValue(KeyPDataForceUpdate);
                    /*Date date = new Date();
                    long HOUR = 60 * 60 * 25;
                    Date nowDate = new Date(date.getTime() + HOUR);
                    DateTime dt = new DateTime();
                    DateTime added = dt.plusHours(6);*/
                    /*Calendar calendar = Calendar.getInstance();
                    calendar.setTime(new Date());
                    calendar.add(Calendar.HOUR_OF_DAY, 24);
                    Date nowDate = new Date(calendar.getTimeInMillis());
                    long diffInMillis = Math.abs(nowDate.getTime() - lastSyncDate.getTime());*/
                //long dayDiff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                Date lastSyncDate = simpleDateFormat.parse(objSecurityEntryDate.toString());
                Date nowDate = new Date();
                long diffInMillis = Math.abs(nowDate.getTime() - lastSyncDate.getTime());
                long hourDiff = TimeUnit.HOURS.convert(diffInMillis, TimeUnit.MILLISECONDS);
                boolean isForceUpdate = (Boolean) objForceUpdate;
                LogWriter.Log("Sync:-" + objSecurityEntryDate.toString()
                        + "-" + hourDiff + "-HOUR-"
                        + simpleDateFormat.format(nowDate) + "-Is Force-" + isForceUpdate);
                if (hourDiff > 12 || isForceUpdate) {
                    onSetPrivateData();
                    onSetDeviceData();
                }
                //http://www.baeldung.com/java-date-difference
            } catch (ParseException e) {
                //e.printStackTrace();
                LogWriter.Log("Error: " + e);
            }
            //onSharePreference.printAllKeyValue();
        }
    }

    private void onSetPrivateData() {
        deviceIPApi = new DeviceIPApi(context);
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
                .setValue(KeyDeviceNetLatitude, argResult.get("latitude"))
                .setValue(KeyDeviceNetLongitude, argResult.get("longitude"))
                .setValue(KeyDeviceNetCountry, argResult.get("country"))
                .setValue(KeyPDataForceUpdate, false)
                .setValue(KeyPrivateDataDate, simpleDateFormat.format(new Date()));
        LogWriter.Log("UPDATE DATE TIME: " + simpleDateFormat.format(new Date()));
    }

    private void onSetDeviceData() {
        CertificateSHA1Fingerprint certAuthKey = CertificateSHA1Fingerprint.getInstance();
        deviceInfo = new DeviceInfo(activity, context);
        onSharePreference.setValue(KeyDeviceBuildId, deviceInfo.getDeviceBuildID())
                .setValue("app_package_name", APPStaticPackageInfo.getPackageName(context))
                .setValue("app_version_code", APPStaticPackageInfo.getVersionCode(context))
                .setValue("app_version_name", APPStaticPackageInfo.getVersionName(context))
                .setValue("app_auth_key", certAuthKey.getAuthKey(context))
                .setValue(KeyDeviceAndroidId, deviceInfo.getDeviceID());
    }
}
