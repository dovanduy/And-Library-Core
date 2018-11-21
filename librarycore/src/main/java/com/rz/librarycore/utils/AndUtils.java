package com.rz.librarycore.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Spanned;

public class AndUtils {
    public static Spanned fromHtml(String argValue) {
        if (isNullOrEmpty(argValue)) {
            return null;
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            return Html.fromHtml(argValue, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(argValue);
        }
    }

    public static int getDrawableId(Context argContext, String argName) {
        Resources resources = argContext.getResources();
        int resourceId = resources.getIdentifier(argName, "drawable", argContext.getPackageName());
        return resourceId;
    }

    public static Drawable getDrawable(Context argContext, String argName) {
        Resources resources = argContext.getResources();
        int resourceId = resources.getIdentifier(argName, "drawable", argContext.getPackageName());
        return resources.getDrawable(resourceId);
    }

    public static int getRawId(Context argContext, String argName) {
        Resources resources = argContext.getResources();
        int resourceId = resources.getIdentifier(argName, "raw", argContext.getPackageName());
        return resourceId;
    }
    private static boolean isNullOrEmpty(String argValue) {
        if (argValue == null) {
            return true;
        }
        if (argValue.trim().isEmpty()) {
            return true;
        }
        if (argValue.equalsIgnoreCase("null")) {
            return true;
        }
        return false;
    }
}
