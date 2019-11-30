package com.example.androidduan1_demobyducminh.model;

public class Top10Razochart {
    public int IDBaiHat;
    public String TenCasi, TenBaiHat;
    public int LinkAnhBaiHat, LinkBaiHat;
    public double SoluotNghe;

    public Top10Razochart() {
    }

    public Top10Razochart(String tenCasi, String tenBaiHat, int linkAnhBaiHat, int linkBaiHat, double soluotNghe) {
        TenCasi = tenCasi;
        TenBaiHat = tenBaiHat;
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

    public String getTenCasi() {
        return TenCasi;
    }

    public void setTenCasi(String tenCasi) {
        TenCasi = tenCasi;
    }

    public String getTenBaiHat() {
        return TenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        TenBaiHat = tenBaiHat;
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
