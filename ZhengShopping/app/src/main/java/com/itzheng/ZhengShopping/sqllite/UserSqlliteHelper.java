package com.itzheng.ZhengShopping.sqllite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserSqlliteHelper extends SQLiteOpenHelper {

    // 创建数据库
    public UserSqlliteHelper(Context context) {
        super(context, "helper.db", null, 1);

    }

    // 创建数据表
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table if not exists tbl_user(" +
                "name varchar(20), " +
                "password varchar(20), " +
                "username varchar(20), " +
                "email varchar(40), " +
                "phone varchar(2)"
                + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        db.execSQL("drop table if exists tbl_user");
        onCreate(db);
    }



}
