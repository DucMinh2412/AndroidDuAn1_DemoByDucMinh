package com.example.androidduan1_demobyducminh.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;

public class PlaylistHolder extends RecyclerView.ViewHolder {
    public TextView NamePlaylist;

    public PlaylistHolder(@NonNull View itemView) {
        super(itemView);
        NamePlaylist = itemView.findViewById(R.id.tvNamePlaylist);
    }
}
