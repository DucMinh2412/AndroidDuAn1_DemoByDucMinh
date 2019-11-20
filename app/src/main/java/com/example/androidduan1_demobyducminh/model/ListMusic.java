package com.example.androidduan1_demobyducminh.model;

public class ListMusic {
    public int STT;
    public String tenBaiHatList, tenCaSiList;

    public ListMusic() {
    }

    public ListMusic(int STT, String tenBaiHatList, String tenCaSiList) {
        this.STT = STT;
        this.tenBaiHatList = tenBaiHatList;
        this.tenCaSiList = tenCaSiList;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getTenBaiHatList() {
        return tenBaiHatList;
    }

    public void setTenBaiHatList(String tenBaiHatList) {
        this.tenBaiHatList = tenBaiHatList;
    }

    public String getTenCaSiList() {
        return tenCaSiList;
    }

    public void setTenCaSiList(String tenCaSiList) {
        this.tenCaSiList = tenCaSiList;
    }
}
