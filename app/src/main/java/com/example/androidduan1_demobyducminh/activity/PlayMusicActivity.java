package com.example.androidduan1_demobyducminh.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.androidduan1_demobyducminh.R;

import java.util.concurrent.TimeUnit;

public class PlayMusicActivity extends AppCompatActivity {
    public static int onTimeOnly = 0;
    public TextView tvStart, tvEnd, tvNameSingle, tvNameSong;
    public SeekBar seekBar;
    public MediaPlayer mediaPlayer;
    public double starttime = 0;
    public double finaltime = 0;
    public Handler myHandler = new Handler();
    public ImageView ImgRamDom, ImgNext, ImgPre, ImgPause_Play, ImgRepeat;
    private Runnable UpdateSongTime = new Runnable() {
        @Override
        public void run() {
            starttime = mediaPlayer.getCurrentPosition();
            tvStart.setText(String.format("%d : %d ", TimeUnit.MILLISECONDS.toMinutes((long) starttime),
                    TimeUnit.MILLISECONDS.toSeconds((long) starttime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) starttime))
            ));
            seekBar.setProgress((int) starttime);
            myHandler.postDelayed(this, 100);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        ID();
        Intent intent = getIntent();
        int LinkBaiHat = Integer.parseInt(intent.getStringExtra("LinkBaiHat"));
        String TenBaiHat = intent.getStringExtra("TenBaiHat");
        String TenCasi = intent.getStringExtra("Tencasi");
        tvNameSong.setText(TenBaiHat);
        tvNameSingle.setText(TenCasi);
        mediaPlayer = MediaPlayer.create(PlayMusicActivity.this, LinkBaiHat);
        mediaPlayer.start();
        Start();
    }

    public void Start() {
        finaltime = mediaPlayer.getDuration();
        starttime = mediaPlayer.getCurrentPosition();
        if (onTimeOnly == 0) {
            seekBar.setMax((int) finaltime);
        }

        tvEnd.setText(String.format("%d : %d ", TimeUnit.MILLISECONDS.toMinutes((long) finaltime),
                TimeUnit.MILLISECONDS.toSeconds((long) finaltime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finaltime))
        ));

        tvStart.setText(String.format("%d : %d ", TimeUnit.MILLISECONDS.toMinutes((long) starttime),
                TimeUnit.MILLISECONDS.toSeconds((long) starttime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) starttime))
        ));

        seekBar.setProgress((int) starttime);
        myHandler.postDelayed(UpdateSongTime, 100);

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

    public void ID() {
        tvStart = findViewById(R.id.tvStart);
        tvEnd = findViewById(R.id.tvEnd);
        tvNameSingle = findViewById(R.id.tvNameSingle);
        tvNameSong = findViewById(R.id.tvNameSong);
        seekBar = findViewById(R.id.Seebar);
        ImgNext = findViewById(R.id.ImgNext);
        ImgPause_Play = findViewById(R.id.ImgPause_Play);
        ImgRamDom = findViewById(R.id.ImgRamdom);
        ImgPre = findViewById(R.id.ImgPre);
        ImgRepeat = findViewById(R.id.ImgRepeat);
    }


    public void ImgPause_Play(View view) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            ImgPause_Play.setImageResource(R.drawable.pause);
        } else {
            mediaPlayer.start();
            ImgPause_Play.setImageResource(R.drawable.play);
        }
    }
}
