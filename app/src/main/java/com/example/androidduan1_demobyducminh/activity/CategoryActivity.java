package com.example.androidduan1_demobyducminh.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.adapter.CategoryAdapter;
import com.example.androidduan1_demobyducminh.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    RecyclerView rclCategory;
    CategoryAdapter categoryAdapter;
    List<Category> categoryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        rclCategory = findViewById(R.id.rclCategory);

        rclCategory.setHasFixedSize(true);
        for (int i = 0; i < 9; i++) {
            categoryList.add(new Category("Bolero", ""));
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        rclCategory.setLayoutManager(gridLayoutManager);
        categoryAdapter = new CategoryAdapter(this, categoryList, rclCategory);
        rclCategory.setAdapter(categoryAdapter);
    }

    public void ImgExitCategory(View view) {
        finish();
        Animatoo.animateSlideLeft(this);
    }
}
