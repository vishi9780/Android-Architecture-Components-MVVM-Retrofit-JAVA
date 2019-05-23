package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view.api_calls;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.ArticleResponse;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.dummyapi.PResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class AllApiCall {
    private static final String TAG = AllApiCall.class.getSimpleName();
    private ApiRequest apiRequest;

    public AllApiCall() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<ArticleResponse> getMovieArticles(String query, String key) {
        final MutableLiveData<ArticleResponse> data = new MutableLiveData<>();
        apiRequest.getMovieArticles(query, key)
                .enqueue(new Callback<ArticleResponse>() {


                    @Override
                    public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                        Log.d(TAG, "onResponse response:: " + response);


                        if (response.body() != null) {
                            data.setValue(response.body());

                            Log.d(TAG, "articles total result:: " + response.body().getTotalResults());
                            Log.d(TAG, "articles size:: " + response.body().getArticles().size());
                            Log.d(TAG, "articles title pos 0:: " + response.body().getArticles().get(0).getTitle());
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }

    public LiveData<PResponse> getDummyResponse() {
        final MutableLiveData<PResponse> mutableLiveData = new MutableLiveData<>();

        new retrofit2.Retrofit.Builder()
                .baseUrl("https://api.androidhive.info//")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiRequest.class).getDummy().enqueue(new Callback<PResponse>() {
            @Override
            public void onResponse(Call<PResponse> call, Response<PResponse> response) {
                if (response.body() == null)
                    return;
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<PResponse> call, Throwable t) {
                mutableLiveData.setValue(null);
            }
        });
        return mutableLiveData;
    }
}
