package com.isaydiev.doctor_vet;

import com.google.gson.JsonElement;
import com.isaydiev.doctor_vet.Models.NewsResponce;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by USER on 08.04.2017.
 */

public interface ApiInterface {
    @GET("news")
    Call<NewsResponce> getNews();

    @GET("service")
    Call<JsonElement> getServices();

    @GET("service")
    Call<String> getServicesString();
}
