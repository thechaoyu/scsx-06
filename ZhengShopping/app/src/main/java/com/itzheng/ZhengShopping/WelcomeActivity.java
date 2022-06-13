package com.itzheng.ZhengShopping;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import ZhengShopping.R;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //欢迎页的占据全屏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        startMainActivity();  //延时操作
    }


    private void startMainActivity(){
        Handler mhander = new Handler();
        //创建一个Hander利用hander的postDelayed进行延时操作.
        mhander.postDelayed(new Runnable() { //新开一个线程
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                //页面跳转
                WelcomeActivity.this.finish();
                //本页面进行销毁
            }
        },2000);
        //延时操作的时间(毫秒)
    }
}
