package com.example.androidduan1_demobyducminh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.androidduan1_demobyducminh.model.Category;
import com.example.androidduan1_demobyducminh.sqliteopenhelper.SongOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    public static final String SQL_NEWTABLE_CATEGORY = "CREATE TABLE CATEGORY (" +
            " IDTheLoai integer primary key AUTOINCREMENT,"
            + " IDChuDe integer,"
            + "TenTheLoai text )";

    public static final String TABLE_NAME_THELOAI = "CATEGORY";
    public static final String tc_IDTHELOAI = "IDTheLoai";
    public static final String tc_IDCHUDE = "IDChuDe";
    public static final String tc_TENTHELOAI = "TenTheLoai";

    SongOpenHelper songOpenHelper;
    SQLiteDatabase sqLiteDatabase;


    public CategoryDAO(Context context) {
        songOpenHelper = new SongOpenHelper(context);//tao DB
        sqLiteDatabase = songOpenHelper.getWritableDatabase();//cho phep ghi
    }

    public int InsertCategory(Category category) {
        ContentValues values = new ContentValues();
        values.put(tc_IDCHUDE, category.getIDChuDe() + "");
        values.put(tc_TENTHELOAI, category.getTenTheLoai());

        if (sqLiteDatabase.insert(TABLE_NAME_THELOAI, null, values) < 0) {

            return -1; //insert khong thanh cong
        }
        return 1; //insert thanh cong
    }

    public List<Category> ALLCategory() {
        List<Category> list = new ArrayList<Category>();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME_THELOAI, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            Category category = new Category();
            category.setIDTheLoai(cursor.getInt(cursor.getColumnIndex(tc_IDTHELOAI)));
            category.setIDChuDe(cursor.getInt(cursor.getColumnIndex(tc_IDCHUDE)));
            category.setTenTheLoai(cursor.getString(cursor.getColumnIndex(tc_TENTHELOAI)));
            list.add(category);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<Category> ALLCategoryBolero() {
        List<Category> categoryList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = songOpenHelper.getReadableDatabase();

        String select2 = "SELECT CATEGORY.IDChuDe, CATEGORY.TenTheLoai," + "THEME.IDChuDe"
                + " FROM " + TABLE_NAME_THELOAI + " INNER JOIN " + ThemeDAO.TABLE_NAME_THEME
                + " ON CATEGORY.IDChuDe = THEME.IDChuDe"
                + " WHERE CATEGORY.IDChuDe=1";

        Cursor cursor = sqLiteDatabase.rawQuery(select2, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            Category category = new Category();
            category.setIDChuDe(cursor.getInt(cursor.getColumnIndex(tc_IDCHUDE)));
            category.setTenTheLoai(cursor.getString(cursor.getColumnIndex(tc_TENTHELOAI)));
            categoryList.add(category);
            cursor.moveToNext();
        }
        // dong ket noi con tro
        cursor.close();
        // dong ket noi DB
        sqLiteDatabase.close();
        return categoryList;
    }

    public List<Category> ALLCategoryRomantic() {
        List<Category> categoryList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = songOpenHelper.getReadableDatabase();

        String select2 = "SELECT CATEGORY.IDChuDe, CATEGORY.TenTheLoai," + "THEME.IDChuDe"
                + " FROM " + TABLE_NAME_THELOAI + " INNER JOIN " + ThemeDAO.TABLE_NAME_THEME
                + " ON CATEGORY.IDChuDe = THEME.IDChuDe"
                + " WHERE CATEGORY.IDChuDe=2";

        Cursor cursor = sqLiteDatabase.rawQuery(select2, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            Category category = new Category();
            category.setIDChuDe(cursor.getInt(cursor.getColumnIndex(tc_IDCHUDE)));
            category.setTenTheLoai(cursor.getString(cursor.getColumnIndex(tc_TENTHELOAI)));
            categoryList.add(category);
            cursor.moveToNext();
        }
        // dong ket noi con tro
        cursor.close();
        // dong ket noi DB
        sqLiteDatabase.close();
        return categoryList;
    }

    public List<Category> ALLCategoryPopBallab() {
        List<Category> categoryList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = songOpenHelper.getReadableDatabase();

        String select2 = "SELECT CATEGORY.IDChuDe, CATEGORY.TenTheLoai," + "THEME.IDChuDe"
                + " FROM " + TABLE_NAME_THELOAI + " INNER JOIN " + ThemeDAO.TABLE_NAME_THEME
                + " ON CATEGORY.IDChuDe = THEME.IDChuDe"
                + " WHERE CATEGORY.IDChuDe=3";

        Cursor cursor = sqLiteDatabase.rawQuery(select2, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            Category category = new Category();
            category.setIDChuDe(cursor.getInt(cursor.getColumnIndex(tc_IDCHUDE)));
            category.setTenTheLoai(cursor.getString(cursor.getColumnIndex(tc_TENTHELOAI)));
            categoryList.add(category);
            cursor.moveToNext();
        }
        // dong ket noi con tro
        cursor.close();
        // dong ket noi DB
        sqLiteDatabase.close();
        return categoryList;
    }
}
