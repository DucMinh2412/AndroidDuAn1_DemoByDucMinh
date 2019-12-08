package com.example.androidduan1_demobyducminh.model;

public class Category {
    public int IDTheLoai, IDChuDe;
    public String TenTheLoai;

    public Category() {
    }

    public Category(int IDChuDe, String tenTheLoai) {
        this.IDChuDe = IDChuDe;
        TenTheLoai = tenTheLoai;
    }

    public int getIDTheLoai() {
        return IDTheLoai;
    }

    public void setIDTheLoai(int IDTheLoai) {
        this.IDTheLoai = IDTheLoai;
    }

    public int getIDChuDe() {
        return IDChuDe;
    }

    public void setIDChuDe(int IDChuDe) {
        this.IDChuDe = IDChuDe;
    }

    public String getTenTheLoai() {
        return TenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        TenTheLoai = tenTheLoai;
    }
}
