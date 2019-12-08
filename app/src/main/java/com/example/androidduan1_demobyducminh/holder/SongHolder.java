package com.example.androidduan1_demobyducminh.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;

public class SongHolder extends RecyclerView.ViewHolder {
    public TextView TenBaiHatSong, TenCaSiSong;
    public ImageView ImgAnhCaSiSong, ImgMyfavoriteSong;

    public SongHolder(@NonNull View itemView) {
        super(itemView);
        TenBaiHatSong = itemView.findViewById(R.id.tvTenBaiHatSong);
        TenCaSiSong = itemView.findViewById(R.id.tvTencasiSong);
        ImgAnhCaSiSong = itemView.findViewById(R.id.ImgAnhcasiSong);
        ImgMyfavoriteSong = itemView.findViewById(R.id.ImgFavoriteSong);
    }
}
