package com.itzheng.ZhengShopping.bean;



public class ChatDate {
    private int resourceID;
    private String name;
    private String content;
    private String time;

    public ChatDate(int resourceID, String name, String content, String time) {
        this.resourceID = resourceID;
        this.name = name;
        this.content = content;
        this.time = time;
    }

    public int getResourceID() {
        return resourceID;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public void setName(String name) {
        this.name = name;
    }
}
