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

public class MainActivity extends AppCompatActivity implements Contract.View {

    private static final String TAG = "MainActivity";

    private Contract.Presenter presenter;
    private Button button;
    private ImageView imageView;
    private TextView textView;

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
    }
}
