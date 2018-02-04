package com.rz.librarycore;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rz Rasel on 2018-01-09.
 */

public class ManifestPermission {
    private Activity activity;
    private Context context;
    public int PERMISSIONS_REQUEST_CODE;
    public List<String> lisPermissionsNeeded = new ArrayList<String>();
    public OnPermission onPermission = new OnPermission();

    public ManifestPermission(Activity argActivity, Context argContext, int argRequestCode) {
        this.activity = argActivity;
        this.context = argContext;
        this.PERMISSIONS_REQUEST_CODE = argRequestCode;
    }

    public boolean onCheckPermission() {
        boolean isPermissionGranted = true;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return isPermissionGranted;
        }
        //int permissionCheck = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_CALENDAR);
        /*int result = context.checkSelfPermission(argPermissionName);
        if (result != PackageManager.PERMISSION_GRANTED) {
            System.out.println("DEBUG_LOG_PLEASE_GRANTED: " + argPermissionName);
        }*/
        if (lisPermissionsNeeded.size() > 0) {
            for (String item : lisPermissionsNeeded) {
                int permissionResult = context.checkSelfPermission(item);
                if (permissionResult != PackageManager.PERMISSION_GRANTED) {
                    System.out.println("DEBUG_LOG_PLEASE_GRANTED_IN_MAINFEST: " + item);
                    isPermissionGranted = false;
                }
            }
        }
        return isPermissionGranted;
    }

    public void onRequestPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }
        if (lisPermissionsNeeded.size() > 0) {
            try {
                ActivityCompat.requestPermissions(activity, lisPermissionsNeeded.toArray(new String[lisPermissionsNeeded.size()]), PERMISSIONS_REQUEST_CODE);
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }

    private void showMessageOKCancel(String argMessage, DialogInterface.OnClickListener argOkListener) {
        new AlertDialog.Builder(activity)
                .setMessage(argMessage)
                .setPositiveButton("OK", argOkListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    public class OnPermission {
        /*OuterClass outer = new OuterClass();
        InnerClass inner = outer.new InnerClass();
        --Inner inner = new Outer().new Inner();*/
        public OnPermission() {
            //
        }

        public OnPermission onAddPermission(PERMISSION argPermission) {
            if (argPermission == PERMISSION.FINE_LOCATION) {
                lisPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
            } else if (argPermission == PERMISSION.READ_EXTERNAL_STORAGE) {
                lisPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            } else if (argPermission == PERMISSION.READ_CONTACTS) {
                lisPermissionsNeeded.add(Manifest.permission.READ_CONTACTS);
            } else if (argPermission == PERMISSION.RECEIVE_SMS) {
                lisPermissionsNeeded.add(Manifest.permission.RECEIVE_SMS);
            } else if (argPermission == PERMISSION.WRITE_CONTACTS) {
                lisPermissionsNeeded.add(Manifest.permission.WRITE_CONTACTS);
            }
            return this;
        }
    }

    public enum PERMISSION {
        FINE_LOCATION,
        READ_EXTERNAL_STORAGE,
        READ_CONTACTS,
        RECEIVE_SMS,
        WRITE_CONTACTS,
    }
}
//requestPermissions(permissionsList.toArray(new String[permissionsList.size()]), REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
//https://inthecheesefactory.com/blog/things-you-need-to-know-about-android-m-permission-developer-edition/en
//https://stackoverflow.com/questions/33407250/checkselfpermission-method-is-not-working-in-targetsdkversion-22