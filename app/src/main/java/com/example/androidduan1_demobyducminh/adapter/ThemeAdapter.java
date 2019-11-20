package com.example.androidduan1_demobyducminh.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.activity.CategoryActivity;
import com.example.androidduan1_demobyducminh.holder.ThemeHolder;
import com.example.androidduan1_demobyducminh.model.Theme;

import java.util.List;

public class ThemeAdapter extends RecyclerView.Adapter<ThemeHolder> {
    public Context context;
    public List<Theme> themeList;
    public RecyclerView recyclerView;

    public ThemeAdapter(Context context, List<Theme> themeList, RecyclerView recyclerView) {
        this.context = context;
        this.themeList = themeList;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public ThemeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(context).
                        inflate(R.layout.theme, parent, false);

        ThemeHolder themeHolder = new ThemeHolder(view);
        return themeHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ThemeHolder holder, int position) {
        Theme theme = themeList.get(position);
        holder.NameTheMe.setText(theme.getNameChuDe());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CategoryActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return themeList.size();
    }
}
