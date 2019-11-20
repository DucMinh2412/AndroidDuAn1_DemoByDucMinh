package com.example.androidduan1_demobyducminh.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.adapter.ListPlayAdapter;
import com.example.androidduan1_demobyducminh.model.ListMusic;

import java.util.ArrayList;
import java.util.List;

public class ListPlayMusicActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<ListMusic> musicList = new ArrayList<>();
    ListPlayAdapter listPlayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_play_music);
        recyclerView = findViewById(R.id.RclListplay);
        recyclerView.setHasFixedSize(true);

        for (int i = 0; i < 5; i++) {
            musicList.add(new ListMusic(i + 1, "Yêu ai để không phải khóc", "Hương Ly"));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listPlayAdapter = new ListPlayAdapter(this, musicList, recyclerView);
        recyclerView.setAdapter(listPlayAdapter);

    }

    public void ImgExitListPlayMusic(View view) {
        finish();
        Animatoo.animateSlideDown(this);
    }
}
