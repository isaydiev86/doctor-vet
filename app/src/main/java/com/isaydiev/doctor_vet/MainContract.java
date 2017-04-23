package com.isaydiev.doctor_vet;

import com.isaydiev.doctor_vet.Models.Item;
import com.isaydiev.doctor_vet.Models.News;

import java.util.ArrayList;

/**
 * Created by USER on 08.04.2017.
 */

public interface MainContract {
    interface View{
        void showNews(ArrayList<News> newsList);
        void showError(String message);
    }
    interface Presenter{
        void loadNewsList();
    }
}
