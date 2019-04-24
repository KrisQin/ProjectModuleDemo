package com.kris.module_user;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.kris.lib_base.bean.UserBean;
import com.kris.lib_base.utils.EvenBusTag;
import com.kris.lib_base.utils.EventBusUtils;
import com.kris.lib_base.utils.RouteUtils;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

@Route(path = RouteUtils.User_Activity)
public class UserActivity extends Activity {

    private RelativeLayout mRoot_layout;
    int count = 0;
    private TextView mShow_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity);

        EventBusUtils.register(this);

        mRoot_layout = findViewById(R.id.root_layout);

        mShow_info = findViewById(R.id.show_info);

        findViewById(R.id.back_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backHome();
            }
        });


        findViewById(R.id.click_eventbus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEventBus();
            }
        });

        TextView usr_bean = findViewById(R.id.usr_bean);

        UserBean userBean = getIntent().getParcelableExtra("USER");

        if(userBean != null) {
            usr_bean.setText(userBean.getName()+"  的年龄为  "+userBean.getAge());
        }

//        if (bundle != null) {
//            UserBean userBean = bundle.getParcelable("USER");
//            if(userBean != null) {
//                usr_bean.setText(userBean.getName()+"  的年龄为  "+userBean.getAge());
//            }
//
//        }
    }

    private void sendEventBus() {
        EventBus.getDefault().post("名字 --> "+count++, EvenBusTag.GOTO_EVENTBUS);
    }

    private void backHome() {
        ARouter.getInstance().build(RouteUtils.Home_Activity).navigation();


        if (Build.VERSION.SDK_INT >= 16) {
//            ActivityOptionsCompat compat = ActivityOptionsCompat.
//                    makeScaleUpAnimation(mRoot_layout,
//                            mRoot_layout.getWidth() / 2,
//                            mRoot_layout.getHeight() / 2, 0, 0);

            ActivityOptionsCompat compat = ActivityOptionsCompat.
                    makeScaleUpAnimation(mRoot_layout,
                            0,
                            mRoot_layout.getHeight() / 2, 0, 0);


            ARouter.getInstance()
                    .build(RouteUtils.Home_Activity)
                    .withOptionsCompat(compat)
                    .setTimeout(2000)
                    .navigation();
        } else {
//            T.showToast("API < 16,不支持新版本动画");
        }
    }

    @Subscriber(tag = EvenBusTag.GOTO_EVENTBUS)
    public void onEvent(String s) {
        mShow_info.setText(s);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusUtils.unregister(this);
    }
}
