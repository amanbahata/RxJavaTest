package com.aman1.rxjavatest.data;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface CatsApi {

    @GET("meow")
    Observable<CatsModel> getCatPic();
}
