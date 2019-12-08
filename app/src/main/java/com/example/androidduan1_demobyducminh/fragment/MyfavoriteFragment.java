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
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.activity.ExchangePassActivity;
import com.example.androidduan1_demobyducminh.activity.LoginActivity;
import com.example.androidduan1_demobyducminh.activity.PlayMusicActivity;
import com.example.androidduan1_demobyducminh.adapter.MyfavoriteAdapter;
import com.example.androidduan1_demobyducminh.dao.MyFavoriteDAO;
import com.example.androidduan1_demobyducminh.model.Favorite;
import com.facebook.login.LoginManager;

import java.util.ArrayList;
import java.util.List;

public class MyfavoriteFragment extends Fragment {
    List<Favorite> favoriteList = new ArrayList<>();
    MyfavoriteAdapter myfavoriteAdapter;
    MyFavoriteDAO myFavoriteDAO;
    RecyclerView recyclerView;
    ImageView imageExit;
    SearchView searchView;
    Button Filter;
    Button PlayAllFavorite;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myfavorite, container, false);
        imageExit = view.findViewById(R.id.ImgExitMyFavorite);
        recyclerView = view.findViewById(R.id.rclRecycleviewMyfavorite);
        searchView = view.findViewById(R.id.svMyfavorite);
        PlayAllFavorite = view.findViewById(R.id.PlayAllFavorite);
        myFavoriteDAO = new MyFavoriteDAO(getContext());
        setRecycleview();
        FilterSong();
        popupmenu();
        OpenAll();
        return view;
    }

    public void setRecycleview() {
        recyclerView.setHasFixedSize(true);
        favoriteList = myFavoriteDAO.ALLSONGFAVORITE();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myfavoriteAdapter = new MyfavoriteAdapter(getContext(), favoriteList, recyclerView);
        recyclerView.setAdapter(myfavoriteAdapter);
    }

    public void FilterSong() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                myfavoriteAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                return false;
            }
        });
    }

    public void popupmenu() {
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
                                LoginManager.getInstance().logOut();
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

    public void OpenAll() {
        PlayAllFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PlayMusicActivity.class);
                startActivity(intent);
            }
        });
    }
}
