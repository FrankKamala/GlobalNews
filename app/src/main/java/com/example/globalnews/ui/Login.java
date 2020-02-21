package com.example.globalnews.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.example.globalnews.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Animation button_animate;

    @BindView(R.id.username) EditText mEd1;
    @BindView(R.id.password) EditText mEd2;



    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button_animate = AnimationUtils.loadAnimation(this, R.anim.btn_anim);

        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();


        findViewById(R.id.create).setOnClickListener(this);
        findViewById(R.id.button).setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.create:

                finish();

                startActivity(new Intent(this, CreateAccount.class));  //switch between activity
                break;

            case R.id.button:
                v.setAnimation(button_animate);
                userLogin();
                break;
        }
    }

    private void userLogin() {
        String email = mEd1.getText().toString().trim();
        String password = mEd2.getText().toString().trim();
        if (email.isEmpty()) {
            mEd1.setError("Email is required"); //mail validation
            mEd1.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEd1.setError("Please enter a valid email");
            mEd1.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            mEd2.setError("Password is required"); //password validation
            mEd2.requestFocus();
            return;
        }


        if (password.length() < 6) {
            mEd2.setError("Minimum length of password should be 6"); //password length
            mEd2.requestFocus();
            return;
        }



        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if(task.isSuccessful()){
                    finish();
                    Intent intent=new Intent(Login.this,MainActivity.class);
                   // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
