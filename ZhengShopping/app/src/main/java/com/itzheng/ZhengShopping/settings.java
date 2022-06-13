package com.itzheng.ZhengShopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.itzheng.ZhengShopping.utils.MyApplication;

import ZhengShopping.R;

//设置
public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

    }
    public void address(View view){
        Intent it=new Intent();
        it.setClass(settings.this,DizhiActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
    }
    public void logout(View view){
        Intent it=new Intent();
        it.setClass(settings.this,MainActivity.class);
        startActivity(it);
        finish();
    }
    public void quit(View view){
        System.exit(0);
        moveTaskToBack(true);//将Activity退到后台，注意不是finish()退出。
    }
}
