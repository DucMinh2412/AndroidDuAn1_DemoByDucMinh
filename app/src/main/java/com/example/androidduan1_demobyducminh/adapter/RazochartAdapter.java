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
import com.example.androidduan1_demobyducminh.holder.RazoChartHolder;
import com.example.androidduan1_demobyducminh.model.Song;

import java.util.List;

public class RazochartAdapter extends RecyclerView.Adapter<RazoChartHolder> {

    public Context context;
    public List<Song> songList;
    public RecyclerView recyclerView;

    public RazochartAdapter(Context context, List<Song> songList, RecyclerView recyclerView) {
        this.context = context;
        this.songList = songList;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public RazoChartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(context).
                        inflate(R.layout.listtop10razochart, parent, false);

        RazoChartHolder razoChartHolder = new RazoChartHolder(view);
        return razoChartHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RazoChartHolder holder, int position) {
        Song song = songList.get(position);
        holder.TenBaiHatTop10.setText(song.getTenBaiHat());
        holder.TenCaSiTop10.setText(song.getTenCasi());

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
