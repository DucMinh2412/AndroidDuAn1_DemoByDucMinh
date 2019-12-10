package com.example.androidduan1_demobyducminh.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.adapter.SongAdapter;
import com.example.androidduan1_demobyducminh.dao.SongDAO;
import com.example.androidduan1_demobyducminh.model.Song;

import java.util.ArrayList;
import java.util.List;

public class ListFollowCategoryActivity extends AppCompatActivity {
    TextView NameCategoryIntent;
    RecyclerView recyclerView;
    SongDAO songDAO;
    List<Song> songList = new ArrayList<>();
    SongAdapter songAdapter;
    Button PlayAllListFolowcategory;
    int position = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_follow_category);
        recyclerView = findViewById(R.id.rclListFolowCategory);
        NameCategoryIntent = findViewById(R.id.tvNameCategoryIntent);
        PlayAllListFolowcategory = findViewById(R.id.PlayAllListFolowcategory);
        String TenCategory = getIntent().getStringExtra("TenCategory");
        NameCategoryIntent.setText(TenCategory);
        songDAO = new SongDAO(this);
        setRCLBolero();
        setRCLRomantic();
        setRCLPopBallab();

    }

    public void setRCLBolero() {
        String NameCategoryy = NameCategoryIntent.getText().toString();
        if (NameCategoryy.equals("Bolero 2019") || NameCategoryy.equals("Bolero 2018") || NameCategoryy.equals("Bolero 2017")) {
            songList = songDAO.ALLPlaylistBolero();
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            songAdapter = new SongAdapter(this, songList, recyclerView);
            recyclerView.setAdapter(songAdapter);
            PlayAllListFolowcategory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ListFollowCategoryActivity.this, PlayMusicActivity.class);
                    intent.putExtra("LinkAnhBaiHat", songList.get(position).getLinkAnhBaiHat()+"");
                    intent.putExtra("LinkBaiHat",songList.get(position).getLinkBaiHat()+"");
                    intent.putExtra("TenBaiHat", songList.get(position).getTenBaiHat());
                    intent.putExtra("Tencasi", songList.get(position).getTenCasi());
                    startActivity(intent);
                }
            });
        }
    }

    public void setRCLRomantic() {
        String NameCategoryy = NameCategoryIntent.getText().toString();
        if (NameCategoryy.equals("Trữ Tình 2019") || NameCategoryy.equals("Trữ Tình 2018") || NameCategoryy.equals("Trữ Tình 2017")) {
            songList = songDAO.ALLPlaylistRomantic();
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            songAdapter = new SongAdapter(this, songList, recyclerView);
            recyclerView.setAdapter(songAdapter);
            PlayAllListFolowcategory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ListFollowCategoryActivity.this, PlayMusicActivity.class);
                    intent.putExtra("LinkAnhBaiHat", songList.get(position).getLinkAnhBaiHat()+"");
                    intent.putExtra("LinkBaiHat",songList.get(position).getLinkBaiHat()+"");
                    intent.putExtra("TenBaiHat", songList.get(position).getTenBaiHat());
                    intent.putExtra("Tencasi", songList.get(position).getTenCasi());
                    startActivity(intent);
                }
            });
        }
    }

    public void setRCLPopBallab() {
        String NameCategoryy = NameCategoryIntent.getText().toString();
        if (NameCategoryy.equals("Pop-Ballab 2019") || NameCategoryy.equals("Pop-Ballab 2018") || NameCategoryy.equals("Pop-Ballab 2017")) {
            songList = songDAO.ALLPlaylistPopBallab();
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            songAdapter = new SongAdapter(this, songList, recyclerView);
            recyclerView.setAdapter(songAdapter);
            PlayAllListFolowcategory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ListFollowCategoryActivity.this, PlayMusicActivity.class);
                    intent.putExtra("LinkAnhBaiHat", songList.get(position).getLinkAnhBaiHat()+"");
                    intent.putExtra("LinkBaiHat",songList.get(position).getLinkBaiHat()+"");
                    intent.putExtra("TenBaiHat", songList.get(position).getTenBaiHat());
                    intent.putExtra("Tencasi", songList.get(position).getTenCasi());
                    startActivity(intent);
                }
            });
        }
    }


    public void ImgExitListFolowCategory(View view) {
        finish();
    }


}
