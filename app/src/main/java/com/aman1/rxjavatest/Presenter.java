package com.aman1.rxjavatest;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Presenter implements Contract.Presenter{

    private static final String TAG = "Presenter";

    MainActivity view;
    ApiClient apiClient;

    public Presenter(MainActivity view, ApiClient apiClient){
        this.view = view;
        this.apiClient = apiClient;
    }


    @Override
    public void getCats() {
        apiClient.getApiClient().getCatPic()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CatsModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i(TAG, "onSubscribe: Getting information........");
                    }

                    @Override
                    public void onNext(CatsModel catsModel) {
                        Log.i(TAG, "onNext: " + catsModel.getFile());
                        view.displayCatImage(catsModel.getFile());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete: File download completed");
                    }
                });
    }
}
