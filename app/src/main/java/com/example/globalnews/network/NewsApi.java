package com.example.globalnews.network;

import com.example.globalnews.model.Constants;
import com.example.globalnews.model.NewsSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    String Apikey = Constants.API_KEY;
    @GET("top-headlines")
    Call<NewsSearchResponse>getNews(
            @Query("apiKey") String apiKey,
                        @Query("country") String country

            );


}
