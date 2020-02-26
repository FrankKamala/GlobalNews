package com.example.globalnews.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.globalnews.adapters.Adapter;
import com.example.globalnews.model.Article;
import com.example.globalnews.model.Constants;
import com.example.globalnews.model.NewsSearchResponse;
import com.example.globalnews.R;
import com.example.globalnews.network.NewsApi;
import com.example.globalnews.network.NewsClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{
    //    @BindView(R.id.edOne) EditText mTitle;
//    @BindView(R.id.search) Button mSearch;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.tool) Toolbar mToolbar;
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




//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//
//        MenuInflater inflater =getMenuInflater();
//        inflater.inflate(R.menu.menu_mine,menu);
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        final SearchView searchView = (SearchView) menu.findItem(R.id.find).getActionView();
//        MenuItem searchMenuItem = menu.findItem(R.id.find);
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//        searchView.setQueryHint("Search for");
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//
//
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                //Log.e("onQueryTextChange", "called");
//                return false;
//            }
//        });
//
//        return onCreateOptionsMenu(menu);
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
       inflater.inflate(R.menu.log_out,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.signOut:
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this,Login.class));

                break;
        }
        return super.onOptionsItemSelected(item);
    }


}

