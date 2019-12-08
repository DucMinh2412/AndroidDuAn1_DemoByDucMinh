package com.example.androidduan1_demobyducminh.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.adapter.CategoryAdapter;
import com.example.androidduan1_demobyducminh.dao.CategoryDAO;
import com.example.androidduan1_demobyducminh.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    RecyclerView rclCategory;
    CategoryAdapter categoryAdapter;
    List<Category> categoryList = new ArrayList<>();
    CategoryDAO categoryDAO;
    TextView NameThemeIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        rclCategory = findViewById(R.id.rclCategory);
        NameThemeIntent = findViewById(R.id.tvNameThemeIntent);
        categoryDAO = new CategoryDAO(this);
        String NameTheme = getIntent().getStringExtra("TenTheme");
        NameThemeIntent.setText(NameTheme);
        //AddCategory();
        AddCategoryBolero();
        AddCategoryRomantic();
        AddCategoryPopBallab();
    }

    public void AddCategoryBolero() {
        String NameThemee = NameThemeIntent.getText().toString();
        if (NameThemee.equals("Bolero")) {
            categoryList = categoryDAO.ALLCategoryBolero();
            rclCategory.setHasFixedSize(true);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
            gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
            rclCategory.setLayoutManager(gridLayoutManager);
            categoryAdapter = new CategoryAdapter(this, categoryList, rclCategory);
            rclCategory.setAdapter(categoryAdapter);
        }
    }

    public void AddCategoryRomantic() {
        String NameThemee = NameThemeIntent.getText().toString();
        if (NameThemee.equals("Trữ Tình")) {
            categoryList = categoryDAO.ALLCategoryRomantic();
            rclCategory.setHasFixedSize(true);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
            gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
            rclCategory.setLayoutManager(gridLayoutManager);
            categoryAdapter = new CategoryAdapter(this, categoryList, rclCategory);
            rclCategory.setAdapter(categoryAdapter);
        }
    }

    public void AddCategoryPopBallab() {
        String NameThemee = NameThemeIntent.getText().toString();
        if (NameThemee.equals("Pop-Ballab")) {
            categoryList = categoryDAO.ALLCategoryPopBallab();
            rclCategory.setHasFixedSize(true);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
            gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
            rclCategory.setLayoutManager(gridLayoutManager);
            categoryAdapter = new CategoryAdapter(this, categoryList, rclCategory);
            rclCategory.setAdapter(categoryAdapter);
        }
    }

    public void ImgExitCategory(View view) {
        finish();
        Animatoo.animateSlideLeft(this);
    }

    public void AddCategory() {
        categoryDAO.InsertCategory(new Category(1, "Bolero 2019"));
        categoryDAO.InsertCategory(new Category(1, "Bolero 2018"));
        categoryDAO.InsertCategory(new Category(1, "Bolero 2017"));
        categoryDAO.InsertCategory(new Category(2, "Trữ Tình 2019"));
        categoryDAO.InsertCategory(new Category(2, "Trữ Tình 2018"));
        categoryDAO.InsertCategory(new Category(2, "Trữ Tình 2017"));
        categoryDAO.InsertCategory(new Category(3, "Pop-Ballab 2019"));
        categoryDAO.InsertCategory(new Category(3, "Pop-Ballab 2018"));
        categoryDAO.InsertCategory(new Category(3, "Pop-Ballab 2017"));
    }
}
