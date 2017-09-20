package com.chao.democollector.net;


import com.chao.democollector.bean.User;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Jeffery on 17/9/14.
 */

public interface GitHubService {

    @GET("users/{username}")
    Observable<User> getSingleUser(@Path("username") String username);

    @GET("user")
    Observable<User> getAuthenticatedUsers();
}
