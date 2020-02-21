package com.example.globalnews.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.globalnews.R;



public class Splash extends AppCompatActivity {

    Animation topAnim;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        topAnim = AnimationUtils.loadAnimation(this, R.anim.up_anim);


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
