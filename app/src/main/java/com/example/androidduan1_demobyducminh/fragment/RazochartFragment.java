package com.example.androidduan1_demobyducminh.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.activity.ExchangePassActivity;
import com.example.androidduan1_demobyducminh.activity.LoginActivity;
import com.example.androidduan1_demobyducminh.activity.PlayMusicActivity;
import com.example.androidduan1_demobyducminh.adapter.RazochartAdapter;
import com.example.androidduan1_demobyducminh.dao.SongDAO;
import com.example.androidduan1_demobyducminh.model.Song;
import com.example.androidduan1_demobyducminh.model.Top10Razochart;

import java.util.ArrayList;
import java.util.List;

public class RazochartFragment extends Fragment {
    List<Top10Razochart> top10RazochartList = new ArrayList<>();
    RazochartAdapter razochartAdapter;
    SongDAO songDAO;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_razochart, container, false);
        final ImageView imageExit = view.findViewById(R.id.ImgExitRazochart);
        RecyclerView recyclerView = view.findViewById(R.id.rclRecycleviewrazochart);
        songDAO = new SongDAO(getContext());
        top10RazochartList = songDAO.showTop10();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        razochartAdapter = new RazochartAdapter(getContext(), top10RazochartList, recyclerView);
        recyclerView.setAdapter(razochartAdapter);

        Button PlayAllRazoChart = view.findViewById(R.id.PlayAllRazoChart);
        PlayAllRazoChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PlayMusicActivity.class);
                startActivity(intent);
            }
        });

        // popupmenu
        imageExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getContext(), imageExit);
                popupMenu.getMenuInflater().inflate(R.menu.popupmenu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.dangxuat:
                                Intent intent = new Intent(getContext(), LoginActivity.class);
                                startActivity(intent);
                                break;

                            case R.id.doimatkhau:
                                Intent intent2 = new Intent(getContext(), ExchangePassActivity.class);
                                startActivity(intent2);
                                break;

                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
        return view;
    }

    public void Add() {
        songDAO.InsertSONG(new Song("Anh đi nhé", "Anh Quân", R.drawable.anhdinhe, R.raw.anhdinhe, 10));
        songDAO.InsertSONG(new Song("Cô thắm không về", "Phát Hồ; Jokes Bii; Thiện", R.drawable.cothamkhongve, R.raw.cothamkhongve, 11));
        songDAO.InsertSONG(new Song("Nơi mình dừng chân", "Mỹ Tâm", R.drawable.noiminhdungchan, R.raw.noiminhdungchan, 12));
        songDAO.InsertSONG(new Song("Sau tất cả", "Erik", R.drawable.sautatca, R.raw.sautatca, 13));
        songDAO.InsertSONG(new Song("Tình lỡ", "Lệ Quyên", R.drawable.tinhlo, R.raw.tinhlo, 14));
        songDAO.InsertSONG(new Song("Dưới những cơn mưa", "Mr.siro", R.drawable.duoinhungconmua, R.raw.duoinhungconmua, 15));
        songDAO.InsertSONG(new Song("Em gì ơi", "Jack; K-icm", R.drawable.emgioi, R.raw.emgioi, 16));
        songDAO.InsertSONG(new Song("Dừng lại đây thôi", "Hoa Vinh", R.drawable.dunglaidaythoi, R.raw.dunglaidaythoi, 17));
        songDAO.InsertSONG(new Song("Lời yêu ngây dại", "Kha", R.drawable.loiyeungaydai, R.raw.loiyeungaydai, 18));
        songDAO.InsertSONG(new Song("Thay tôi yêu cô ấy", "Thanh Hưng", R.drawable.thaytoiyeucoay, R.raw.thaytoiyeucoay, 19));
    }



}
