package com.example.globalnews.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.globalnews.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
              //  startActivity(new Intent(Splash.this,MainActivity.class)); //starts main Activity
                startActivity(new Intent(Splash.this,Login.class));
                finish();

            }
        },4000);
    }
}
