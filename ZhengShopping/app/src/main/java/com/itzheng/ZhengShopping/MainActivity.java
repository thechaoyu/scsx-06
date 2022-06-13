package com.itzheng.ZhengShopping;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.itzheng.ZhengShopping.entity.User;
import com.itzheng.ZhengShopping.utils.MyApplication;
import com.itzheng.ZhengShopping.utils.PostUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import ZhengShopping.R;

public class MainActivity extends AppCompatActivity {

    private ImageButton pwv;//zcc
    private EditText password ;//zcc
    User user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password = (EditText)findViewById(R.id.password) ;

        pwv = (ImageButton)findViewById(R.id.password_visibility);
        // 注册监听器
        user = new User();
        pwv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(password.getInputType() == 128){//如果现在是显示密码模式
                    password.setInputType(129);//设置为隐藏密码
                    pwv.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                }else {
                    password.setInputType(128);//设置为显示密码
                    pwv.setImageResource(R.drawable.ic_baseline_visibility_24);
                }
                password.setSelection(password.getText().length());//设置光标的位置到末尾
            }
        });
    }

    public void register(View view){

        startActivity(new Intent(getApplicationContext(),RegisterActivity.class));

    }



    public void login(View view){

        EditText EditTextemail = (EditText)findViewById(R.id.email);
        EditText EditTextpassword = (EditText)findViewById(R.id.password);

        new Thread() {
            public void run() {

                int message = 0;

                String data="";
                try {

                    data =  "method=login"+ "&email="+ URLEncoder.encode(EditTextemail.getText().toString(), "UTF-8")
                            + "&password="+ URLEncoder.encode(EditTextpassword.getText().toString(), "UTF-8");

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                String stuJson= PostUtil.Post("UserPhoneServlet",data);

                System.out.println(stuJson);

                try {

                    /*
                     "User [id=" + id + ", usercode=" + usercode + ", username=" + username + ",
                     password=" + password + ", name=" + name + ", email=" + email + ",
                     phone=" + phone + ", usertype=" + usertype + ",
                    state=" + state + ", image=" + image + ", date=" + date + "]";
                     */
                    JSONArray jsonArray = new JSONArray(stuJson);
                    JSONObject jsonObject = (JSONObject) jsonArray.get(0);
                    user.setId(jsonObject.getInt("id"));
                    user.setUsercode(jsonObject.getString("usercode"));
                    user.setUsername(jsonObject.getString("username"));
                    user.setPassword(jsonObject.getString("password"));
                    user.setName(jsonObject.getString("name"));
                    user.setEmail(jsonObject.getString("email"));
                    user.setPhone(jsonObject.getString("phone"));
                    user.setUsertype(jsonObject.getString("usertype"));
                    user.setState(jsonObject.getString("state"));
                    user.setImage(jsonObject.getString("image"));
                    user.setDate(jsonObject.getString("date"));

                    if(user == null || user.getName().length() < 1){
                        message = 0;
                    }else {
                        message = 1;
                    }
                } catch ( Exception e) {
                    e.printStackTrace();
                }
                hand.sendEmptyMessage(message);

            }

        }.start();

        MyApplication ma =  (MyApplication)getApplication();

        ma.setUser(user);

    }


    final Handler hand = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {

            if(msg.what == 1)
            {
                Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_LONG).show();
                //startActivity(new Intent(getApplicationContext(),AdminActivity.class));
                finish();
                Intent it=new Intent();
                it.setClass(MainActivity.this,AdminActivity.class);
                it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(it);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"登录失败",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),AdminActivity.class));
            }
        }
    };

}