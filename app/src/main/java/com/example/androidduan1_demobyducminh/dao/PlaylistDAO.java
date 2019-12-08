package com.example.androidduan1_demobyducminh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.androidduan1_demobyducminh.model.Playlist;
import com.example.androidduan1_demobyducminh.sqliteopenhelper.SongOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO {
    public static final String SQL_NEWTABLE_PLAYLIST = "CREATE TABLE PLAYLIST (" +
            " IDPlaylist integer primary key AUTOINCREMENT,"
            + " TenPlaylist text)";

    public static final String TABLE_NAME_PLAYLIST = "PLAYLIST";
    public static final String tc_IDPLAYLIST = "IDPlaylist";
    public static final String tc_TENPLAYLIST = "TenPlaylist";

    SongOpenHelper songOpenHelper;
    SQLiteDatabase sqLiteDatabase;


    public PlaylistDAO(Context context) {
        songOpenHelper = new SongOpenHelper(context);//tao DB
        sqLiteDatabase = songOpenHelper.getWritableDatabase();//cho phep ghi
    }

    public int InsertPlaylist(Playlist playlist) {
        ContentValues values = new ContentValues();
        values.put(tc_TENPLAYLIST, playlist.getNamePlaylist());

        if (sqLiteDatabase.insert(TABLE_NAME_PLAYLIST, null, values) < 0) {

            return -1; //insert khong thanh cong
        }
        return 1; //insert thanh cong
    }

    public List<Playlist> ALLPlaylist() {
        List<Playlist> list = new ArrayList<Playlist>();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME_PLAYLIST, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            Playlist playlist = new Playlist();
            playlist.setIDplaylist(cursor.getInt(cursor.getColumnIndex(tc_IDPLAYLIST)));
            playlist.setNamePlaylist(cursor.getString(cursor.getColumnIndex(tc_TENPLAYLIST)));
            list.add(playlist);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
