package com.example.globalnews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("top-headlines")
    Call<NewsSearchResponse>getNews(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );


}
