package com.example.androidduan1_demobyducminh.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;

public class CategoryHolder extends RecyclerView.ViewHolder {
    public TextView NameCategory;

    public CategoryHolder(@NonNull View itemView) {
        super(itemView);
        NameCategory = itemView.findViewById(R.id.tvNameCategory);
    }
}
