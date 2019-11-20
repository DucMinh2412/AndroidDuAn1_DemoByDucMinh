package com.example.androidduan1_demobyducminh.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.adapter.RazochartAdapter;
import com.example.androidduan1_demobyducminh.model.Song;

import java.util.ArrayList;
import java.util.List;

public class PlaylistActivity extends AppCompatActivity {
    List<Song> songList = new ArrayList<>();
    RazochartAdapter razochartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        RecyclerView recyclerView = findViewById(R.id.rclPlayListPlayGame);
        recyclerView.setHasFixedSize(true);

        for (int i = 0; i < 10; i++) {
            songList.add(new Song("Yêu ai để không phải khóc", "", "Hương Ly", "", 29));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        razochartAdapter = new RazochartAdapter(this, songList, recyclerView);
        recyclerView.setAdapter(razochartAdapter);
    }

    public void ImgExitMusicPlayGame(View view) {
        finish();
        Animatoo.animateSlideLeft(this);
    }
}
