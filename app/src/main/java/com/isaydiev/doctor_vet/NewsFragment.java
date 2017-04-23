package com.isaydiev.doctor_vet;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isaydiev.doctor_vet.Models.News;

import java.util.ArrayList;


public class NewsFragment extends Fragment implements MainContract.View{

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycles_news);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MainPresenter presenter = new MainPresenter(this, getContext());
        presenter.loadNewsList();
        return  view;
    }

    @Override
    public void showNews(ArrayList<News> newsList) {
        NewsAdapter newsAdapter = new NewsAdapter(newsList, getContext());
        recyclerView.setAdapter(newsAdapter);
    }

    @Override
    public void showError(String message) {
        Log.e("Error", message);
    }
}
