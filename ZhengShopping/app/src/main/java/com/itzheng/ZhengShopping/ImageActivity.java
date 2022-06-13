package com.itzheng.ZhengShopping;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.itzheng.ZhengShopping.utils.MyPagerAdapter;

import java.util.ArrayList;

import ZhengShopping.R;

public class ImageActivity extends AppCompatActivity {
    private ViewPager vp;
    private ArrayList<View>imagelist=new ArrayList<>();
    private int position;
    private int[] images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_image);
        init();
        vp.setAdapter(new MyPagerAdapter(imagelist));
        vp.setCurrentItem(position);
    }
    public void init(){
        vp=(ViewPager) findViewById(R.id.vp);
        position=getIntent().getIntExtra("position",0);
        images=getIntent().getIntArrayExtra("image");
        for(int i=0;i<images.length;i++){
            ImageView imageView=new ImageView(ImageActivity.this);
            imageView.setImageResource(images[i]);
            //给ImageView添加事件监听
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            imagelist.add(imageView);
        }
    }
}
