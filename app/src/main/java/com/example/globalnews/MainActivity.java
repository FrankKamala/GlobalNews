package com.example.globalnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
//    @BindView(R.id.edOne) EditText mTitle;
//    @BindView(R.id.search) Button mSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//        mSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String titLe = mTitle.getText().toString();
//                Intent intent = new Intent(MainActivity.this, News.class);
//                intent.putExtra("Title",titLe);
//
//                startActivity(intent);
//
//
//            }
//        });
    }
}
