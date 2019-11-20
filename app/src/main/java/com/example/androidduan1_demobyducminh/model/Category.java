package com.example.androidduan1_demobyducminh.model;

public class Category {
    public int IDTheLoai;
    public String TenTheLoai, TenChuDeTM;

    public Category() {
    }

    public Category(String tenTheLoai, String tenChuDeTM) {
        TenTheLoai = tenTheLoai;
        TenChuDeTM = tenChuDeTM;
    }

    public int getIDTheLoai() {
        return IDTheLoai;
    }

    public void setIDTheLoai(int IDTheLoai) {
        this.IDTheLoai = IDTheLoai;
    }

    public String getTenTheLoai() {
        return TenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        TenTheLoai = tenTheLoai;
    }

    public String getTenChuDeTM() {
        return TenChuDeTM;
    }

    public void setTenChuDeTM(String tenChuDeTM) {
        TenChuDeTM = tenChuDeTM;
    }
}
