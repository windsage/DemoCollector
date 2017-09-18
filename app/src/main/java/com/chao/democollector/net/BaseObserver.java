package com.chao.democollector.net;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * Created by Jeffery on 17/9/15.
 */

public abstract class BaseObserver<T> implements Observer<T> {

    protected abstract void onSuccess(T t);

    protected abstract void onFailure(String msg);

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException) {
            HttpException exception = (HttpException) e;
            String msg = exception.message();
            switch (exception.code()) {
                case 502:
                case 404:
                    msg = "服务器问题";
                    break;
                case 504:
                    msg = "网络不给力";
                    break;
            }
            onFailure(msg);
        } else {
            onFailure(e.getMessage());
        }
        onComplete();
    }

    @Override
    public void onComplete() {

    }
}
