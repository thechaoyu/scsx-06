package com.itzheng.ZhengShopping.bean;

public class User {
    private String email;
    private String password ;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public User() {

    }
    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
