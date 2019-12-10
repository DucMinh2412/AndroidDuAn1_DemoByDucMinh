package com.example.androidduan1_demobyducminh.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidduan1_demobyducminh.R;
import com.example.androidduan1_demobyducminh.activity.PlayMusicActivity;
import com.example.androidduan1_demobyducminh.dao.MyFavoriteDAO;
import com.example.androidduan1_demobyducminh.dao.SongDAO;
import com.example.androidduan1_demobyducminh.holder.SongHolder;
import com.example.androidduan1_demobyducminh.model.Favorite;
import com.example.androidduan1_demobyducminh.model.Song;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongHolder> {
    public Context context;
    public List<Song> songList;
    public RecyclerView recyclerView;
    public SongDAO songDAO;

    public SongAdapter(Context context, List<Song> songList, RecyclerView recyclerView) {
        this.context = context;
        this.songList = songList;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public SongHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view =
                LayoutInflater.from(context).
                        inflate(R.layout.song, parent, false);

        SongHolder songHolder = new SongHolder(view);
        return songHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull final SongHolder holder, int position) {
        final Song song = songList.get(position);
        holder.TenBaiHatSong.setText(song.getTenBaiHat());
        holder.TenCaSiSong.setText(song.getTenCasi());
        holder.ImgAnhCaSiSong.setImageResource(song.getLinkAnhBaiHat());
        songDAO = new SongDAO(context);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PlayMusicActivity.class);
                intent.putExtra("LinkAnhBaiHat", song.getLinkAnhBaiHat() + "");
                intent.putExtra("LinkBaiHat", song.getLinkBaiHat() + "");
                intent.putExtra("TenBaiHat", song.getTenBaiHat());
                intent.putExtra("Tencasi", song.getTenCasi());
                context.startActivity(intent);

            }
        });
        holder.ImgMyfavoriteSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyFavoriteDAO myFavoriteDAO = new MyFavoriteDAO(context);
                holder.ImgMyfavoriteSong.setImageResource(R.drawable.ic_favorite_pink_24dp);
                String TenBaiHatYT = song.getTenBaiHat();
                String TenCaSiYT = song.getTenCasi();
                int LinkAnhBaiHatYT = song.getLinkAnhBaiHat();
                int LinkBaiHatYT = song.getLinkBaiHat();
                if (myFavoriteDAO.InsertSONGFV(new Favorite("" + TenBaiHatYT, "" + TenCaSiYT, LinkAnhBaiHatYT, LinkBaiHatYT)) < 0) {
                    Toast.makeText(context, "thêm thất bại", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(context, "Đã Lưu vào danh sách yêu thích", Toast.LENGTH_LONG).show();


                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }
}
