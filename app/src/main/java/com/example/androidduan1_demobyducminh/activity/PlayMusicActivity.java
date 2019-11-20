package com.example.androidduan1_demobyducminh.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.androidduan1_demobyducminh.R;

public class PlayMusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
    }

    public void ImgHuongLy(View view) {
        Intent intent = new Intent(this, ListPlayMusicActivity.class);
        startActivity(intent);
        finish();
    }

    public void ImgExitPlayMusic(View view) {
        finish();
        Animatoo.animateSlideDown(this);
    }


}
