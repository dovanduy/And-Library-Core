package com.rz.librarycore;

import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

/**
 * Created by Rz Rasel on 2018-01-09.
 */

public class CheckLocationEnabled {

    public static boolean isLocationEnabled(Context argContext) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int locationMode = Settings.Secure.getInt(argContext.getContentResolver(), Settings.Secure.LOCATION_MODE, 0);
            return locationMode != Settings.Secure.LOCATION_MODE_OFF;
        } else {
            String locationProviders = Settings.Secure.getString(argContext.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
            return !TextUtils.isEmpty(locationProviders);
        }
    }

    public static boolean isGPSEnabled(Context argContext) {
        LocationManager locationManager = (LocationManager) argContext.getSystemService(Context.LOCATION_SERVICE);
        boolean GPSStatus = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        return GPSStatus;
    }

    public static boolean isLocationEnabledFromAPI19(Context argContext) {
        int locationMode = Settings.Secure.getInt(argContext.getContentResolver(), Settings.Secure.LOCATION_MODE, 0);

        return locationMode != Settings.Secure.LOCATION_MODE_OFF;
    }
}
