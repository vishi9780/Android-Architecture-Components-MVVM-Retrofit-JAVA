package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.dummyapi.PResponse;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view.api_calls.AllApiCall;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.ArticleResponse;

public class ArticleViewModel extends AndroidViewModel {

    private AllApiCall articleRepository;
    private LiveData<ArticleResponse> articleResponseLiveData;
    private LiveData<PResponse> articlePResponseLiveData;

    public ArticleViewModel(@NonNull Application application) {
        super(application);

        articleRepository = new AllApiCall();
        this.articleResponseLiveData = articleRepository.getMovieArticles("movies", "84a7decf3110498ea372bd16dd0601e8");
        this.articlePResponseLiveData = articleRepository.getDummyResponse();

    }

    public LiveData<ArticleResponse> getArticleResponseLiveData() {
        return articleResponseLiveData;
    }
    public LiveData<PResponse> getDummyResponse() {
        return articlePResponseLiveData;
    }
}
