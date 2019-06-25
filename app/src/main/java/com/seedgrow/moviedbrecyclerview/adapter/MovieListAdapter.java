package com.seedgrow.moviedbrecyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.seedgrow.moviedbrecyclerview.model.Movie;

import java.util.List;


public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {
    private Context mContext;
    private List<Movie> dataResults;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView tvTitle;
        public TextView tvPopular;
        public Button btnDetail;
        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
        }
    }

    @NonNull
    @Override
    public MovieListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.MyViewHolder myViewHolder, int position) {
        myViewHolder.tvTitle.setText(dataResults.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return dataResults.size();
    }


}
