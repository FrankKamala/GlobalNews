package com.example.globalnews.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.globalnews.adapters.Adapter;
import com.example.globalnews.model.Article;
import com.example.globalnews.model.Constants;
import com.example.globalnews.model.NewsSearchResponse;
import com.example.globalnews.R;
import com.example.globalnews.network.NewsApi;
import com.example.globalnews.network.NewsClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    //    @BindView(R.id.edOne) EditText mTitle;
//    @BindView(R.id.search) Button mSearch;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
   // @BindView(R.id.img) ImageView mPicha;
    private Adapter mAdapter;

    public List<Article> articles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        String country = intent.getStringExtra("us");

        NewsApi client = NewsClient.getClient();
        Call<NewsSearchResponse> call = client.getNews(Constants.API_KEY, "us");
        Log.v("Key", String.valueOf(call.request().url()));
        call.enqueue(new Callback<NewsSearchResponse>() {
            @Override
            public void onResponse(Call<NewsSearchResponse> call, Response<NewsSearchResponse> response) {


                if (response.isSuccessful() && response.body().getArticles() != null) {
                    articles = response.body().getArticles();
                   mAdapter = new Adapter(articles,MainActivity.this);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(MainActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);

                    showArticles();
                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<NewsSearchResponse> call, Throwable t) {

                showFailureMessage();
            }

        });
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showArticles() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }


}

