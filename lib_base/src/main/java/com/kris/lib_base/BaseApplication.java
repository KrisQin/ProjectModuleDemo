package com.kris.lib_base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.kris.lib_base.utils.RouterUtils;

public class BaseApplication extends Application {


    private static BaseApplication mInstance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initRouter(this);
//        getToken();
    }

    public String getToken() {

        UserConfig.putToken(this,"token_1111111111111111111");
        return "token_1111111111111111111";
    }

    private void initRouter(BaseApplication application) {
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (RouterUtils.isApkInDebug(mInstance)) {
            //打印日志
            ARouter.openLog();
            //开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！
            //线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(application);

    }



    public static BaseApplication getInstance() {

        return mInstance;
    }
}
