package com.kris.projectmoduledemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.kris.lib_base.utils.FragmentUtils;

/**
 * 参考：https://blog.csdn.net/huangxiaoguo1/article/details/78753555
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button home = (Button)findViewById(R.id.home);
        Button content = (Button)findViewById(R.id.content);
        Button user = (Button)findViewById(R.id.user);


        click(home, FragmentUtils.getHomeFragment());
        click(content, FragmentUtils.getContentFragment());
        click(user,FragmentUtils.getUsertFragment());

//        click(home,new HomeFragment());
//        click(content,ContentActivity.class,"显示内容");
//        click(user,new UserFragment());

    }

//    private void test() {
//        Properties properties = new Properties();
//        try {
//
//            properties.load(getAssets().open("gradle.properties"));
//
//            String isProModuless = properties.getProperty("isProModule");
//
//
//            boolean isProModule = isProModuless.equals("true");
//
//            Log.d("xxx","isProModule.toBoolean(): "+isProModule.toBoolean());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private void click(Button home,final Class clazz,final String content) {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,clazz);
                intent.putExtra("CONTENT",content);
                startActivity(intent);
            }
        });
    }

    private void click(Button home,final Fragment fragment) {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replace(fragment,R.id.layout_ded);
            }
        });
    }

    public void replace(Fragment fragment, int id){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }
}
