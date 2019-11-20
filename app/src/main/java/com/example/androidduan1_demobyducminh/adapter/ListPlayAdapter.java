package com.example.androidduan1_demobyducminh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.holder.ListPlayHolder;
import com.example.androidduan1_demobyducminh.model.ListMusic;

import java.util.List;

public class ListPlayAdapter extends RecyclerView.Adapter<ListPlayHolder> {

    public Context context;
    public List<ListMusic> musicList;
    public RecyclerView recyclerView;

    public ListPlayAdapter(Context context, List<ListMusic> musicList, RecyclerView recyclerView) {
        this.context = context;
        this.musicList = musicList;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public ListPlayHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(context).
                        inflate(R.layout.listplaymusic, parent, false);

        ListPlayHolder listPlayHolder = new ListPlayHolder(view);
        return listPlayHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListPlayHolder holder, int position) {
        ListMusic listMusic = musicList.get(position);
        holder.STT.setText(listMusic.getSTT() + "");
        holder.TenBaiHatList.setText(listMusic.getTenBaiHatList());
        holder.TenCaSiList.setText(listMusic.getTenCaSiList());
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }
}
