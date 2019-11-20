package com.example.androidduan1_demobyducminh.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;

public class RazoChartHolder extends RecyclerView.ViewHolder {
    public TextView TenBaiHatTop10, TenCaSiTop10;

    public RazoChartHolder(@NonNull View itemView) {
        super(itemView);
        TenBaiHatTop10 = itemView.findViewById(R.id.tvTenBaiHatTop10);
        TenCaSiTop10 = itemView.findViewById(R.id.tvTencasiTop10);
    }
}
