package com.itzheng.ZhengShopping.utils;

import android.app.Application;

import com.itzheng.ZhengShopping.entity.User;

public class MyApplication extends Application {

    User user = new User();
    
    private String orderstate;

    private String goodtypecode;

    private String goodname;

    private String goodcode;

    private String ordercode;

    public String getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(String orderstate) {
        this.orderstate = orderstate;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGoodtypecode() {
        return goodtypecode;
    }

    public void setGoodtypecode(String goodtypecode) {
        this.goodtypecode = goodtypecode;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public String getGoodcode() {
        return goodcode;
    }

    public void setGoodcode(String goodcode) {
        this.goodcode = goodcode;
    }
}
