
package com.kris.module_content;

import android.app.Activity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.kris.lib_base.utils.RouteUtils;

@Route(path = RouteUtils.Content_Activity)
public class ContentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_activity);

//        TextView tv_title = findViewById(R.id.tv_title);
//        TextView token = findViewById(R.id.token);
//
//
//        tv_title.setText(getIntent().getStringExtra("CONTENT"));
//        token.setText(UserConfig.getToken(this));
//
//
//        BaseApplication.getInstance();
//
//
//        ContentApplication.getInstance().getToken();

    }
}
