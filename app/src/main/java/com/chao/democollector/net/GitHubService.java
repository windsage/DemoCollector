package com.chao.democollector.net;

import android.database.Observable;

import com.chao.democollector.recyclerview.bean.User;

import retrofit2.http.GET;

/**
 * Created by Jeffery on 17/9/14.
 */

public interface GitHubService {

    @GET("/user")
    Observable<User> getAuthorUser();
}
