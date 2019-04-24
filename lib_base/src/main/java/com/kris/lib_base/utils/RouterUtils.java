package com.kris.lib_base.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;

public class RouterUtils {






    /**
     * 判断当前应用是否是debug状态
     */

    public static boolean isApkInDebug(Context context) {
        try {
            Log.d("xxx"," context: "+context);
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }


}
