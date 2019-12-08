package com.example.androidduan1_demobyducminh.sqliteopenhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.androidduan1_demobyducminh.dao.CategoryDAO;
import com.example.androidduan1_demobyducminh.dao.MyFavoriteDAO;
import com.example.androidduan1_demobyducminh.dao.PlaylistDAO;
import com.example.androidduan1_demobyducminh.dao.SongDAO;
import com.example.androidduan1_demobyducminh.dao.ThemeDAO;
import com.example.androidduan1_demobyducminh.dao.UserDAO;

public class SongOpenHelper extends SQLiteOpenHelper {

    public static final String DB_SONG = "SONG";
    public static final int VERSION = 1;

    public SongOpenHelper(Context context) {
        super(context, DB_SONG, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MyFavoriteDAO.SQL_NEWTABLE_MYFAVORITE);
        db.execSQL(UserDAO.SQL_NEWTABLE_USER);
        db.execSQL(CategoryDAO.SQL_NEWTABLE_CATEGORY);
        db.execSQL(SongDAO.SQL_NEWTABLE_SONG);
        db.execSQL(ThemeDAO.SQL_NEWTABLE_THEME);
        db.execSQL(PlaylistDAO.SQL_NEWTABLE_PLAYLIST);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS " + MyFavoriteDAO.TABLE_NAME_MYFAVORITE);
        db.execSQL(" DROP TABLE IF EXISTS " + UserDAO.TABLE_NAME_USER);
        db.execSQL(" DROP TABLE IF EXISTS " + SongDAO.TABLE_NAME_BAIHAT);
        db.execSQL(" DROP TABLE IF EXISTS " + CategoryDAO.TABLE_NAME_THELOAI);
        db.execSQL(" DROP TABLE IF EXISTS " + ThemeDAO.TABLE_NAME_THEME);
        db.execSQL(" DROP TABLE IF EXISTS " + PlaylistDAO.TABLE_NAME_PLAYLIST);
    }


}
