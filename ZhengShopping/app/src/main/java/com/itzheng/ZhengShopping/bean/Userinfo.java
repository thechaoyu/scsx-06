package com.itzheng.ZhengShopping.bean;

public class Userinfo {
    private String username ;
    private String useriphone ;
    private String userlocation ;
    private int img  ;

    public Userinfo(String username, String useriphone, String userlocation, int img) {
        this.username = username;
        this.useriphone = useriphone;
        this.userlocation = userlocation;
        this.img = img;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseriphone() {
        return useriphone;
    }

    public void setUseriphone(String useriphone) {
        this.useriphone = useriphone;
    }

    public String getUserlocation() {
        return userlocation;
    }

    public void setUserlocation(String userlocation) {
        this.userlocation = userlocation;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
