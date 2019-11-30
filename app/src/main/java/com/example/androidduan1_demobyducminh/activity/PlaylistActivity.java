package com.example.androidduan1_demobyducminh.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.androidduan1_demobyducminh.R;

public class PlaylistActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        RecyclerView recyclerView = findViewById(R.id.rclPlayListPlayGame);
        recyclerView.setHasFixedSize(true);

    }

    public void ImgExitMusicPlayGame(View view) {
        finish();
        Animatoo.animateSlideLeft(this);
    }
}
