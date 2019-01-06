package com.aman1.rxjavatest.MVP;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.aman1.rxjavatest.data.ApiClient;
import com.aman1.rxjavatest.R;
import com.squareup.picasso.Picasso;

import io.reactivex.internal.operators.observable.BlockingObservableNext;

public class MainActivity extends AppCompatActivity implements Contract.View, View.OnClickListener{

    private static final String TAG = "MainActivity";

    private Contract.Presenter presenter;
    private Button next_button;
    private ImageView imageView;
    private TextView textView;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this, new ApiClient());

        startButton = findViewById(R.id.start_button);
        startButton.setOnClickListener(this);

        next_button = findViewById(R.id.next_button);
        next_button.setOnClickListener(this);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
    }

    @Override
    public void displayCatImage(String url) {
        if (imageView != null){
            Picasso.get().load(url).into(imageView);
            if (textView != null){
                textView.setText(url);
            }
        }
        if (next_button != null && next_button.getVisibility() == View.INVISIBLE){
            next_button.setVisibility(View.VISIBLE);
            startButton.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        if (presenter != null) {
            presenter.getCats();
        }
    }
}
