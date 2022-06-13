package com.itzheng.ZhengShopping;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Set;

import ZhengShopping.R;


public class CameraActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;
    private Uri imageUri;
    Button Btn1;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        this.setTitle("调用系统内置的Camera应用摄取图像");
        //text=(TextView)this.findViewById(R.id.text);
        imageView=(ImageView)this.findViewById(R.id.myimage);
        Btn1= (Button)this.findViewById(R.id.btn_capture);
        Btn1.setOnClickListener(this);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("我的提示", "拍照结束，返回Activity");
        if (resultCode == RESULT_OK) {
            Log.d("我的提示", data.toString());
            //imageUri = data.getData();
            //text.setText("拍摄照片："+imageUri.toString());
            //"拍摄照片：content://media/external/images/media/25"
            Btn1.setText("继续拍摄");
            Bundle extras = data.getExtras();
            Set<String> myset = extras.keySet();
            for (String str : myset) {
                Log.d("我的提示aaa", str.toString());  //显示Bundle中所有的Key，结果是只有data
            }
            Bitmap bmp = (Bitmap) extras.get("data"); //获取返回的图像
            //imageView.setImageURI(imageUri);
            imageView.setImageBitmap(bmp);  //回显拍摄的照片
        }
    }
    public void onClick(View v){  //调用系统内置的照相机应用
        int id = v.getId();
        if(id == R.id.btn_capture){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 1);
        }

    }

}