package com.itzheng.ZhengShopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.itzheng.ZhengShopping.utils.MyApplication;

import ZhengShopping.R;

public class MyMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_main);
        MyApplication myApplication = (MyApplication) getApplication();
        String name = myApplication.getUser().getName();
        TextView username = findViewById(R.id.username);
        username.setText(name);

    }
    public void shouye(View view){
        finish();
        //startActivity(new Intent(getApplicationContext(),AdminActivity.class));
        Intent it=new Intent();
        it.setClass(MyMainActivity.this,AdminActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
    }

    public void weitao(View view){

        //startActivity(new Intent(getApplicationContext(),WeitaoActivity.class));
        finish();
        Intent it=new Intent();
        it.setClass(MyMainActivity.this,WeitaoActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
    }

    public void xiaoxi(View view){

        //startActivity(new Intent(getApplicationContext(),XiaoxiActivity.class));
        finish();
        Intent it=new Intent();
        it.setClass(MyMainActivity.this,XiaoxiActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
    }

    public void gouwuche(View view){
        //startActivity(new Intent(getApplicationContext(),CarActivity.class));
        finish();
        Intent it=new Intent();
        it.setClass(MyMainActivity.this,CarActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
    }


    public void unpaid(View view){

        //PaidActivity

        MyApplication myApplication = (MyApplication) getApplication();

        myApplication.setOrderstate("0");

        startActivity(new Intent(getApplicationContext(),PaidActivity.class));

    }
    public void paid(View view){

        //PaidActivity

        MyApplication myApplication = (MyApplication) getApplication();

        myApplication.setOrderstate("1");

        startActivity(new Intent(getApplicationContext(),OrderedActivity.class));

    }

    public void cancelled(View view){
        MyApplication myApplication = (MyApplication) getApplication();

        myApplication.setOrderstate("3");

        startActivity(new Intent(getApplicationContext(),TosignforActivity.class));

    }

    public void deliveryby(View view){

        MyApplication myApplication = (MyApplication) getApplication();

        myApplication.setOrderstate("4");

        startActivity(new Intent(getApplicationContext(),DeliverybyActivity.class));
    }
    public void tosignfor(View view){

        MyApplication myApplication = (MyApplication) getApplication();

        myApplication.setOrderstate("5");

        startActivity(new Intent(getApplicationContext(),TosignforActivity.class));

    }
    public void setting(View view){

        startActivity(new Intent(getApplicationContext(),settings.class));

    }
}