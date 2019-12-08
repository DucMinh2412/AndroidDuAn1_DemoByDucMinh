package com.example.androidduan1_demobyducminh.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.activity.PlaylistActivity;
import com.example.androidduan1_demobyducminh.holder.PlaylistHolder;
import com.example.androidduan1_demobyducminh.model.Playlist;

import java.util.List;

public class PlayListAdapter extends RecyclerView.Adapter<PlaylistHolder> {

    public Context context;
    public List<Playlist> playlists;
    public RecyclerView recyclerView;

    public PlayListAdapter(Context context, List<Playlist> playlists, RecyclerView recyclerView) {
        this.context = context;
        this.playlists = playlists;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public PlaylistHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(context).
                        inflate(R.layout.playlistmusic, parent, false);

        PlaylistHolder playlistHolder = new PlaylistHolder(view);
        return playlistHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistHolder holder, int position) {
        final Playlist playlist = playlists.get(position);
        holder.NamePlaylist.setText(playlist.getNamePlaylist());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PlaylistActivity.class);
                intent.putExtra("TenPlayList", playlist.getNamePlaylist());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return playlists.size();
    }
}
