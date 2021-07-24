package com.ribisoft.gapodemo.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

public class DeviceUtil {

    public static DeviceUtil instance;
    private static DisplayMetrics displayMetrics;

    public static DeviceUtil getInstance() {
        if (instance == null) {
            instance = new DeviceUtil();
        }
        return instance;
    }

    public void initSizeScreen(Activity activity) {
        displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        if (displayMetrics == null) {
            displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public int getWidthScreen(Context context) {
        if (context == null || getDisplayMetrics(context) != null) {
            return getDisplayMetrics(context).widthPixels;
        }
        return 0;
    }

    public int getHeightScreen(Context context) {
        if (context == null || getDisplayMetrics(context) != null) {
            return getDisplayMetrics(context).heightPixels;
        }
        return 0;
    }


}
