package com.aman1.rxjavatest.data;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://aws.random.cat/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    CatsApi service = retrofit.create(CatsApi.class);


    public CatsApi getApiClient(){
        return service;
    }
}
