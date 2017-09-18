package com.chao.democollector.net;


import com.chao.democollector.recyclerview.bean.User;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Jeffery on 17/9/14.
 */

public interface GitHubService {

    @GET("users/windsage")
    Observable<User> getAuthorUser();
}
