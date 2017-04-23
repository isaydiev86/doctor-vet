package com.isaydiev.doctor_vet;

import android.content.Context;

import com.isaydiev.doctor_vet.Models.Item;
import com.isaydiev.doctor_vet.Models.News;
import com.isaydiev.doctor_vet.Models.NewsResponce;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by USER on 08.04.2017.
 */

public class MainPresenter implements MainContract.Presenter{

    private ApiInterface apiInterface;
    private MainContract.View view;
    private Context context;
    private ArrayList<News> newsList;
    private DataBase db;

    public MainPresenter(MainContract.View view, Context context) {
        this.view = view;
        this.context = context;
        apiInterface = ApiClient.getInstance().create(ApiInterface.class);
        db = new DataBase(context);
    }

    @Override
    public void loadNewsList() {
        newsList = db.getNewsList();
        if(!newsList.isEmpty()) {
            view.showNews(newsList);
        }
        Call<NewsResponce> newsResponceCall = apiInterface.getNews();
        newsResponceCall.enqueue(new Callback<NewsResponce>() {
            @Override
            public void onResponse(Call<NewsResponce> call, Response<NewsResponce> response) {
                ArrayList<News> list = response.body().getNewsList();
                db.insertNewsList(list);
                newsList = db.getNewsList();
                view.showNews(newsList);
                //loadNewsList(newsList.get(0));
            }
            @Override
            public void onFailure(Call<NewsResponce> call, Throwable t) {
                view.showError("onFailure: "+t.getMessage());
            }
        });

    }


}
