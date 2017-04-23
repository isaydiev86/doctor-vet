package com.isaydiev.doctor_vet.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 08.04.2017.
 */

public class NewsResponce {
    //@SerializedName("pagination")
    //private String pagination;

    @SerializedName("list")
    private ArrayList<News> newsList;

    public ArrayList<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(ArrayList<News> newsList) {
        this.newsList = newsList;
    }

//    class Pagination {
//
//        @SerializedName("total")
//        private int total;
//    }
}
