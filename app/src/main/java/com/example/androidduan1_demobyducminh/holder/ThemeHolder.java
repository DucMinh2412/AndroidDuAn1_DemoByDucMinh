package com.example.androidduan1_demobyducminh.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;

public class ThemeHolder extends RecyclerView.ViewHolder {
    public TextView NameTheMe;

    public ThemeHolder(@NonNull View itemView) {
        super(itemView);
        NameTheMe = itemView.findViewById(R.id.tvNameTheme);

    }
}
