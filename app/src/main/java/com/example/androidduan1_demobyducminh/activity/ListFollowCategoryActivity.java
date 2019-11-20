package com.example.androidduan1_demobyducminh.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.adapter.MyfavoriteAdapter;
import com.example.androidduan1_demobyducminh.model.Song;

import java.util.ArrayList;
import java.util.List;

public class ListFollowCategoryActivity extends AppCompatActivity {
    List<Song> songList = new ArrayList<>();
    MyfavoriteAdapter myfavoriteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_follow_category);

        RecyclerView recyclerView = findViewById(R.id.rclListFolowCategory);
        recyclerView.setHasFixedSize(true);
        for (int i = 0; i < 10; i++) {
            songList.add(new Song("Yêu ai để không phải khóc", "", "Hương Ly", "", 29));
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myfavoriteAdapter = new MyfavoriteAdapter(this, songList, recyclerView);
        recyclerView.setAdapter(myfavoriteAdapter);

    }

    public void PlayAllListFolowcategory(View view) {
        Intent intent = new Intent(this, PlayMusicActivity.class);
        startActivity(intent);
    }

    public void ImgExitListFolowCategory(View view) {
        finish();
    }


}
