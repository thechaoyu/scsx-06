package com.itzheng.ZhengShopping.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



import com.itzheng.ZhengShopping.entity.Car;

import java.util.ArrayList;

import ZhengShopping.R;

public class CarAdapter extends BaseAdapter {

    int total = 0;

    ArrayList<Car> sData = new ArrayList<>();

    private Context mContext;

    private AppCompatActivity appCompatActivity;

    public AppCompatActivity getAppCompatActivity() {
        return appCompatActivity;
    }

    public void setAppCompatActivity(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    public CarAdapter(ArrayList<Car> sData, Context mContext) {
        this.sData = sData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return sData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(mContext).inflate(R.layout.carlist_layout,null);

        MyImageView image_car = (MyImageView)convertView.findViewById(R.id.image_car);

        TextView goodname_car = (TextView) convertView.findViewById(R.id.goodname_car);
        TextView goodprice_car = (TextView) convertView.findViewById(R.id.goodprice_car);
        TextView goodnumber_car = (TextView) convertView.findViewById(R.id.goodnumber_car);
        TextView goodcode_car = (TextView) convertView.findViewById(R.id.goodcode_car);

        //checkBox_car
        CheckBox checkBox_car = convertView.findViewById(R.id.checkBox_car);


        image_car.setImageURL("http://10.0.2.2:8082/zhengshop/image/upload/good/"+sData.get(position).getGoods().getGoodimagecode());
        goodname_car.setText(sData.get(position).getGoods().getGoodname());
        goodprice_car.setText(sData.get(position).getGoods().getGoodprice());
        goodnumber_car.setText(sData.get(position).getGoodnumber());
        goodcode_car.setText(sData.get(position).getGoodcode());



        checkBox_car.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    TextView cal = appCompatActivity.findViewById(R.id.cal);

                    total +=  Double.parseDouble(goodprice_car.getText().toString().toString()) * Double.parseDouble(goodnumber_car.getText().toString());

                    cal.setText("￥"+total+"");

                }else{
                    TextView cal = appCompatActivity.findViewById(R.id.cal);

                    total -=  Double.parseDouble(goodprice_car.getText().toString()) * Double.parseDouble(goodnumber_car.getText().toString());


                    cal.setText("￥"+total+"");
                }

            }
        });


        return convertView;
    }
}
