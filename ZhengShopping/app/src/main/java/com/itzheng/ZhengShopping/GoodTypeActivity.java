package com.itzheng.ZhengShopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.itzheng.ZhengShopping.entity.GoodType;
import com.itzheng.ZhengShopping.utils.GoodTypeAdapter;
import com.itzheng.ZhengShopping.utils.MyApplication;
import com.itzheng.ZhengShopping.utils.PostUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ZhengShopping.R;

public class GoodTypeActivity extends AppCompatActivity {

    ArrayList<GoodType> GoodTypealist = null;

    String goodtypecode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_type);

        //goodtype
        GoodTypealist = new ArrayList<GoodType>();
        new Thread() {
            public void run() {

                int message = 0;

                if(GoodTypealist != null){
                    GoodTypealist.clear();
                }

                String data="";
                try {

                    data =  "method=findGoodType";
                    System.out.println(data);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String stuJson= PostUtil.Post("GoodTypePhoneServlet",data);

                System.out.println(stuJson+"==============111111111111");

                try {

                    JSONArray jsonArray = new JSONArray(stuJson);

                    for(int i = 0;i < jsonArray.length();i++){

                        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                        GoodType goodtype = new GoodType();
                        goodtype.setId(jsonObject.getInt("id"));
                        goodtype.setGoodtypecode(jsonObject.getString("goodtypecode"));
                        goodtype.setTypename(jsonObject.getString("typename"));
                        GoodTypealist.add(goodtype);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if(GoodTypealist.size() > 0){
                    message = 1;
                }

                hand.sendEmptyMessage(message);

            }
        }.start();

        //goodtypeall    设置点击事件

        ListView good_list_ly = findViewById(R.id.goodtypeall);

        good_list_ly.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                System.out.println("010101001001010010101100110010");

                LinearLayout ly = (LinearLayout)view;

                TextView  lygoodtypecode = (TextView)ly.getChildAt(1);

                Toast.makeText(getApplicationContext(),lygoodtypecode.getText()+":goodcode",Toast.LENGTH_LONG).show();

                goodtypecode  = lygoodtypecode.getText().toString()+"";

                // goodtypecode
                MyApplication myApplication = (MyApplication)getApplication();

                myApplication.setGoodtypecode(goodtypecode);
                myApplication.setGoodname("");

                startActivity(new Intent(getApplicationContext(),GoodlistActivity.class));
            }
        });
    }


    final Handler hand = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {

            if(msg.what == 1)
            {
                System.out.println(GoodTypealist.size()+"............");
                for(GoodType goodtype: GoodTypealist){

                    System.out.println(goodtype+"............");

                }

                ListView goodlist = (ListView) findViewById(R.id.goodtypeall);

                GoodTypeAdapter adapter = new GoodTypeAdapter(GoodTypealist, getApplicationContext());

                goodlist.setAdapter(adapter);

            }
        }
    };

}