package com.example.globalnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class News extends AppCompatActivity {
    @BindView(R.id.textView) TextView mOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ButterKnife.bind(this);
        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        mOutput.setText("This articles were posted By:"+title+".");
    }
}
