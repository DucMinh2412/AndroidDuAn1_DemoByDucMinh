package com.example.androidduan1_demobyducminh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.androidduan1_demobyducminh.model.Song;
import com.example.androidduan1_demobyducminh.model.Top10Razochart;
import com.example.androidduan1_demobyducminh.sqliteopenhelper.SongOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class SongDAO {

    public static final String SQL_NEWTABLE_SONG = "CREATE TABLE SONG (" +
            " IDBaiHat integer primary key AUTOINCREMENT,"
            + " IDPlaylist integer,"
            + " IDTheLoai integer,"
            + " TenBaiHat text,"
            + " TenCaSi text,"
            + " LinkBaiHat integer,"
            + " LinkAnhBaiHat integer,"
            + " SoLuotNghe integer)";

    public static final String TABLE_NAME_BAIHAT = "SONG";
    public static final String tc_IDBAIHAT = "IDBaiHat";
    public static final String tc_IDPLAYLIST = "IDPlaylist";
    public static final String tc_IDTHELOAI = "IDTheLoai";
    public static final String tc_TENBAIHAT = "TenBaiHat";
    public static final String tc_TENCASI = "TenCaSi";
    public static final String tc_LINKBAIHAT = "LinkBaiHat";
    public static final String tc_LINKANHBAIHAT = "LinkAnhBaiHat";
    public static final String tc_SOLUOTNGHE = "SoLuotNghe";
    SongOpenHelper songOpenHelper;
    SQLiteDatabase sqLiteDatabase;


    public SongDAO(Context context) {
        songOpenHelper = new SongOpenHelper(context);//tao DB
        sqLiteDatabase = songOpenHelper.getWritableDatabase();//cho phep ghi
    }

    public int InsertSONG(Song song) {
        ContentValues values = new ContentValues();
        values.put(tc_IDPLAYLIST, song.getIDPlaylist() + "");
        values.put(tc_IDTHELOAI, song.getIDTheLoai() + "");
        values.put(tc_TENBAIHAT, song.getTenBaiHat());
        values.put(tc_TENCASI, song.getTenCasi());
        values.put(tc_LINKBAIHAT, song.getLinkBaiHat() + "");
        values.put(tc_LINKANHBAIHAT, song.getLinkAnhBaiHat() + "");
        values.put(tc_SOLUOTNGHE, song.getSoluotNghe() + "");
        if (sqLiteDatabase.insert(TABLE_NAME_BAIHAT, null, values) < 0) {

            return -1; //insert khong thanh cong
        }
        return 1; //insert thanh cong
    }


    public List<Top10Razochart> showTop10() {
        List<Top10Razochart> top10RazochartList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = songOpenHelper.getReadableDatabase();

        String select2 = "SELECT " + tc_TENBAIHAT + "," + tc_TENCASI + "," + tc_LINKBAIHAT + "," + tc_LINKANHBAIHAT + "," + " SUM(" + tc_SOLUOTNGHE + " )AS " + tc_SOLUOTNGHE
                + " FROM " + TABLE_NAME_BAIHAT
                + " GROUP BY " + tc_TENBAIHAT
                + " ORDER BY " + tc_SOLUOTNGHE
                + " DESC LIMIT 10 ";

        Cursor cursor = sqLiteDatabase.rawQuery(select2, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            Top10Razochart top10Razochart = new Top10Razochart();
            top10Razochart.setTenBaiHat(cursor.getString(cursor.getColumnIndex(tc_TENBAIHAT)));
            top10Razochart.setTenCasi(cursor.getString(cursor.getColumnIndex(tc_TENCASI)));
            top10Razochart.setSoluotNghe(cursor.getInt(cursor.getColumnIndex(tc_SOLUOTNGHE)));
            top10Razochart.setLinkAnhBaiHat(cursor.getInt(cursor.getColumnIndex(tc_LINKANHBAIHAT)));
            top10Razochart.setLinkBaiHat(cursor.getInt(cursor.getColumnIndex(tc_LINKBAIHAT)));
            top10RazochartList.add(top10Razochart);
            cursor.moveToNext();
        }
        // dong ket noi con tro
        cursor.close();
        // dong ket noi DB
        sqLiteDatabase.close();
        return top10RazochartList;
    }

    public List<Song> ALLPlaylistRazo() {
        List<Song> songList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = songOpenHelper.getReadableDatabase();

        String select2 = "SELECT SONG.IDPlaylist, SONG.TenBaiHat, SONG.TenCaSi, SONG.LinkBaiHat, SONG.LinkAnhBaiHat," + " PLAYLIST.IDPlaylist, PLAYLIST.TenPlaylist"
                + " FROM " + TABLE_NAME_BAIHAT + " INNER JOIN " + PlaylistDAO.TABLE_NAME_PLAYLIST
                + " ON SONG.IDPlaylist = PLAYLIST.IDPlaylist "
                + " WHERE SONG.IDPlaylist = PLAYLIST.IDPlaylist ";

        Cursor cursor = sqLiteDatabase.rawQuery(select2, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            Song song = new Song();
            song.setTenBaiHat(cursor.getString(cursor.getColumnIndex(tc_TENBAIHAT)));
            song.setTenCasi(cursor.getString(cursor.getColumnIndex(tc_TENCASI)));
            song.setLinkAnhBaiHat(cursor.getInt(cursor.getColumnIndex(tc_LINKANHBAIHAT)));
            song.setLinkBaiHat(cursor.getInt(cursor.getColumnIndex(tc_LINKBAIHAT)));
            songList.add(song);
            cursor.moveToNext();
        }
        // dong ket noi con tro
        cursor.close();
        // dong ket noi DB
        sqLiteDatabase.close();
        return songList;
    }

    public List<Song> ALLPlaylistPlayGame() {
        List<Song> songList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = songOpenHelper.getReadableDatabase();

        String select2 = "SELECT SONG.IDPlaylist, SONG.TenBaiHat, SONG.TenCaSi, SONG.LinkBaiHat, SONG.LinkAnhBaiHat," + " PLAYLIST.IDPlaylist, PLAYLIST.TenPlaylist"
                + " FROM " + TABLE_NAME_BAIHAT + " INNER JOIN " + PlaylistDAO.TABLE_NAME_PLAYLIST
                + " ON SONG.IDPlaylist = PLAYLIST.IDPlaylist "
                + " WHERE SONG.IDPlaylist = 1";

        Cursor cursor = sqLiteDatabase.rawQuery(select2, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            Song song = new Song();
            song.setTenBaiHat(cursor.getString(cursor.getColumnIndex(tc_TENBAIHAT)));
            song.setTenCasi(cursor.getString(cursor.getColumnIndex(tc_TENCASI)));
            song.setLinkAnhBaiHat(cursor.getInt(cursor.getColumnIndex(tc_LINKANHBAIHAT)));
            song.setLinkBaiHat(cursor.getInt(cursor.getColumnIndex(tc_LINKBAIHAT)));
            songList.add(song);
            cursor.moveToNext();
        }
        // dong ket noi con tro
        cursor.close();
        // dong ket noi DB
        sqLiteDatabase.close();
        return songList;
    }

    public List<Song> ALLPlaylistMood() {
        List<Song> songList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = songOpenHelper.getReadableDatabase();

        String select2 = "SELECT SONG.IDPlaylist, SONG.TenBaiHat, SONG.TenCaSi, SONG.LinkBaiHat, SONG.LinkAnhBaiHat," + " PLAYLIST.IDPlaylist, PLAYLIST.TenPlaylist"
                + " FROM " + TABLE_NAME_BAIHAT + " INNER JOIN " + PlaylistDAO.TABLE_NAME_PLAYLIST
                + " ON SONG.IDPlaylist = PLAYLIST.IDPlaylist "
                + " WHERE SONG.IDPlaylist = 2";

        Cursor cursor = sqLiteDatabase.rawQuery(select2, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            Song song = new Song();
            song.setTenBaiHat(cursor.getString(cursor.getColumnIndex(tc_TENBAIHAT)));
            song.setTenCasi(cursor.getString(cursor.getColumnIndex(tc_TENCASI)));
            song.setLinkAnhBaiHat(cursor.getInt(cursor.getColumnIndex(tc_LINKANHBAIHAT)));
            song.setLinkBaiHat(cursor.getInt(cursor.getColumnIndex(tc_LINKBAIHAT)));
            songList.add(song);
            cursor.moveToNext();
        }
        // dong ket noi con tro
        cursor.close();
        // dong ket noi DB
        sqLiteDatabase.close();
        return songList;
    }


    public List<Song> ALLPlaylistBolero() {
        List<Song> songList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = songOpenHelper.getReadableDatabase();

        String select2 = "SELECT SONG.IDTheLoai, SONG.TenBaiHat, SONG.TenCaSi, SONG.LinkBaiHat, SONG.LinkAnhBaiHat," + "CATEGORY.IDTheLoai,CATEGORY.TenTheLoai"
                + " FROM " + TABLE_NAME_BAIHAT + " INNER JOIN " + CategoryDAO.TABLE_NAME_THELOAI
                + " ON SONG.IDTheLoai =CATEGORY.IDTheLoai "
                + " WHERE SONG.IDTheLoai = 1";

        Cursor cursor = sqLiteDatabase.rawQuery(select2, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            Song song = new Song();
            song.setTenBaiHat(cursor.getString(cursor.getColumnIndex(tc_TENBAIHAT)));
            song.setTenCasi(cursor.getString(cursor.getColumnIndex(tc_TENCASI)));
            song.setLinkAnhBaiHat(cursor.getInt(cursor.getColumnIndex(tc_LINKANHBAIHAT)));
            song.setLinkBaiHat(cursor.getInt(cursor.getColumnIndex(tc_LINKBAIHAT)));
            songList.add(song);
            cursor.moveToNext();
        }
        // dong ket noi con tro
        cursor.close();
        // dong ket noi DB
        sqLiteDatabase.close();
        return songList;
    }

    public List<Song> ALLPlaylistRomantic() {
        List<Song> songList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = songOpenHelper.getReadableDatabase();

        String select2 = "SELECT SONG.IDTheLoai, SONG.TenBaiHat, SONG.TenCaSi, SONG.LinkBaiHat, SONG.LinkAnhBaiHat," + "CATEGORY.IDTheLoai,CATEGORY.TenTheLoai"
                + " FROM " + TABLE_NAME_BAIHAT + " INNER JOIN " + CategoryDAO.TABLE_NAME_THELOAI
                + " ON SONG.IDTheLoai =CATEGORY.IDTheLoai "
                + " WHERE SONG.IDTheLoai = 2";

        Cursor cursor = sqLiteDatabase.rawQuery(select2, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            Song song = new Song();
            song.setTenBaiHat(cursor.getString(cursor.getColumnIndex(tc_TENBAIHAT)));
            song.setTenCasi(cursor.getString(cursor.getColumnIndex(tc_TENCASI)));
            song.setLinkAnhBaiHat(cursor.getInt(cursor.getColumnIndex(tc_LINKANHBAIHAT)));
            song.setLinkBaiHat(cursor.getInt(cursor.getColumnIndex(tc_LINKBAIHAT)));
            songList.add(song);
            cursor.moveToNext();
        }
        // dong ket noi con tro
        cursor.close();
        // dong ket noi DB
        sqLiteDatabase.close();
        return songList;
    }

    public List<Song> ALLPlaylistPopBallab() {
        List<Song> songList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = songOpenHelper.getReadableDatabase();

        String select2 = "SELECT SONG.IDTheLoai, SONG.TenBaiHat, SONG.TenCaSi, SONG.LinkBaiHat, SONG.LinkAnhBaiHat," + " PLAYLIST.IDPlaylist, PLAYLIST.TenPlaylist"
                + " FROM " + TABLE_NAME_BAIHAT + " INNER JOIN " + PlaylistDAO.TABLE_NAME_PLAYLIST
                + " ON SONG.IDPlaylist = PLAYLIST.IDPlaylist "
                + " WHERE SONG.IDTheLoai = 3";

        Cursor cursor = sqLiteDatabase.rawQuery(select2, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            Song song = new Song();
            song.setTenBaiHat(cursor.getString(cursor.getColumnIndex(tc_TENBAIHAT)));
            song.setTenCasi(cursor.getString(cursor.getColumnIndex(tc_TENCASI)));
            song.setLinkAnhBaiHat(cursor.getInt(cursor.getColumnIndex(tc_LINKANHBAIHAT)));
            song.setLinkBaiHat(cursor.getInt(cursor.getColumnIndex(tc_LINKBAIHAT)));
            songList.add(song);
            cursor.moveToNext();
        }
        // dong ket noi con tro
        cursor.close();
        // dong ket noi DB
        sqLiteDatabase.close();
        return songList;
    }









}
