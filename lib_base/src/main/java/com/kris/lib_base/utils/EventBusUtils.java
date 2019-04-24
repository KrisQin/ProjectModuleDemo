package com.kris.lib_base.utils;

import android.content.Context;

import org.simple.eventbus.EventBus;

public class EventBusUtils {

    public static void register(Context context) {
        EventBus.getDefault().register(context);
    }

    public static void unregister(Context context) {
        EventBus.getDefault().unregister(context);
    }


}
