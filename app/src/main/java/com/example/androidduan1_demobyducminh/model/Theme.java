package com.example.androidduan1_demobyducminh.model;

public class Theme {
    public int IDchuDe;
    public String NameChuDe;

    public Theme() {
    }

    public Theme(String nameChuDe) {
        NameChuDe = nameChuDe;
    }

    public int getIDchuDe() {
        return IDchuDe;
    }

    public void setIDchuDe(int IDchuDe) {
        this.IDchuDe = IDchuDe;
    }

    public String getNameChuDe() {
        return NameChuDe;
    }

    public void setNameChuDe(String nameChuDe) {
        NameChuDe = nameChuDe;
    }
}
