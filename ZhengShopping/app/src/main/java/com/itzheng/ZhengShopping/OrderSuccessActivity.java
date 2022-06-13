package com.itzheng.ZhengShopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ZhengShopping.R;

public class OrderSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);
    }

    public void back(View view){

        startActivity(new Intent(getApplicationContext(),AdminActivity.class));

    }

}