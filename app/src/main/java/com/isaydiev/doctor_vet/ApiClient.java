package com.isaydiev.doctor_vet;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by USER on 08.04.2017.
 */

public class ApiClient {
    private static Retrofit retrofit = null;
    public static Retrofit getInstance(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://doctor-vet.uz/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static Retrofit getInstance2(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://doctor-vet.uz/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
