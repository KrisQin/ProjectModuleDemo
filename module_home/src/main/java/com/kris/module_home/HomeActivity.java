package com.kris.module_home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.kris.lib_base.bean.UserBean;
import com.kris.lib_base.utils.RouteUtils;

@Route(path = RouteUtils.Home_Activity)
public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        findViewById(R.id.find_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findUser();
            }
        });
    }

    private void findUser() {
        UserBean user = new UserBean();
        user.setAge(18);
        user.setName("丽丽");

        ARouter.getInstance()
                .build(RouteUtils.User_Activity)
                .withParcelable("USER",user)
                .navigation();

        //类似startActivityForResult()
//        ARouter.getInstance().build(RouteUtils.User_Activity).navigation(this, 666);
    }

    //另一个页面的返回数据：
//     Intent intent = new Intent();
//     intent.putExtra("name","ForResult返回的数据");
//     setResult(999,intent);
//     finish();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 666:
                String name = data.getStringExtra("name");
                break;
            default:
                break;
        }
    }

    // 跳转并携带参数,基本涵盖所以类型传递，具体可以查看Postcard类
    //传递过去的值使用getIntent()接收
    //在fragment中无法使用ForResult进行夸模块传递数据
    //在activity中可以（详细请看LoginActivity）这里的EventBusBean 已经实现了Parcelable接口
//    EventBusBean eventBusBean = new EventBusBean();
//            eventBusBean.setProject("android");
//            eventBusBean.setNum(3);
//
//            ARouter.getInstance().build(RouteUtils.Me_EventBus)
//                    .withString("name", "haungxiaoguo")
//                    .withLong("age", 25)
//                    .withParcelable("eventbus", eventBusBean)
//                    .navigation();
}
