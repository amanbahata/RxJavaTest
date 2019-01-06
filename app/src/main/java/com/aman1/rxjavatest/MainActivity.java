package com.aman1.rxjavatest;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import retrofit2.http.Url;

public class MainActivity extends AppCompatActivity implements Contract.View {
    Presenter presenter;
        Button button;
        ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this, new ApiClient());

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (presenter != null) {
                    presenter.getCats();
                }
            }
        });

        imageView = findViewById(R.id.imageView);

    }

    @Override
    public void displayCatImage(String url) {
        if (imageView != null){
            Picasso.get().load(url).into(imageView);
        }
    }
}
