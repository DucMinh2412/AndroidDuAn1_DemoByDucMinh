package com.example.androidduan1_demobyducminh.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;

public class MyfavoriteHolder extends RecyclerView.ViewHolder {

    public TextView tvTenbaihatYT;
    public TextView tvTencasiYT;

    public MyfavoriteHolder(@NonNull View itemView) {
        super(itemView);
        tvTenbaihatYT = itemView.findViewById(R.id.tvTenBaiHatYT);
        tvTencasiYT = itemView.findViewById(R.id.tvTencasiYT);
    }
}
