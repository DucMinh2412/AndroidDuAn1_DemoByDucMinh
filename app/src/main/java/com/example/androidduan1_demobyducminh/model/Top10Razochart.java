package com.example.androidduan1_demobyducminh.model;

public class Top10Razochart {
    public int IDBaiHat;
    public String TenCasi, LinkAnhCaSi, TenBaiHat, LinkBaiHat;
    public double SoluotNghe;

    public Top10Razochart() {
    }

    public Top10Razochart(String tenCasi, String linkAnhCaSi, String tenBaiHat, String linkBaiHat, double soluotNghe) {
        TenCasi = tenCasi;
        LinkAnhCaSi = linkAnhCaSi;
        TenBaiHat = tenBaiHat;
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

    public String getLinkAnhCaSi() {
        return LinkAnhCaSi;
    }

    public void setLinkAnhCaSi(String linkAnhCaSi) {
        LinkAnhCaSi = linkAnhCaSi;
    }

    public String getTenBaiHat() {
        return TenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        TenBaiHat = tenBaiHat;
    }

    public String getLinkBaiHat() {
        return LinkBaiHat;
    }

    public void setLinkBaiHat(String linkBaiHat) {
        LinkBaiHat = linkBaiHat;
    }

    public double getSoluotNghe() {
        return SoluotNghe;
    }

    public void setSoluotNghe(double soluotNghe) {
        SoluotNghe = soluotNghe;
    }
}
