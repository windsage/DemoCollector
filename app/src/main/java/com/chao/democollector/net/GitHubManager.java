package com.chao.democollector.net;

import com.chao.democollector.Config;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jeffery on 17/9/14.
 */

public class GitHubManager {

    private static final String BASE_URL = "https://api.github.com/";
    private static final int time_out = 1000;

    public GitHubService getApiService() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json;charset=utf-8")
                        .addHeader("Accept", "application/vnd.github.v3+json")
                        .addHeader("Authorization", "token " + Config.ACCESS_TOKEN)
                        .build();
                return chain.proceed(request);
            }
        };
        OkHttpClient client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .addInterceptor(interceptor)
                .readTimeout(time_out, TimeUnit.SECONDS)
                .connectTimeout(time_out, TimeUnit.SECONDS).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit.create(GitHubService.class);
    }
}
