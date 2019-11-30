package com.example.androidduan1_demobyducminh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.androidduan1_demobyducminh.model.User;
import com.example.androidduan1_demobyducminh.sqliteopenhelper.UserOpenHelper;

public class UserDAO {
    public static final String SQL_NEWTABLE_USER = "CREATE TABLE USER (" +
            " USERNAME text primary key,"
            + " PASS text ,"
            + " PHONE text)";
    public static final String TABLE_NAME_USER = "USER";
    public static final String tc_NAMELOGIN = "USERNAME";
    public static final String tc_PASS = "PASS";
    public static final String tc_PHONE = "PHONE";
    UserOpenHelper userOpenHelper;
    SQLiteDatabase sqLiteDatabase;


    public UserDAO(Context context) {
        userOpenHelper = new UserOpenHelper(context);//tao DB
        sqLiteDatabase = userOpenHelper.getWritableDatabase();//cho phep ghi
    }

    public int InsertUser(User user) {
        ContentValues values = new ContentValues();
        // chèn 1 hàng mới
        values.put(tc_NAMELOGIN, user.getUsername());
        values.put(tc_PASS, user.getPassword());
        values.put(tc_PHONE, user.getPhone());
        if (sqLiteDatabase.insert(TABLE_NAME_USER, null, values) < 0) {

            return -1; //insert khong thanh cong
        }
        return 1; //insert thanh cong
    }


    public boolean CheckLogin(User user) {
        String select = " select " + tc_NAMELOGIN + "," + tc_PASS
                + " from " + TABLE_NAME_USER
                + " where " + tc_NAMELOGIN + "=?" + " and " + tc_PASS + "=?";

        String username = user.getUsername();
        String password = user.getPassword();

        Cursor c = sqLiteDatabase.rawQuery(select, new String[]{username, password});

        return c.moveToFirst();
    }

    public boolean CheckSDT(User user) {
        String select = " select " + tc_NAMELOGIN + "," + tc_PHONE
                + " from " + TABLE_NAME_USER
                + " where " + tc_NAMELOGIN + "=?" + " and " + tc_PASS + "=?";

        String username = user.getUsername();
        String Phone = user.getPhone();

        Cursor c = sqLiteDatabase.rawQuery(select, new String[]{username, Phone});

        return c.moveToFirst();
    }

    public int changePasswordUser(User user) {
        ContentValues values = new ContentValues();
        values.put(tc_NAMELOGIN, user.getUsername());
        values.put(tc_PASS, user.getPassword());
        int result = sqLiteDatabase.update(TABLE_NAME_USER, values, tc_NAMELOGIN + "=?", new String[]{user.getUsername()});
        if (result == 0) {
            return -1;
        }
        return 1;
    }


}
