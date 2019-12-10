package com.example.androidduan1_demobyducminh.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.activity.PlayMusicActivity;
import com.example.androidduan1_demobyducminh.dao.MyFavoriteDAO;
import com.example.androidduan1_demobyducminh.holder.MyfavoriteHolder;
import com.example.androidduan1_demobyducminh.model.Favorite;

import java.util.ArrayList;
import java.util.List;

public class MyfavoriteAdapter extends RecyclerView.Adapter<MyfavoriteHolder> implements Filterable {

    public Context context;
    public List<Favorite> favoriteList;
    public RecyclerView recyclerView;
    MyFavoriteDAO myFavoriteDAO;


    public MyfavoriteAdapter(Context context, List<Favorite> favoriteList, RecyclerView recyclerView) {
        this.context = context;
        this.favoriteList = favoriteList;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public MyfavoriteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(context).
                        inflate(R.layout.listsongmyfavorite, parent, false);

        MyfavoriteHolder myfavoriteHolder = new MyfavoriteHolder(view);

        return myfavoriteHolder;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Favorite> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(myFavoriteDAO.ALLSONGFAVORITE());
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Favorite item : myFavoriteDAO.ALLSONGFAVORITE()) {
                    if (item.getTenBaiHat().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            favoriteList.clear();
            favoriteList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    @Override
    public int getItemCount() {
        return favoriteList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull final MyfavoriteHolder holder, final int position) {
        final Favorite favorite = favoriteList.get(position);
        holder.tvTenbaihatYT.setText(favorite.getTenBaiHat());
        holder.tvTencasiYT.setText(favorite.getTenCasi());
        holder.ImgAnhcasi.setImageResource(favorite.getLinkAnhBaiHat());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PlayMusicActivity.class);
                intent.putExtra("LinkAnhBaiHat", favorite.getLinkAnhBaiHat() + "");
                intent.putExtra("LinkBaiHat", favorite.getLinkBaiHat() + "");
                intent.putExtra("TenBaiHat", favorite.getTenBaiHat());
                intent.putExtra("Tencasi", favorite.getTenCasi());
                context.startActivity(intent);
            }
        });

        holder.ImgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Xóa bài hát khỏi danh sách yêu thích ?");
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myFavoriteDAO = new MyFavoriteDAO(context);
                        holder.ImgFavorite.setImageResource(R.drawable.ic_favorite_black_24dp);
                        myFavoriteDAO.delete(favorite.getIDFavorite());
                        favoriteList.remove(position);
                        recyclerView.removeViewAt(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, favoriteList.size());
                        notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create();
                builder.show();
            }
        });

    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }
}

