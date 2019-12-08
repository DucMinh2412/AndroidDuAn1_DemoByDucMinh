package com.example.androidduan1_demobyducminh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.androidduan1_demobyducminh.model.Theme;
import com.example.androidduan1_demobyducminh.sqliteopenhelper.SongOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ThemeDAO {
    public static final String SQL_NEWTABLE_THEME = "CREATE TABLE THEME (" +
            " IDChuDe integer primary key AUTOINCREMENT,"
            + " TenChuDe text)";

    public static final String TABLE_NAME_THEME = "THEME";
    public static final String tc_IDCHUDE = "IDChuDe";
    public static final String tc_TENCHUDE = "TenChuDe";

    SongOpenHelper songOpenHelper;
    SQLiteDatabase sqLiteDatabase;


    public ThemeDAO(Context context) {
        songOpenHelper = new SongOpenHelper(context);//tao DB
        sqLiteDatabase = songOpenHelper.getWritableDatabase();//cho phep ghi
    }

    public int InsertTHEME(Theme theme) {
        ContentValues values = new ContentValues();
        values.put(tc_TENCHUDE, theme.getNameChuDe());

        if (sqLiteDatabase.insert(TABLE_NAME_THEME, null, values) < 0) {

            return -1; //insert khong thanh cong
        }
        return 1; //insert thanh cong
    }

    public List<Theme> ALLTheme() {
        List<Theme> list = new ArrayList<Theme>();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME_THEME, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            Theme theme = new Theme();
            theme.setIDchuDe(cursor.getInt(cursor.getColumnIndex(tc_IDCHUDE)));
            theme.setNameChuDe(cursor.getString(cursor.getColumnIndex(tc_TENCHUDE)));
            list.add(theme);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

}