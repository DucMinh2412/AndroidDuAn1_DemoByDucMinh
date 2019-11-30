package com.example.androidduan1_demobyducminh.presenter;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.androidduan1_demobyducminh.dao.SongDAO;
import com.example.androidduan1_demobyducminh.model.Top10Razochart;
import com.example.androidduan1_demobyducminh.view.PlayMusicView;

import java.util.ArrayList;
import java.util.List;

public class PlaymusicPresenter {
    public static int onTimeOnly = 0;
    public PlayMusicView playMusicView;
    public Context context;
    public double starttime = 0;
    public double finaltime = 0;
    public Handler myHandler = new Handler();
    public int position = 0;
    TextView tvNameSong, tvNameSingle;
    ImageView ImgPLAnhcasi;
    MediaPlayer mediaPlayer;
    SeekBar seekBar;
    List<Top10Razochart> razochartList = new ArrayList<>();
    SongDAO songDAO;
    private Runnable UpdateSongTime = new Runnable() {
        @Override
        public void run() {
            starttime = mediaPlayer.getCurrentPosition();
            playMusicView.setTimeStart();
            playMusicView.Seebarstart();
            myHandler.postDelayed(this, 100);
        }
    };

    // goi ham tao
    public PlaymusicPresenter(PlayMusicView playMusicView, Context context) {
        this.playMusicView = playMusicView;
        this.context = context;
    }

    public void MediaPlayer(int LinkBaiHat) {
        mediaPlayer = MediaPlayer.create(context, LinkBaiHat);
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.start();
        SetTime();
    }

    public void SetTime() {
        finaltime = mediaPlayer.getDuration();
        starttime = mediaPlayer.getCurrentPosition();
        if (onTimeOnly == 0) {
            playMusicView.SeebarMax();
        }

        playMusicView.setTimeEnd();
        playMusicView.setTimeStart();
        playMusicView.Seebarstart();
        myHandler.postDelayed(UpdateSongTime, 100);
    }

    public void Pause_Play() {
        if (mediaPlayer.isPlaying()) {
            playMusicView.Play();
        } else {
            playMusicView.Pause();
        }
    }

    public void next() {
        position--;
        if (position < 0) {
            position = razochartList.size() - 1;
        }
        if (mediaPlayer.isPlaying()) {
            playMusicView.next();
        }
        CreateMediaPlayer(tvNameSong, tvNameSingle, ImgPLAnhcasi);
        mediaPlayer.start();
    }

    public void pre() {

        position--;
        if (position < 0) {
            position = razochartList.size() - 1;
        }
        if (mediaPlayer.isPlaying()) {
            playMusicView.pre();
        }
        CreateMediaPlayer(tvNameSong, tvNameSingle, ImgPLAnhcasi);
        mediaPlayer.start();
    }


    public void CreateMediaPlayer(TextView tvNameSong, TextView tvNameSingle, ImageView ImgPLAnhcasi) {
        songDAO = new SongDAO(context);
        razochartList = songDAO.showTop10();
        mediaPlayer = MediaPlayer.create(context, razochartList.get(position).getLinkBaiHat());
        tvNameSong.setText(razochartList.get(position).getTenBaiHat());
        tvNameSingle.setText(razochartList.get(position).getTenCasi());
        ImgPLAnhcasi.setImageResource(razochartList.get(position).getLinkAnhBaiHat());
    }


}
