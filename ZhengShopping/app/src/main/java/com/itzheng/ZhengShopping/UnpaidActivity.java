package com.itzheng.ZhengShopping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.itzheng.ZhengShopping.utils.MyApplication;

import ZhengShopping.R;

public class UnpaidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unpaid);
        MyApplication myApplication = (MyApplication)getApplication();
        String usercode = myApplication.getUser().getUsercode();




    }
}