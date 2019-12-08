package com.example.androidduan1_demobyducminh.model;

public class Song {
    public int IDBaiHat, IDTheLoai, IDPlaylist;
    public String TenBaiHat, TenCasi;
    public int LinkAnhBaiHat, LinkBaiHat;
    public double SoluotNghe;

    public Song() {
    }

    public Song(int IDTheLoai, int IDPlaylist, String tenBaiHat, String tenCasi, int linkAnhBaiHat, int linkBaiHat, double soluotNghe) {
        this.IDTheLoai = IDTheLoai;
        this.IDPlaylist = IDPlaylist;
        TenBaiHat = tenBaiHat;
        TenCasi = tenCasi;
        LinkAnhBaiHat = linkAnhBaiHat;
        LinkBaiHat = linkBaiHat;
        SoluotNghe = soluotNghe;
    }

    public int getIDBaiHat() {
        return IDBaiHat;
    }

    public void setIDBaiHat(int IDBaiHat) {
        this.IDBaiHat = IDBaiHat;
    }

    public int getIDTheLoai() {
        return IDTheLoai;
    }

    public void setIDTheLoai(int IDTheLoai) {
        this.IDTheLoai = IDTheLoai;
    }

    public int getIDPlaylist() {
        return IDPlaylist;
    }

    public void setIDPlaylist(int IDPlaylist) {
        this.IDPlaylist = IDPlaylist;
    }

    public String getTenBaiHat() {
        return TenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        TenBaiHat = tenBaiHat;
    }

    public String getTenCasi() {
        return TenCasi;
    }

    public void setTenCasi(String tenCasi) {
        TenCasi = tenCasi;
    }

    public int getLinkAnhBaiHat() {
        return LinkAnhBaiHat;
    }

    public void setLinkAnhBaiHat(int linkAnhBaiHat) {
        LinkAnhBaiHat = linkAnhBaiHat;
    }

    public int getLinkBaiHat() {
        return LinkBaiHat;
    }

    public void setLinkBaiHat(int linkBaiHat) {
        LinkBaiHat = linkBaiHat;
    }

    public double getSoluotNghe() {
        return SoluotNghe;
    }

    public void setSoluotNghe(double soluotNghe) {
        SoluotNghe = soluotNghe;
    }
}
