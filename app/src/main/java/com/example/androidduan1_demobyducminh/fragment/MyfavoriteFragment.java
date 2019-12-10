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
import android.widget.Toast;

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
import com.example.androidduan1_demobyducminh.dao.PlaylistDAO;
import com.example.androidduan1_demobyducminh.dao.SongDAO;
import com.example.androidduan1_demobyducminh.dao.ThemeDAO;
import com.example.androidduan1_demobyducminh.model.Favorite;
import com.example.androidduan1_demobyducminh.model.Playlist;
import com.example.androidduan1_demobyducminh.model.Song;
import com.example.androidduan1_demobyducminh.model.Theme;
import com.facebook.login.LoginManager;

import java.util.ArrayList;
import java.util.List;

public class MyfavoriteFragment extends Fragment {
    List<Favorite> favoriteList = new ArrayList<>();
    List<Song> songList = new ArrayList<>();
    List<Playlist> playlists = new ArrayList<>();
    List<Theme> themeList = new ArrayList<>();
    MyfavoriteAdapter myfavoriteAdapter;
    MyFavoriteDAO myFavoriteDAO;
    RecyclerView recyclerView;
    ImageView imageExit;
    SearchView searchView;
    Button PlayAllFavorite;
    int position = 0;
    SongDAO songDAO;
    PlaylistDAO playlistDAO;
    ThemeDAO themeDAO;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myfavorite, container, false);
        imageExit = view.findViewById(R.id.ImgExitMyFavorite);
        recyclerView = view.findViewById(R.id.rclRecycleviewMyfavorite);
        searchView = view.findViewById(R.id.svMyfavorite);
        PlayAllFavorite = view.findViewById(R.id.PlayAllFavorite);
        songDAO = new SongDAO(getContext());
        playlistDAO = new PlaylistDAO(getContext());
        themeDAO = new ThemeDAO(getContext());
        playlists = playlistDAO.ALLPlaylist();
        themeList= themeDAO.ALLTheme();
        songList = songDAO.AllSong();
        Add();
        AddPlaylist();
        AddTheme();
        myFavoriteDAO = new MyFavoriteDAO(getContext());
        favoriteList = myFavoriteDAO.ALLSONGFAVORITE();
        setRecycleview();
        FilterSong();
        popupmenu();
        OpenAll();
        return view;
    }

    public void setRecycleview() {
        recyclerView.setHasFixedSize(true);
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
                if (favoriteList.size() == 0) {
                    Toast.makeText(getContext(), "Không có dữ liệu để phát", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getContext(), PlayMusicActivity.class);
                    intent.putExtra("LinkAnhBaiHat", favoriteList.get(position).getLinkAnhBaiHat() + "");
                    intent.putExtra("LinkBaiHat", favoriteList.get(position).getLinkBaiHat() + "");
                    intent.putExtra("TenBaiHat", favoriteList.get(position).getTenBaiHat());
                    intent.putExtra("Tencasi", favoriteList.get(position).getTenCasi());
                    startActivity(intent);
                }
            }
        });
    }

    public void Add() {
        if (songList.size() == 0) {
            songDAO.InsertSONG(new Song(3, 1, "Anh đi nhé", "Anh Quân", R.drawable.anhdinhe, R.raw.anhdinhe, 10));
            songDAO.InsertSONG(new Song(3, 1, "Cô thắm không về", "Phát Hồ; Jokes Bii; Thiện", R.drawable.cothamkhongve, R.raw.cothamkhongve, 11));
            songDAO.InsertSONG(new Song(2, 2, "Nơi mình dừng chân", "Mỹ Tâm", R.drawable.noiminhdungchan, R.raw.noiminhdungchan, 12));
            songDAO.InsertSONG(new Song(2, 2, "Sau tất cả", "Erik", R.drawable.sautatca, R.raw.sautatca, 13));
            songDAO.InsertSONG(new Song(1, 2, "Tình lỡ", "Lệ Quyên", R.drawable.tinhlo, R.raw.tinhlo, 14));
            songDAO.InsertSONG(new Song(2, 2, "Dưới những cơn mưa", "Mr.siro", R.drawable.duoinhungconmua, R.raw.duoinhungconmua, 15));
            songDAO.InsertSONG(new Song(3, 1, "Em gì ơi", "Jack; K-icm", R.drawable.emgioi, R.raw.emgioi, 16));
            songDAO.InsertSONG(new Song(2, 2, "Dừng lại đây thôi", "Hoa Vinh", R.drawable.dunglaidaythoi, R.raw.dunglaidaythoi, 17));
            songDAO.InsertSONG(new Song(3, 1, "Lời yêu ngây dại", "Kha", R.drawable.loiyeungaydai, R.raw.loiyeungaydai, 18));
            songDAO.InsertSONG(new Song(3, 1, "Thay tôi yêu cô ấy", "Thanh Hưng", R.drawable.thaytoiyeucoay, R.raw.thaytoiyeucoay, 19));
        }
    }

    public void AddPlaylist() {
        if(playlists.size()==0) {
            playlistDAO.InsertPlaylist(new Playlist("#Razochart"));
            playlistDAO.InsertPlaylist(new Playlist("Nhạc chơi game"));
            playlistDAO.InsertPlaylist(new Playlist("Nhạc tâm trạng"));
        }
    }

    public void AddTheme() {
        if (themeList.size() == 0) {
            themeDAO.InsertTHEME(new Theme("Bolero"));
            themeDAO.InsertTHEME(new Theme("Trữ Tình"));
            themeDAO.InsertTHEME(new Theme("Pop-Ballab"));
        }
    }
}
