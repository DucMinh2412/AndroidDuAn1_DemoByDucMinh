package com.example.androidduan1_demobyducminh.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.activity.ExchangePassActivity;
import com.example.androidduan1_demobyducminh.activity.LoginActivity;
import com.example.androidduan1_demobyducminh.adapter.RazochartAdapter;
import com.example.androidduan1_demobyducminh.dao.SongDAO;
import com.example.androidduan1_demobyducminh.model.Top10Razochart;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    List<Top10Razochart> top10RazochartList = new ArrayList<>();
    RazochartAdapter razochartAdapter;
    RecyclerView recyclerView;
    SongDAO songDAO;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        final ImageView imageExit = view.findViewById(R.id.ImgExitSearch);
        recyclerView = view.findViewById(R.id.rclRecycleviewSearch);
        final SearchView searchView = view.findViewById(R.id.svSearch);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                songDAO = new SongDAO(getContext());
                top10RazochartList = songDAO.searchWord(s);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                razochartAdapter = new RazochartAdapter(getContext(), top10RazochartList, recyclerView);
                recyclerView.setAdapter(razochartAdapter);
                return true;
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
