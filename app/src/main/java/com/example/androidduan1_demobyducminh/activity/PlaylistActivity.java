package com.example.androidduan1_demobyducminh.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.adapter.SongAdapter;
import com.example.androidduan1_demobyducminh.dao.SongDAO;
import com.example.androidduan1_demobyducminh.model.Song;

import java.util.ArrayList;
import java.util.List;

public class PlaylistActivity extends AppCompatActivity {
    SongDAO songDAO;
    List<Song> songList = new ArrayList<>();
    SongAdapter songAdapter;
    RecyclerView recyclerView;
    TextView tvPlaylistIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        recyclerView = findViewById(R.id.rclPlayListIntent);
        tvPlaylistIntent = findViewById(R.id.tvNamePlaylistIntent);
        String NamePlaylist = getIntent().getStringExtra("TenPlayList");
        tvPlaylistIntent.setText(NamePlaylist);
        songDAO = new SongDAO(this);
        setRCLRazo();
        setRCLWood();
        setRCLPlayGame();

    }

    public void setRCLRazo() {
        String NamePlaylistIntent = tvPlaylistIntent.getText().toString();
        if (NamePlaylistIntent.equals("#Razochart")) {
            songList = songDAO.ALLPlaylistRazo();
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            songAdapter = new SongAdapter(this, songList, recyclerView);
            recyclerView.setAdapter(songAdapter);
        }
    }

    public void setRCLPlayGame() {
        String NamePlaylistIntent = tvPlaylistIntent.getText().toString();
        if (NamePlaylistIntent.equals("Nhạc chơi game")) {
            songList = songDAO.ALLPlaylistPlayGame();
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            songAdapter = new SongAdapter(this, songList, recyclerView);
            recyclerView.setAdapter(songAdapter);
        }
    }

    public void setRCLWood() {
        String NamePlaylistIntent = tvPlaylistIntent.getText().toString();
        if (NamePlaylistIntent.equals("Nhạc tâm trạng")) {
            songList = songDAO.ALLPlaylistMood();
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            songAdapter = new SongAdapter(this, songList, recyclerView);
            recyclerView.setAdapter(songAdapter);
        }
    }

    public void ImgExitPlaylist(View view) {
        finish();
        Animatoo.animateSlideLeft(this);
    }
}
