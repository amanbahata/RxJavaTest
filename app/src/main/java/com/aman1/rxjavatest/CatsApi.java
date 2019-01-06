package com.aman1.rxjavatest;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface CatsApi {

    @GET("meow")
    Observable<CatsModel> getCatPic();
}
