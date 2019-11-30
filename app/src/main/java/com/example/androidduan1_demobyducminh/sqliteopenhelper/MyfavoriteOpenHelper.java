package com.example.androidduan1_demobyducminh.sqliteopenhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.androidduan1_demobyducminh.dao.MyFavoriteDAO;

public class MyfavoriteOpenHelper extends SQLiteOpenHelper {
    public static final String DB_MYFAVORITE = "FAVORITE";
    public static final int VERSION = 1;

    public MyfavoriteOpenHelper(Context context) {
        super(context, DB_MYFAVORITE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MyFavoriteDAO.SQL_NEWTABLE_MYFAVORITE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS " + MyFavoriteDAO.TABLE_NAME_BAIHAT);//xoa bang neu da ton tai
    }
}
