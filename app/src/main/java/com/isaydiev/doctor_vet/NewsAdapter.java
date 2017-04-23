package com.isaydiev.doctor_vet;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.isaydiev.doctor_vet.Models.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by USER on 08.04.2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private ArrayList<News> newsList;
    private Context context;

    public NewsAdapter(ArrayList<News> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final News news = newsList.get(position);
        Picasso.with(context).load(news.getPic().getPreview().getSrc())
                .into(holder.newsImage);
        holder.newsTitle.setText(news.getTitle());
        holder.newsDate.setText(news.getDate());
        holder.newsAnnounce.setText(news.getAnnounce());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("url", news.getUrl());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView newsImage;
        TextView newsDate, newsTitle, newsAnnounce;
        public ViewHolder(View itemView) {
            super(itemView);
            newsImage = (ImageView)itemView.findViewById(R.id.news_image);
            newsDate = (TextView)itemView.findViewById(R.id.news_date);
            newsTitle = (TextView)itemView.findViewById(R.id.news_title);
            newsAnnounce = (TextView)itemView.findViewById(R.id.news_announce);

        }
    }
}
