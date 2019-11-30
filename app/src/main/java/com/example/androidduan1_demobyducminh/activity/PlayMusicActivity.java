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
import com.example.androidduan1_demobyducminh.dao.SongDAO;
import com.example.androidduan1_demobyducminh.model.Top10Razochart;
import com.example.androidduan1_demobyducminh.presenter.PlaymusicPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PlayMusicActivity extends AppCompatActivity {
    public TextView tvStart, tvEnd, tvNameSingle, tvNameSong;
    public static int onTimeOnly = 0;
    public SeekBar seekBar;
    public MediaPlayer mediaPlayer;
    public double starttime = 0;
    public double finaltime = 0;
    public ImageView ImgRamDom, ImgNext, ImgPre, ImgPause_Play, ImgRepeat, ImgPLAnhcasi;
    public Handler myHandler = new Handler();
    public int position = 0;
    List<Top10Razochart> razochartList = new ArrayList<>();
    SongDAO songDAO;
    PlaymusicPresenter playmusicPresenter;
    private Runnable UpdateSongTime = new Runnable() {
        @Override
        public void run() {
            starttime = mediaPlayer.getCurrentPosition();
            tvStart.setText(String.format("%d : %d", TimeUnit.MILLISECONDS.toMinutes((long) starttime),
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
        songDAO = new SongDAO(this);
        razochartList = songDAO.showTop10();
        Intent intent = getIntent();
        int LinkAnhBaiHat = Integer.parseInt(intent.getStringExtra("LinkAnhBaiHat"));
        int LinkBaiHat = Integer.parseInt(intent.getStringExtra("LinkBaiHat"));
        String TenBaiHat = intent.getStringExtra("TenBaiHat");
        String TenCasi = intent.getStringExtra("Tencasi");
        tvNameSong.setText(TenBaiHat);
        tvNameSingle.setText(TenCasi);
        ImgPLAnhcasi.setImageResource(LinkAnhBaiHat);
        mediaPlayer = MediaPlayer.create(PlayMusicActivity.this, LinkBaiHat);
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.start();
        setTime();
    }

    public void setTime() {
        finaltime = mediaPlayer.getDuration();
        starttime = mediaPlayer.getCurrentPosition();
        if (onTimeOnly == 0) {
            seekBar.setMax((int) finaltime);
        }

        tvEnd.setText(String.format("%d : %d", TimeUnit.MILLISECONDS.toMinutes((long) finaltime),
                TimeUnit.MILLISECONDS.toSeconds((long) finaltime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finaltime))
        ));

        tvStart.setText(String.format("%d : %d", TimeUnit.MILLISECONDS.toMinutes((long) starttime),
                TimeUnit.MILLISECONDS.toSeconds((long) starttime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) starttime))
        ));

        seekBar.setProgress((int) starttime);
        myHandler.postDelayed(UpdateSongTime, 100);

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


    public void ImgPre(View view) {
        position--;
        if (position < 0) {
            position = razochartList.size() - 1;
        }
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        CreateMediaPlayer();
        mediaPlayer.start();
    }

    public void ImgNext(View view) {
        position++;
        if (position > razochartList.size() - 1) {
            position = 0;
        }
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        CreateMediaPlayer();
        mediaPlayer.start();
    }

    public void CreateMediaPlayer() {
        mediaPlayer = MediaPlayer.create(PlayMusicActivity.this, razochartList.get(position).getLinkBaiHat());
        tvNameSong.setText(razochartList.get(position).getTenBaiHat());
        tvNameSingle.setText(razochartList.get(position).getTenCasi());
        ImgPLAnhcasi.setImageResource(razochartList.get(position).getLinkAnhBaiHat());
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
        ImgPLAnhcasi = findViewById(R.id.ImgPLAnhCasi);

    }


}
