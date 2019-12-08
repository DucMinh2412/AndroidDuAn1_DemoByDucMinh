package com.example.androidduan1_demobyducminh.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.activity.PlayMusicActivity;
import com.example.androidduan1_demobyducminh.holder.SongHolder;
import com.example.androidduan1_demobyducminh.model.Song;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongHolder> {
    public Context context;
    public List<Song> songList;
    public RecyclerView recyclerView;

    public SongAdapter(Context context, List<Song> songList, RecyclerView recyclerView) {
        this.context = context;
        this.songList = songList;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public SongHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view =
                LayoutInflater.from(context).
                        inflate(R.layout.song, parent, false);

        SongHolder songHolder = new SongHolder(view);
        return songHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull SongHolder holder, int position) {
        final Song song = songList.get(position);
        holder.TenBaiHatSong.setText(song.getTenBaiHat());
        holder.TenCaSiSong.setText(song.getTenCasi());
        holder.ImgAnhCaSiSong.setImageResource(song.getLinkAnhBaiHat());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PlayMusicActivity.class);
                intent.putExtra("LinkAnhBaiHat", song.getLinkAnhBaiHat() + "");
                intent.putExtra("LinkBaiHat", song.getLinkBaiHat() + "");
                intent.putExtra("TenBaiHat", song.getTenBaiHat());
                intent.putExtra("Tencasi", song.getTenCasi());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }
}
