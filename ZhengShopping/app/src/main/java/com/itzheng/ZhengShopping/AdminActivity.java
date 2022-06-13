package com.itzheng.ZhengShopping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.itzheng.ZhengShopping.entity.Goods;
import com.itzheng.ZhengShopping.entity.User;
import com.itzheng.ZhengShopping.utils.GoodAdapter;
import com.itzheng.ZhengShopping.utils.MyApplication;
import com.itzheng.ZhengShopping.utils.MyImageView;
import com.itzheng.ZhengShopping.utils.PostUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import ZhengShopping.R;

public class AdminActivity extends AppCompatActivity {
    private ViewPager mViewPaper;
    private List<ImageView> images;
    //下方指示点
    private List<View> dots;
    private int currentItem;
    //记录上一次点的位置
    private int oldPosition = 0;
    //存放图片的id
    private int[] imageIds = new int[]{R.drawable.ads_laptop, R.drawable.ads_phones, R.drawable.ads_sports};
    //存放图片的标题，可以设为空
    private String[] titles = new String[]{"荣耀MagicBook14 2022", "SONY XPERIA 1IV", "运动户外520礼遇季"};
    private TextView title;
    private ViewPagerAdapter adapter;
    //定时调度机制
    private ScheduledExecutorService scheduledExecutorService;
    ArrayList<Goods> Goodsalist = null;

    String goodcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        setView();

        MyApplication myApplication = (MyApplication) getApplication();

        User user = myApplication.getUser();

        TextView textView = findViewById(R.id.texttop);

        textView.setText(user.getName());

        Goodsalist = new ArrayList<Goods>();

        new Thread() {
            public void run() {

                int message = 0;

                if (Goodsalist != null) {
                    Goodsalist.clear();
                }

                String data = "";
                try {

                    data = "method=findGoods";

                } catch (Exception e) {
                    e.printStackTrace();
                }

                String stuJson = PostUtil.Post("GoodsPhoneServlet", data);

                System.out.println(stuJson + "==============111111111111");

                try {

                    JSONArray jsonArray = new JSONArray(stuJson);

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                        Goods goods = new Goods();
                        goods.setId(jsonObject.getInt("id"));
                        goods.setGoodcode(jsonObject.getString("goodcode"));
                        goods.setGoodname(jsonObject.getString("goodname"));
                        goods.setGooddetail(jsonObject.getString("gooddetail"));
                        goods.setGoodprice(jsonObject.getString("goodprice"));
                        goods.setGooddiscount(jsonObject.getString("gooddiscount"));
                        goods.setGoodstate(jsonObject.getString("goodstate"));
                        goods.setGoodimagecode(jsonObject.getString("goodimagecode"));
                        goods.setGoodstate(jsonObject.getString("gooddate"));
                        goods.setGoodtypecode(jsonObject.getString("goodtypecode"));

                        Goodsalist.add(goods);

                    }

                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }

                if (Goodsalist.size() > 0) {
                    message = 1;
                }

                hand.sendEmptyMessage(message);
                for (Goods goods : Goodsalist) {
                    System.out.println(goods);
                }
            }
        }.start();

        //设置点击按钮跳转
        LinearLayout lyc3 = (LinearLayout) findViewById(R.id.lyc3);
        LinearLayout lyfz = (LinearLayout) findViewById(R.id.lyfz);
        LinearLayout lysh = (LinearLayout) findViewById(R.id.lysh);
        LinearLayout lysp = (LinearLayout) findViewById(R.id.lysp);


        //设置点击上面按钮的事件
        lyc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                MyApplication myApplication = (MyApplication) getApplication();

                myApplication.setGoodtypecode("3");
                myApplication.setGoodname("");

                startActivity(new Intent(getApplicationContext(), GoodlistActivity.class));


            }
        });
        lyfz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                MyApplication myApplication = (MyApplication) getApplication();

                myApplication.setGoodtypecode("9");

                startActivity(new Intent(getApplicationContext(), GoodlistActivity.class));
            }
        });
        lysh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyApplication myApplication = (MyApplication) getApplication();

                myApplication.setGoodtypecode("5");
                startActivity(new Intent(getApplicationContext(), GoodlistActivity.class));
            }
        });
        lysp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyApplication myApplication = (MyApplication) getApplication();

                myApplication.setGoodtypecode("hg9y40ovzu60ob2k");
                startActivity(new Intent(getApplicationContext(), GoodlistActivity.class));
            }
        });

        //设置点击ListView的事件

        ListView good_list_ly = findViewById(R.id.good_listad);

        good_list_ly.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                LinearLayout lygoodcode = (LinearLayout) view;

                lygoodcode = (LinearLayout) lygoodcode.getChildAt(0);

                lygoodcode = (LinearLayout) lygoodcode.getChildAt(1);

                TextView textView1 = (TextView) lygoodcode.getChildAt(3);


                Toast.makeText(getApplicationContext(), textView1.getText() + ":goodcode", Toast.LENGTH_LONG).show();

                goodcode = textView1.getText().toString() + "";
                int message = 0;

                if (textView1.getText().toString() != null) {
                    message = 3;
                }

                hand.sendEmptyMessage(message);

            }
        });


    }


    //UI界面的更新
    private void setView() {
        mViewPaper = findViewById(R.id.viewpager);
        //显示的图片
        images = new ArrayList<ImageView>();
        for (int i = 0; i < imageIds.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imageIds[i]);
            images.add(imageView);
        }
        //显示的小点
        dots = new ArrayList<View>();
        dots.add(findViewById(R.id.dot_0));
        dots.add(findViewById(R.id.dot_1));
        dots.add(findViewById(R.id.dot_2));

        title = findViewById(R.id.title);
        title.setText(titles[0]);

        adapter = new ViewPagerAdapter();
        mViewPaper.setAdapter(adapter);

        mViewPaper.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                title.setText(titles[position]);
                dots.get(position).setBackgroundResource(R.drawable.dot_yes);
                dots.get(oldPosition).setBackgroundResource(R.drawable.dot_no);
                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
        });
    }

    /*定义的适配器*/
    public class ViewPagerAdapter extends PagerAdapter {
        //返回当前有效视图的个数。
        @Override
        public int getCount() {
            return images.size();
        }

        //判断instantiateItem函数所返回来的Key与一个页面视图是否是代表的同一个视图
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            view.removeView(images.get(position));
        }

        //创建指定位置的页面视图，也就是将一张图片放到容器中的指定位置
        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            view.addView(images.get(position));
            return images.get(position);
        }

    }

    /**
     * 利用线程池定时执行动画轮播
     */
    @Override
    public void onStart() {
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        //每隔2s时间，固定执行轮播任务。
        scheduledExecutorService.scheduleWithFixedDelay(new ViewPageTask(), 2, 2, TimeUnit.SECONDS);
    }

    /**
     * 图片轮播任务,发送轮播消息
     */
    private class ViewPageTask implements Runnable {
        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageIds.length;
            mHandler.sendEmptyMessage(0);   //发送轮播消息
        }
    }

    /**
     * 接收子线程传递过来的数据
     */
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            //这里不是具体的数据，而是一个轮播信号，目的是切换下一张图片
            mViewPaper.setCurrentItem(currentItem);
        }
    };

    //当切换到其他界面时，关闭后台轮播
    @Override
    public void onStop() {
        super.onStop();
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            scheduledExecutorService = null;
        }
    }


    public void fenlei(View view) {

        //GoodTypeActivity
        startActivity(new Intent(getApplicationContext(), GoodTypeActivity.class));
    }
    public void weitao(View view) {
        finish();
        //GoodTypeActivity
        //startActivity(new Intent(getApplicationContext(), WeitaoActivity.class));
        Intent it=new Intent();
        it.setClass(AdminActivity.this,WeitaoActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
    }
    public void xiaoxi(View view) {
        finish();
        //startActivity(new Intent(getApplicationContext(), XiaoxiActivity.class));
        Intent it=new Intent();
        it.setClass(AdminActivity.this,XiaoxiActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
    }
    public void gouwuche(View view) {
        finish();
        //startActivity(new Intent(getApplicationContext(), CarActivity.class));
        Intent it=new Intent();
        it.setClass(AdminActivity.this,CarActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
    }

    public void wode(View view) {
        finish();
        //startActivity(new Intent(getApplicationContext(), MyMainActivity.class));
        Intent it=new Intent();
        it.setClass(AdminActivity.this,MyMainActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
    }

    public void search(View view) {

        EditText message = findViewById(R.id.message);
        MyApplication myApplication = (MyApplication) getApplication();

        Toast.makeText(getApplicationContext(), message.getText().toString(), Toast.LENGTH_LONG).show();

        System.out.println(message.getText().toString() + "99999999999999999999999999");

        myApplication.setGoodname(message.getText().toString());

        myApplication.setGoodtypecode("");

        startActivity(new Intent(getApplicationContext(), GoodlistActivity.class));

    }

    public void camera(View view) {
        Intent it=new Intent();
        it.setClass(AdminActivity.this,CameraActivity.class);
        startActivity(it);
    }
    final Handler hand = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            if (msg.what == 1) {
                Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_LONG).show();
                //  startActivity(new Intent(getApplicationContext(),AdminActivity.class));
                for (Goods goods : Goodsalist) {
                    System.out.println(goods);
                }
                //将数据放入到页面当中

                Random random = new Random();
                int a = random.nextInt(4);

//                MyImageView myImageView = (MyImageView) findViewById(R.id.imagecenter);
//                myImageView.setImageURL("http://10.0.2.2:8082/Zhengshop/image/upload/top.jpg");

                ListView goodlist = (ListView) findViewById(R.id.good_listad);

                GoodAdapter adapter = new GoodAdapter(Goodsalist, getApplicationContext());

                goodlist.setAdapter(adapter);


            }
            if (msg.what == 3) {

                //goodcode,查询详情

                MyApplication myApplication = (MyApplication) getApplication();

                myApplication.setGoodcode(goodcode);

                //跳转到商品详情页

                startActivity(new Intent(getApplicationContext(), GoodShowActivity.class));
            }

        }

    };
}

