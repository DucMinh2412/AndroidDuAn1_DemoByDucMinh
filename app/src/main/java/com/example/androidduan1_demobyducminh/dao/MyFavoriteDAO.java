package com.example.androidduan1_demobyducminh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.androidduan1_demobyducminh.model.Favorite;
import com.example.androidduan1_demobyducminh.sqliteopenhelper.SongOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyFavoriteDAO {
    public static final String SQL_NEWTABLE_MYFAVORITE = "CREATE TABLE FAVORITE (" +
            " IDBaiHat integer primary key AUTOINCREMENT,"
            + " TenBaiHat text,"
            + " TenCaSi text,"
            + " LinkBaiHat integer,"
            + " LinkAnhBaiHat integer,"
            + " SoLuotNghe integer)";
    public static final String TABLE_NAME_MYFAVORITE = "FAVORITE";
    public static final String tc_IDBAIHAT = "IDBaiHat";
    public static final String tc_TENBAIHAT = "TenBaiHat";
    public static final String tc_TENCASI = "TenCaSi";
    public static final String tc_LINKBAIHAT = "LinkBaiHat";
    public static final String tc_LINKANHBAIHAT = "LinkAnhBaiHat";
    SongOpenHelper songOpenHelper;
    SQLiteDatabase sqLiteDatabase;


    public MyFavoriteDAO(Context context) {
        songOpenHelper = new SongOpenHelper(context);//tao DB
        sqLiteDatabase = songOpenHelper.getWritableDatabase();//cho phep ghi
    }

    public int InsertSONGFV(Favorite favorite) {
        ContentValues values = new ContentValues();
        // chèn 1 hàng mới
        values.put(tc_TENBAIHAT, favorite.getTenBaiHat());
        values.put(tc_TENCASI, favorite.getTenCasi());
        values.put(tc_LINKBAIHAT, favorite.getLinkBaiHat() + "");
        values.put(tc_LINKANHBAIHAT, favorite.getLinkAnhBaiHat() + "");
        if (sqLiteDatabase.insert(TABLE_NAME_MYFAVORITE, null, values) < 0) {

            return -1; //insert khong thanh cong
        }
        return 1; //insert thanh cong
    }



    public List<Favorite> ALLSONGFAVORITE() {
        List<Favorite> list = new ArrayList<Favorite>();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME_MYFAVORITE, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            Favorite favorite = new Favorite();
            favorite.setIDFavorite(cursor.getInt(cursor.getColumnIndex(tc_IDBAIHAT)));
            favorite.setTenBaiHat(cursor.getString(cursor.getColumnIndex(tc_TENBAIHAT)));
            favorite.setTenCasi(cursor.getString(cursor.getColumnIndex(tc_TENCASI)));
            favorite.setLinkAnhBaiHat(cursor.getInt(cursor.getColumnIndex(tc_LINKANHBAIHAT)));
            favorite.setLinkBaiHat(cursor.getInt(cursor.getColumnIndex(tc_LINKBAIHAT)));
            list.add(favorite);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
