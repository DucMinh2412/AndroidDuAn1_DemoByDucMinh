package com.example.androidduan1_demobyducminh.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.activity.PlayMusicActivity;
import com.example.androidduan1_demobyducminh.dao.MyFavoriteDAO;
import com.example.androidduan1_demobyducminh.dao.SongDAO;
import com.example.androidduan1_demobyducminh.holder.RazoChartHolder;
import com.example.androidduan1_demobyducminh.model.Favorite;
import com.example.androidduan1_demobyducminh.model.Top10Razochart;

import java.util.ArrayList;
import java.util.List;

public class RazochartAdapter extends RecyclerView.Adapter<RazoChartHolder> implements Filterable {

    public Context context;
    public List<Top10Razochart> top10RazochartList;
    public RecyclerView recyclerView;
    SongDAO songDAO;


    public RazochartAdapter(Context context, List<Top10Razochart> top10RazochartList, RecyclerView recyclerView) {
        this.context = context;
        this.top10RazochartList = top10RazochartList;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public RazoChartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view =
                LayoutInflater.from(context).
                        inflate(R.layout.listtop10razochart, parent, false);

        RazoChartHolder razoChartHolder = new RazoChartHolder(view);
        return razoChartHolder;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Top10Razochart> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(songDAO.showTop10());
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Top10Razochart item : songDAO.showTop10()) {
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
        protected void publishResults(CharSequence constraint, FilterResults results) {
            top10RazochartList.clear();
            top10RazochartList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };


    @Override
    public int getItemCount() {
        return top10RazochartList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull final RazoChartHolder holder, int position) {

        final Top10Razochart top10Razochart = top10RazochartList.get(position);
        holder.TenBaiHatTop10.setText(top10Razochart.getTenBaiHat());
        holder.TenCaSiTop10.setText(top10Razochart.getTenCasi());
        holder.ImgAnhCaSi.setImageResource(top10Razochart.getLinkAnhBaiHat());
        songDAO = new SongDAO(context);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PlayMusicActivity.class);
                intent.putExtra("LinkAnhBaiHat", top10Razochart.getLinkAnhBaiHat() + "");
                intent.putExtra("LinkBaiHat", top10Razochart.getLinkBaiHat() + "");
                intent.putExtra("TenBaiHat", top10Razochart.getTenBaiHat());
                intent.putExtra("Tencasi", top10Razochart.getTenCasi());
                context.startActivity(intent);
            }
        });

        holder.ImgMyfavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyFavoriteDAO myFavoriteDAO = new MyFavoriteDAO(context);
                holder.ImgMyfavorite.setImageResource(R.drawable.ic_favorite_pink_24dp);
                if (myFavoriteDAO.InsertSONGFV(new Favorite("" + top10Razochart.getTenBaiHat(), "" + top10Razochart.getTenCasi(), top10Razochart.LinkAnhBaiHat, top10Razochart.getLinkAnhBaiHat())) < 0) {
                    Toast.makeText(context, "Them that bai", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(context, "Them thanh cong", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }
}


