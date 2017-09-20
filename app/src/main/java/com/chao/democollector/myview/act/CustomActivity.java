package com.chao.democollector.myview.act;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.chao.democollector.R;
import com.chao.democollector.bean.User;
import com.chao.democollector.net.GitHubManager;
import com.chao.democollector.net.GitHubService;
import com.chao.democollector.req.ReqUser;
import com.chao.democollector.util.ALog;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jeffery on 17/9/11.
 */

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        GitHubService service = new GitHubManager().getApiService();
        ReqUser reqUser = new ReqUser();
        reqUser.setUsername("windsage");
        service.getSingleUser("Blankj").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(User users) {
                        ALog.e(users.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        ALog.e(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        service.getAuthenticatedUsers().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {
                        ALog.e(user.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
