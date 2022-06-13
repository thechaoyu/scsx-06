package com.itzheng.ZhengShopping.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itzheng.ZhengShopping.bean.User;
import com.itzheng.ZhengShopping.sqllite.UserSqlliteHelper;

public class UserDao {
    private UserSqlliteHelper helper;
    public static final String TAG="UserDao";
    // 构造方法
    public UserDao(Context context) {
        helper = new UserSqlliteHelper(context);
    }

    // 登录方法：查询操作
    // 根据eamil 查询 密码
    public String login(String email) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from tbl_user where email=?";
        Cursor c = db.rawQuery(sql, new String[]{email});
        String password = null;
        while (c.moveToNext()) {
            password = c.getString(c.getColumnIndex("password"));
        }
        c.close();
        db.close();
        return password;
    }

    // 注册方法：写入操作
    public void regist(String username, String password) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);
        db.insert("tbl_user", null, values);
        db.close();
        Log.d(TAG,"本地数据库注册成功");
    }

    // 修改用户信息
    public void update(String username, String password) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        if(password != null ) {
            values.put("password",password);
        }
        db.update("tbl_user", values, "username=?", new String[]{username});
        db.close();
    }

    // 按照用户名获取用户其他信息
    public User getUserByUsername(String username) {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.rawQuery("select * from tbl_user where email = ?", new String[]{username});
        User user = null;
        while (c.moveToNext()) {
            user = new User();

            user.setemail(c.getString(c.getColumnIndex("email")));
            user.setPassword(c.getString(c.getColumnIndex("password")));
        }
        return user;
    }

}
