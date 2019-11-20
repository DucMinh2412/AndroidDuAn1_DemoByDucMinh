package com.example.androidduan1_demobyducminh.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;

public class ListPlayHolder extends RecyclerView.ViewHolder {
    public TextView TenBaiHatList, TenCaSiList, STT;

    public ListPlayHolder(@NonNull View itemView) {
        super(itemView);
        STT = itemView.findViewById(R.id.tvSTT);
        TenBaiHatList = itemView.findViewById(R.id.tvTenBaiHatList);
        TenCaSiList = itemView.findViewById(R.id.tvTencasiList);
    }
}
