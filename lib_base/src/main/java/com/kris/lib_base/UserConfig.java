package com.kris.lib_base;

import android.content.Context;

import com.kris.lib_base.utils.PreferencesUtils;

public class UserConfig {

    public static final String TOKEN = "TOKEN";

    public static String getToken(Context context) {
        return PreferencesUtils.getUserString(context,TOKEN);
    }

    public static void putToken(Context context,String token) {
        PreferencesUtils.putUserString(context,TOKEN,token);
    }
}
