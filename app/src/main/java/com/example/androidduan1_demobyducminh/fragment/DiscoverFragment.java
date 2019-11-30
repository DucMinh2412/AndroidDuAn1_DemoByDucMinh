package com.example.androidduan1_demobyducminh.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.activity.ExchangePassActivity;
import com.example.androidduan1_demobyducminh.activity.LoginActivity;
import com.example.androidduan1_demobyducminh.adapter.MyfavoriteAdapter;
import com.example.androidduan1_demobyducminh.adapter.PlayListAdapter;
import com.example.androidduan1_demobyducminh.adapter.ThemeAdapter;
import com.example.androidduan1_demobyducminh.model.Playlist;
import com.example.androidduan1_demobyducminh.model.Song;
import com.example.androidduan1_demobyducminh.model.Theme;

import java.util.ArrayList;
import java.util.List;

public class DiscoverFragment extends Fragment {
    RecyclerView rclPlaylist, rcltheme, rclIfyouwant;
    PlayListAdapter playListAdapter;
    MyfavoriteAdapter myfavoriteAdapter;
    ThemeAdapter themeAdapter;

    List<Song> songList = new ArrayList<>();
    List<Playlist> playlists = new ArrayList<>();
    List<Theme> themeList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        final ImageView imageExit = view.findViewById(R.id.ImgExitDiscover);
        rclPlaylist = view.findViewById(R.id.rclPlaylist);
        rcltheme = view.findViewById(R.id.rcltheme);
        rclIfyouwant = view.findViewById(R.id.rclIfyouwant);
        rclPlaylist.setHasFixedSize(true);
        playlists.add(new Playlist("#Razochart"));
        playlists.add(new Playlist("Nhạc chơi game"));
        playlists.add(new Playlist("Pop-Ballab"));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        rclPlaylist.setLayoutManager(gridLayoutManager);
        playListAdapter = new PlayListAdapter(getContext(), playlists, rclPlaylist);
        rclPlaylist.setAdapter(playListAdapter);

        rcltheme.setHasFixedSize(true);
        themeList.add(new Theme("Bolero"));
        themeList.add(new Theme("Trữ Tình"));
        themeList.add(new Theme("Pop-Ballab"));
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getContext(), 3);
        gridLayoutManager2.setOrientation(GridLayoutManager.VERTICAL);
        rcltheme.setLayoutManager(gridLayoutManager2);
        themeAdapter = new ThemeAdapter(getContext(), themeList, rcltheme);
        rcltheme.setAdapter(themeAdapter);


        rclIfyouwant.setHasFixedSize(true);

        rclIfyouwant.setLayoutManager(new LinearLayoutManager(getContext()));
        myfavoriteAdapter = new MyfavoriteAdapter(getContext(), songList, rclIfyouwant);
        rclIfyouwant.setAdapter(myfavoriteAdapter);

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
