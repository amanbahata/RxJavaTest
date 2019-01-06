package com.aman1.rxjavatest.MVP;

public interface Contract {

    interface View{
        void displayCatImage(String url);
    }

    interface Presenter{
        void getCats();
    }
}
