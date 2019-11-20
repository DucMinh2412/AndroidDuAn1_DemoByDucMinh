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
import com.example.androidduan1_demobyducminh.holder.MyfavoriteHolder;
import com.example.androidduan1_demobyducminh.model.Song;

import java.util.List;

public class MyfavoriteAdapter extends RecyclerView.Adapter<MyfavoriteHolder> {

    public Context context;
    public List<Song> songList;
    public RecyclerView recyclerView;

    public MyfavoriteAdapter(Context context, List<Song> songList, RecyclerView recyclerView) {
        this.context = context;
        this.songList = songList;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public MyfavoriteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(context).
                        inflate(R.layout.listsongmyfavorite, parent, false);

        MyfavoriteHolder myfavoriteHolder = new MyfavoriteHolder(view);

        return myfavoriteHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyfavoriteHolder holder, final int position) {
        Song song = songList.get(position);
        holder.tvTenbaihatYT.setText(song.getTenBaiHat());
        holder.tvTencasiYT.setText(song.getTenCasi());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PlayMusicActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return songList.size();
    }
}
