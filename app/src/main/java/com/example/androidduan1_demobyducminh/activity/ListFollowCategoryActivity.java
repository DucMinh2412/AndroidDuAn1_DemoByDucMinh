package com.example.androidduan1_demobyducminh.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;

public class ListFollowCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_follow_category);

        RecyclerView recyclerView = findViewById(R.id.rclListFolowCategory);
        recyclerView.setHasFixedSize(true);


    }

    public void PlayAllListFolowcategory(View view) {
        Intent intent = new Intent(this, PlayMusicActivity.class);
        startActivity(intent);
    }

    public void ImgExitListFolowCategory(View view) {
        finish();
    }


}
