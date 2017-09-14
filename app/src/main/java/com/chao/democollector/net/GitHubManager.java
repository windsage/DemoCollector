package com.chao.democollector.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jeffery on 17/9/14.
 */

public class GitHubManager {

    private static final String BASE_URL = "https://api.github.com";
    private GitHubService mGitHubService = null;
    private int time_out = 20;

    public GitHubService getApiService() {
        OkHttpClient client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .readTimeout(time_out, TimeUnit.SECONDS)
                .connectTimeout(time_out, TimeUnit.SECONDS).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        mGitHubService = retrofit.create(GitHubService.class);
        return mGitHubService;
    }
}
