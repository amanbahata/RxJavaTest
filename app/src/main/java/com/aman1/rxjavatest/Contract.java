package com.aman1.rxjavatest;

import android.net.Uri;


public interface Contract {

    interface View{
        void displayCatImage(String url);
    }

    interface Presenter{
        void getCats();
    }
}
