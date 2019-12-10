package com.example.androidduan1_demobyducminh.activity;

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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayMusicActivity extends AppCompatActivity {
    public TextView tvStart, tvEnd, tvNameSingle, tvNameSong;
    public static int onTimeOnly = 0;
    public SeekBar seekBar;
    public  MediaPlayer mediaPlayer;
    public ImageView ImgRamDom, ImgNext, ImgPre, ImgPause_Play, ImgRepeat, ImgPLAnhcasi;
    public Handler myHandler = new Handler();
    public int position;
    List<Top10Razochart> razochartList = new ArrayList<>();
    SongDAO songDAO;
    int LinkAnhBaiHat;
    int LinkBaiHat;
    String TenBaiHat;
    String TenCasi;
    boolean repeat = false;
    boolean checkramdom = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        ID();
        LinkAnhBaiHat = Integer.parseInt(getIntent().getStringExtra("LinkAnhBaiHat"));
        LinkBaiHat = Integer.parseInt(getIntent().getStringExtra("LinkBaiHat"));
        TenBaiHat = getIntent().getStringExtra("TenBaiHat");
        TenCasi = getIntent().getStringExtra("Tencasi");
        songDAO = new SongDAO(this);
        razochartList = songDAO.showTop10();
        tvNameSong.setText(TenBaiHat);
        tvNameSingle.setText(TenCasi);
        ImgPLAnhcasi.setImageResource(LinkAnhBaiHat);
        Start();
        setTime();
        OnSeeBar();
    }

    public void Start(){
            mediaPlayer = MediaPlayer.create(PlayMusicActivity.this, LinkBaiHat);
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
            } else {
                mediaPlayer.start();
            }

    }

    public void setTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        if (onTimeOnly == 0) {
            seekBar.setMax(mediaPlayer.getDuration());
        }

        tvEnd.setText(simpleDateFormat.format(mediaPlayer.getDuration()));

        tvStart.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition()));

        seekBar.setProgress(mediaPlayer.getCurrentPosition());
        myHandler.postDelayed(UpdateSongTime, 100);
    }

    private Runnable UpdateSongTime = new Runnable() {
        @Override
        public void run() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
            tvStart.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition()));
            seekBar.setProgress(mediaPlayer.getCurrentPosition());
            myHandler.postDelayed(this, 100);
        }
    };

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
            mediaPlayer.release();
        }

        if (repeat == true) {
            position = position - 1;

        }

        if (checkramdom == true) {
            Random random = new Random();
            int index = random.nextInt(razochartList.size());
            if (index == position) {
                position = index - 1;
            }
            position = index;
        }
        CreateMediaPlayer();
        mediaPlayer.start();
        ImgPause_Play.setImageResource(R.drawable.play);
    }

    public void ImgNext(View view) {
        position++;
        if (position > razochartList.size() - 1) {
            position = 0;
        }
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }

        if (repeat == true) {
            position = position - 1;
        }

        if (checkramdom == true) {
            Random random = new Random();
            int index = random.nextInt(razochartList.size());
            if (index == position) {
                position = index - 1;
            }
            position = index;
        }

        CreateMediaPlayer();
        mediaPlayer.start();
        ImgPause_Play.setImageResource(R.drawable.play);
    }

    public void ImgRamDom(View view) {
        if (checkramdom == false) {
            if (repeat == true) {
                repeat = false;
                ImgRamDom.setImageResource(R.drawable.arrows);
                ImgRepeat.setImageResource(R.drawable.repeat);
            }
            ImgRamDom.setImageResource(R.drawable.ff);
            checkramdom = true;
        } else {
            ImgRamDom.setImageResource(R.drawable.arrows);
            checkramdom = false;
        }
    }


    public void Imgrepeat(View view) {
        if (repeat == false) {
            if (checkramdom == true) {
                checkramdom = false;
                ImgRepeat.setImageResource(R.drawable.repeat);
                ImgRamDom.setImageResource(R.drawable.ff);
            }
            ImgRepeat.setImageResource(R.drawable.repeat);
            repeat = true;
        } else {
            ImgRepeat.setImageResource(R.drawable.repeatone);
            repeat = false;
        }


    }

    public void OnSeeBar() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
    }

    public void CreateMediaPlayer() {
        mediaPlayer = MediaPlayer.create(PlayMusicActivity.this, razochartList.get(position).getLinkBaiHat());
        tvNameSong.setText(razochartList.get(position).getTenBaiHat());
        tvNameSingle.setText(razochartList.get(position).getTenCasi());
        ImgPLAnhcasi.setImageResource(razochartList.get(position).getLinkAnhBaiHat());
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
