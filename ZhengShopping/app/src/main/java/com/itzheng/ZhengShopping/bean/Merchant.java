package com.itzheng.ZhengShopping.bean;

public class Merchant { // 商家

    private String shop_name ;
    private String type ;
    private String time ;
    private int  imgid;

    public Merchant(String shop_name, String type, String time, int imgid) {
        this.shop_name = shop_name;
        this.type = type;
        this.time = time;
        this.imgid = imgid;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
}
