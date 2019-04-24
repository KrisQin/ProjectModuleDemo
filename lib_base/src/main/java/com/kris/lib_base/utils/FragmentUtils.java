package com.kris.lib_base.utils;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;

public class FragmentUtils {


    public static Fragment getHomeFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouteUtils.Home_Fragment_Main).navigation();
        return fragment;
    }

    public static Fragment getUsertFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouteUtils.User_Fragment_Main).navigation();
        return fragment;
    }

    public static Fragment getContentFragment() {
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouteUtils.Content_Fragment_Main).navigation();
        return fragment;
    }




}
