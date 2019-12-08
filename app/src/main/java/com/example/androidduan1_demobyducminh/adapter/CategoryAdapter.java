package com.example.androidduan1_demobyducminh.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.activity.ListFollowCategoryActivity;
import com.example.androidduan1_demobyducminh.holder.CategoryHolder;
import com.example.androidduan1_demobyducminh.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryHolder> {
    public Context context;
    public List<Category> categoryList;
    public RecyclerView recyclerView;

    public CategoryAdapter(Context context, List<Category> categoryList, RecyclerView recyclerView) {
        this.context = context;
        this.categoryList = categoryList;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(context).
                        inflate(R.layout.category, parent, false);

        CategoryHolder categoryHolder = new CategoryHolder(view);
        return categoryHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        final Category category = categoryList.get(position);
        holder.NameCategory.setText(category.getTenTheLoai());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ListFollowCategoryActivity.class);
                intent.putExtra("TenCategory", category.getTenTheLoai());
                context.startActivity(intent);
            }

        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
