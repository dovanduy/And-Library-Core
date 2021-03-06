package com.rz.usagesexampl.hardware;

/**
 * Created by Rz Rasel on 2017-08-23.
 */

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.UUID;

public class DeviceInfo {
    private Activity activity;
    private Context context;

    public DeviceInfo(Activity argActivity, Context argContext) {
        this.activity = argActivity;
        this.context = argContext;
    }

    public HashMap<String, String> getAllMappedValue() {
        HashMap<String, String> deviceInfoList = new HashMap<String, String>();
        deviceInfoList.put("device_id", getDeviceID());
        deviceInfoList.put("device_build_id", getDeviceBuildID());
        deviceInfoList.put("device_test_id", getTestDeviceID());
        deviceInfoList.put("device_build_brand", getDeviceBuildBrand());
        deviceInfoList.put("device_build_model", getDeviceBuildModel());
        deviceInfoList.put("device_build_user", getDeviceBuildUser());
        deviceInfoList.put("device_build_product", getDeviceBuildProduct());
        deviceInfoList.put("device_build_serial", getDeviceSerialNumber());
        deviceInfoList.put("device_build_hardware", getDeviceBuildHardware());
        deviceInfoList.put("device_build_version", getDeviceBuildVersion());
        deviceInfoList.put("device_build_sdk_version", getDeviceBuildSDKVersion());
        return deviceInfoList;
    }

    public void DeviceInfoOne(Activity argActivity, Context argContext) {
        this.activity = argActivity;
        this.context = argContext;
        //telephonyManager.getDeviceId();
        String androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        System.out.println("::::::::::::::::::::::::::::::Android_ID:-" + androidId);
        System.out.println("::::::::::::::::::::::::::::::Android_Build_ID:-" + android.os.Build.ID);
        int REQUEST_READ_PHONE_STATE_PERMISSION = 100;
        String teleManagerDeviceID = "";
        String teleManagerDeviceSerial = "";
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        int permissionCheck = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_READ_PHONE_STATE_PERMISSION);
        } else {
            /*teleManagerDeviceID = telephonyManager.getDeviceId();
            teleManagerDeviceSerial = "" + telephonyManager.getSimSerialNumber();
            System.out.println("::::::::::::::::::::::::::::::Android_Tele_Device_ID:-" + teleManagerDeviceID);
            System.out.println("::::::::::::::::::::::::::::::Android_Tele_Device_Serial-" + teleManagerDeviceSerial);*/
        }

        UUID deviceUuid = new UUID(androidId.hashCode(), ((long) teleManagerDeviceID.hashCode() << 32) | teleManagerDeviceSerial.hashCode());
        String deviceId = deviceUuid.toString();
        System.out.println("::::::::::::::::::::::::::::::Android_UUID_ID:-" + deviceId);
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        deviceId = wifiManager.getConnectionInfo().getMacAddress();
        System.out.println("::::::::::::::::::::::::::::::Android_Wifi_ID:-" + deviceId);
        deviceId = UUID.randomUUID().toString();
        System.out.println("::::::::::::::::::::::::::::::Android_UUID_Random_ID:-" + deviceId);
        //--------------------------------------
        String deviceBRAND = android.os.Build.BRAND;
        System.out.println("::::::::::::::::::::::::::::::Android_BRAND_ID:-" + deviceBRAND);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String deviceModelName = android.os.Build.MODEL;
        Log.v("Model Name", "" + deviceModelName);
        String deviceUSER = android.os.Build.USER;
        Log.v("Name USER", "" + deviceUSER);
        String devicePRODUCT = android.os.Build.PRODUCT;
        Log.v("PRODUCT", "" + devicePRODUCT);
        String deviceHARDWARE = android.os.Build.HARDWARE;
        Log.v("HARDWARE", "" + deviceHARDWARE);
        //String deviceBRAND = android.os.Build.BRAND;
        Log.v("BRAND", "" + deviceBRAND);
        String myVersion = android.os.Build.VERSION.RELEASE;
        Log.v("VERSION.RELEASE", "" + myVersion);
        int sdkVersion = android.os.Build.VERSION.SDK_INT;
        Log.v("VERSION.SDK_INT", "" + sdkVersion);

            /*List<NetworkInterface> interfacesList = null;
            try {
                interfacesList = Collections.list(NetworkInterface.getNetworkInterfaces());
                for (NetworkInterface networkInterface : interfacesList) {
                    // This will give you the interface MAC ADDRESS
                    deviceId = networkInterface.getHardwareAddress().toString();
                    System.out.println("::::::::::::::::::::::::::::::Android_ID:-" + deviceId);
                }
            } catch (SocketException e) {
                e.printStackTrace();
            }*/
        String android_id = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        deviceId = md5(android_id).toUpperCase();
            /*mAdRequest.addTestDevice(deviceId);
            boolean isTestDevice = mAdRequest.isTestDevice(this);*/
        //is Admob Test Device ? C148757B5D2F4FF25294A0A2CA699D76

        Log.v("TAG", "is Admob Test Device ? " + deviceId);
    }

    public String getDeviceID() {
        String deviceId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        return deviceId;
    }

    public String getDeviceBuildID() {
        String deviceId = android.os.Build.ID;
        return deviceId;
    }

    //@SuppressLint("MissingPermission")
    public String getDeviceSerialNumber() {
        String deviceId = Build.SERIAL;
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            deviceId = Build.getSerial();
        }*/
        //http://www.coderzheaven.com/2011/07/11/how-to-find-the-device-id-or-serial-number-of-an-android-device/
        return deviceId;
    }

    public String getTestDeviceID() {
        String deviceId = null;
        String androidID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        deviceId = md5(androidID).toUpperCase();
        return deviceId;
    }

    public String getDeviceUUID(int argRequestPermission) {
        UUID deviceUuid = null;
        int REQUEST_READ_PHONE_STATE_PERMISSION = argRequestPermission;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        int permissionCheck = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_READ_PHONE_STATE_PERMISSION);
        } else {
            /*teleManagerDeviceID = telephonyManager.getDeviceId();
            teleManagerDeviceSerial = "" + telephonyManager.getSimSerialNumber();
            System.out.println("::::::::::::::::::::::::::::::Android_Tele_Device_ID:-" + teleManagerDeviceID);
            System.out.println("::::::::::::::::::::::::::::::Android_Tele_Device_Serial-" + teleManagerDeviceSerial);*/
            String teleManagerDeviceID = "";
            String teleManagerDeviceSerial = "";
            String androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
            deviceUuid = new UUID(androidId.hashCode(), ((long) teleManagerDeviceID.hashCode() << 32) | teleManagerDeviceSerial.hashCode());
        }
        /*String teleManagerDeviceID = "";
        String teleManagerDeviceSerial = "";
        String androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        UUID deviceUuid = new UUID(androidId.hashCode(), ((long) teleManagerDeviceID.hashCode() << 32) | teleManagerDeviceSerial.hashCode());*/
        return deviceUuid.toString();
    }

    public String getDeviceBuildBrand() {
        String strDevice = android.os.Build.BRAND;
        return strDevice;
    }

    public String getDeviceBuildModel() {
        String strDevice = android.os.Build.MODEL;
        return strDevice;
    }

    public String getDeviceBuildUser() {
        String strDevice = android.os.Build.USER;
        return strDevice;
    }

    public String getDeviceBuildProduct() {
        String strDevice = android.os.Build.PRODUCT;
        return strDevice;
    }

    public String getDeviceBuildHardware() {
        String strDevice = android.os.Build.HARDWARE;
        return strDevice;
    }

    public String getDeviceBuildVersion() {
        String strDevice = android.os.Build.VERSION.RELEASE;
        return strDevice;
    }

    public String getDeviceBuildSDKVersion() {
        String strDevice = android.os.Build.VERSION.SDK_INT + "";
        return strDevice;
    }

    public String md5(String argValue) {
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(argValue.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String h = Integer.toHexString(0xFF & messageDigest[i]);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return "";
    }
        /*
        <uses-permission android:name="android.permission.READ_PHONE_STATE" />
        <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
        <uses-permission android:name="android.permission.INTERNET" />
        */
}
/*
com.sm.cmdss
::::::::::::::::::::::::::::::Android_ID:-3794e4e8ffe7eede
::::::::::::::::::::::::::::::Android_Build_ID:-M4B30Z
::::::::::::::::::::::::::::::Android_Tele_Device_ID:-353490061626335
::::::::::::::::::::::::::::::Android_Tele_Device_Serial-89880020609011661553
::::::::::::::::::::::::::::::Android_UUID_ID:-00000000-39b2-2674-e7e7-07ec32b2ddf2
::::::::::::::::::::::::::::::Android_Wifi_ID:-02:00:00:00:00:00
::::::::::::::::::::::::::::::Android_UUID_Random_ID:-f9f475a7-cede-480d-9ef9-4921e2ee489a
::::::::::::::::::::::::::::::Android_BRAND_ID:-google
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
V/Model Name: Nexus 5
V/Name USER: android-build
V/PRODUCT: hammerhead
V/HARDWARE: hammerhead
V/BRAND: google
V/VERSION.RELEASE: 6.0.1
V/VERSION.SDK_INT: 23
is Admob Test Device ? C148757B5D2F4FF25294A0A2CA699D76

Android_ID
Android_Build_ID
Android_UUID_ID
Test_Device
*/