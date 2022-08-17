package com.example.myapplication;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface API {
    @Headers({"Authorization:Bearer 11|hviIecW6YgligdqFL4Lalp4AUk6G6JKV06Oigu44"})
    @POST("/api/patient/slides")
    Call<ResponseNewSlide> sendRequest(@Body body body);
}
