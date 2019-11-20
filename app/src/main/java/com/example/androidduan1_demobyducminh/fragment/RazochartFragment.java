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
import com.example.androidduan1_demobyducminh.model.Song;

import java.util.ArrayList;
import java.util.List;

public class RazochartFragment extends Fragment {
    List<Song> songList = new ArrayList<>();
    RazochartAdapter razochartAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_razochart, container, false);
        final ImageView imageExit = view.findViewById(R.id.ImgExitRazochart);
        RecyclerView recyclerView = view.findViewById(R.id.rclRecycleviewrazochart);
        recyclerView.setHasFixedSize(true);

        for (int i = 0; i < 10; i++) {
            songList.add(new Song((i + 1) + " . " + "Yêu ai để không phải khóc", "", "Hương Ly", "", 29));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        razochartAdapter = new RazochartAdapter(getContext(), songList, recyclerView);
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
}
