package com.example.myapplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    static Gson gson = new GsonBuilder().setLenient().create();
    private static Retrofit getRetrofit(){
        String Base_url = "http://192.168.100.193:8000" ;
        OkHttpClient.Builder mmmm = new OkHttpClient.Builder();
        return new Retrofit.Builder().baseUrl(Base_url)
                .client(mmmm.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public static API myApi (){
        return getRetrofit().create(API.class);
    }
}
