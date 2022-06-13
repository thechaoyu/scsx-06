package com.itzheng.ZhengShopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.itzheng.ZhengShopping.utils.ToastUtil;

import ZhengShopping.R;


public class AddLocationActivity extends AppCompatActivity {
//添加收货地址
    private EditText name_of_shouhuo ;
    private EditText numbser_of_shouhuo ;
    private EditText location_of_shouhuo ;
    private Button save  ;

    private String name , number ,location ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);
        name_of_shouhuo = (EditText)findViewById(R.id.name_of_shouhuo) ;
        numbser_of_shouhuo = (EditText)findViewById(R.id.number_of_shouhuo) ;
        location_of_shouhuo = (EditText)findViewById(R.id.location_of_shouhuo) ;
        save = (Button)findViewById(R.id.save) ;



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 如果点击保存
                ToastUtil.showToast(AddLocationActivity.this,"保存成功");
                Intent intent = new Intent(AddLocationActivity.this,DizhiActivity.class);

                name = name_of_shouhuo.getText().toString().trim();
                number = numbser_of_shouhuo.getText().toString().trim() ;
                location = location_of_shouhuo.getText().toString().trim() ;
                intent.putExtra("p_name",name) ;
                intent.putExtra("p_number",number) ;
                intent.putExtra("p_location",location);


//                ToastUtil.showToast(AddLocationActivity.this,"名字"+ name);
//                SharedPreferences sp = getSharedPreferences("p_info", MODE_PRIVATE);
//
//                SharedPreferences.Editor edit = sp.edit();
//
//                edit.putString("p_name", name);
//                edit.putString("p_number",number) ;
//                edit.putString("p_location",location) ;
//                ToastUtil.showToast(AddLocationActivity.this,name);
//                edit.commit();

                //激活意图

                startActivity(intent) ;
                finish();

            }
        });



    }
}
