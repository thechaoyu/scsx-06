package com.itzheng.ZhengShopping;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.itzheng.ZhengShopping.dao.UserDao;
import com.itzheng.ZhengShopping.utils.PostUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import ZhengShopping.R;

public class RegisterActivity extends AppCompatActivity {
    private UserDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dao = new UserDao(this);


    }

    public void register(View v){

        EditText EditTextusername = (EditText)findViewById(R.id.username);
        EditText EditTextname = (EditText)findViewById(R.id.name);
        EditText EditTextpassword = (EditText)findViewById(R.id.password);
        EditText EditTextrepassword = (EditText)findViewById(R.id.repassword);
        EditText EditTextemail = (EditText)findViewById(R.id.email);
        EditText EditTextphone = (EditText)findViewById(R.id.phone);

        new Thread() {
            public void run() {

                int message = 0;

                String data="";
                try {

                    data =  "method=register"
                            + "&username="+ URLEncoder.encode(EditTextemail.getText().toString(), "UTF-8")
                            + "&name="+ URLEncoder.encode(EditTextname.getText().toString(), "UTF-8")
                            + "&password="+ URLEncoder.encode(EditTextpassword.getText().toString(), "UTF-8")
                            + "&email="+ URLEncoder.encode(EditTextemail.getText().toString(), "UTF-8")
                            + "&phone="+ URLEncoder.encode(EditTextphone.getText().toString(), "UTF-8");

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String username = EditTextemail.getText().toString().trim();
                String password = EditTextpassword.getText().toString().trim();
                String again = EditTextrepassword.getText().toString().trim();
                if (TextUtils.isEmpty(username) ||
                        TextUtils.isEmpty(password) ||
                        TextUtils.isEmpty(again)) {
                    Toast.makeText(RegisterActivity.this, "密码不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                if (password.equals(again)) {

                    addUser(username, password);
                    finish();

                } else {
                    Toast.makeText(RegisterActivity.this, "两次密码不能不同",Toast.LENGTH_LONG).show();

                }

                String stuJson= PostUtil.Post("UserPhoneServlet",data);

                System.out.println(stuJson);

                if(stuJson.equals("true")){
                    message = 1;
                }

                if(stuJson.equals("false")){
                    message = 0;
                }

                hand.sendEmptyMessage(message);
            }

        }.start();

    }
    public void addUser(String username, String password) {
        String pwd = dao.login(username);
        if (pwd == null) {
            dao.regist(username, password);
        } else {
            Toast.makeText(RegisterActivity.this, "该邮箱之前已经注册过了",Toast.LENGTH_LONG).show();

        }
    }
    final Handler hand = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {

            if(msg.what == 1)
            {
                Toast.makeText(getApplicationContext(),"服务器端注册成功",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
            else
            {
                Toast.makeText(getApplicationContext(),"服务器端注册失败",Toast.LENGTH_LONG).show();
            }
        }
    };


}