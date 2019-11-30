package com.example.androidduan1_demobyducminh.sqliteopenhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.androidduan1_demobyducminh.dao.SongDAO;

public class SongOpenHelper extends SQLiteOpenHelper {

    public static final String DB_SONG = "SONG";
    public static final int VERSION = 1;

    public SongOpenHelper(Context context) {
        super(context, DB_SONG, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SongDAO.SQL_NEWTABLE_SONG);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS " + SongDAO.TABLE_NAME_BAIHAT);//xoa bang neu da ton tai
    }


}
