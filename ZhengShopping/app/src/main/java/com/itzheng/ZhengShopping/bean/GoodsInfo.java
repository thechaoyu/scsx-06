package com.itzheng.ZhengShopping.bean;

public class GoodsInfo {

    private int imgid ;
    private String money ;
    private String describe ;
    private double number ;

    public GoodsInfo(int imgid, String money, String describe, double number) {
        this.imgid = imgid;
        this.money = money;
        this.describe = describe;
        this.number = number;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }
}
