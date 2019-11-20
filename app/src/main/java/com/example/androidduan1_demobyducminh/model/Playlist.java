package com.example.androidduan1_demobyducminh.model;

public class Playlist {
    public int IDplaylist;
    public String NamePlaylist;

    public Playlist() {
    }

    public Playlist(String namePlaylist) {
        NamePlaylist = namePlaylist;
    }

    public int getIDplaylist() {
        return IDplaylist;
    }

    public void setIDplaylist(int IDplaylist) {
        this.IDplaylist = IDplaylist;
    }

    public String getNamePlaylist() {
        return NamePlaylist;
    }

    public void setNamePlaylist(String namePlaylist) {
        NamePlaylist = namePlaylist;
    }
}
