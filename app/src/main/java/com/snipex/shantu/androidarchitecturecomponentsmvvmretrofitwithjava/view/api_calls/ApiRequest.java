package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view.api_calls;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.ArticleResponse;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.dummyapi.PResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("v2/everything/")
    Call<ArticleResponse> getMovieArticles(@Query("q") String query, @Query("apikey") String apiKey);
//    https://jsonplaceholder.typicode.com/posts?userId=1
    @GET("contacts")
    Call<PResponse> getDummy();
}
