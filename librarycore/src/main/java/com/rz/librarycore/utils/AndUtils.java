package com.rz.librarycore.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class AndUtils {
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
}
