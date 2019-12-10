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
import com.example.androidduan1_demobyducminh.model.Top10Razochart;

import java.util.ArrayList;
import java.util.List;

public class RazochartFragment extends Fragment {
    List<Top10Razochart> top10RazochartList = new ArrayList<>();
    RazochartAdapter razochartAdapter;
    SongDAO songDAO;
    ImageView imageExit;
    RecyclerView recyclerView;
    Button PlayAllRazoChart;
    int position =0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_razochart, container, false);
        imageExit = view.findViewById(R.id.ImgExitRazochart);
        recyclerView = view.findViewById(R.id.rclRecycleviewrazochart);
        PlayAllRazoChart = view.findViewById(R.id.PlayAllRazoChart);
        songDAO = new SongDAO(getContext());
        top10RazochartList = songDAO.showTop10();
        Exit();
        setAdapter();
        PlayAll();
        return view;
    }


    public void setAdapter() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        razochartAdapter = new RazochartAdapter(getContext(), top10RazochartList, recyclerView);
        recyclerView.setAdapter(razochartAdapter);
    }

    public void PlayAll() {
        PlayAllRazoChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PlayMusicActivity.class);
                intent.putExtra("LinkAnhBaiHat", top10RazochartList.get(position).getLinkAnhBaiHat()+"");
                intent.putExtra("LinkBaiHat",top10RazochartList.get(position).getLinkBaiHat()+"");
                intent.putExtra("TenBaiHat", top10RazochartList.get(position).getTenBaiHat());
                intent.putExtra("Tencasi", top10RazochartList.get(position).getTenCasi());
                startActivity(intent);
            }
        });
    }

    public void Exit() {
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
    }




}
