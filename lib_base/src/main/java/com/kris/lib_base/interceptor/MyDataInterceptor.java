package com.kris.lib_base.interceptor;


import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

public class MyDataInterceptor implements IInterceptor {


    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {

        if (postcard.getGroup().equals("needlogin")) {
//            callback.onContinue(postcard);
//            callback.onInterrupt(null);
//            postcard.withString("extra","拦截器的参数");
//            callback.onContinue(postcard);
//            callback.onInterrupt(null);
//            ARouter.getInstance()
//                    .build(RouteUtils.Me_Login)
//                    .navigation( );

        }
    }

    @Override
    public void init(Context context) {

    }
}
