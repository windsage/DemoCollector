package com.chao.democollector.rx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chao.democollector.R;
import com.chao.democollector.bean.Client;
import com.chao.democollector.bean.Server;
import com.chao.democollector.bean.User;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getName();

    private Subscription mSubscription;

    private Button start, request;

    private User user1, user2, user3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);
        start = findViewById(R.id.start);
        request = findViewById(R.id.request);
        startService(new Intent(this,KeepService.class));
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demo1();
//                demo3();
            }
        });
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request(128);
            }
        });
    }

    public void request(long n) {
        mSubscription.request(n); //在外部调用request请求上游
    }

    public void demo3() {
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                Log.e(TAG, "emit 1");
                emitter.onNext(1);
                Log.e(TAG, "emit 2");
                emitter.onNext(2);
                Log.e(TAG, "emit 3");
                emitter.onNext(3);
                Log.e(TAG, "emit complete");
                emitter.onComplete();
            }
        }, BackpressureStrategy.ERROR).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {

                    @Override
                    public void onSubscribe(Subscription s) {
                        Log.e(TAG, "onSubscribe");
                        mSubscription = s;  //把Subscription保存起来
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.w(TAG, "onError: ", t);
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete");
                    }
                });

        Observable<User> userObservable = Observable.create(new ObservableOnSubscribe<User>() {
            @Override
            public void subscribe(ObservableEmitter<User> emitter) throws Exception {
                emitter.onNext(user1);
                emitter.onNext(user2);
                emitter.onNext(user3);
            }
        });

        Observable.just(user1, user2, user3).last(user1);

        Observable.fromArray(user1, user2, user3);

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(new User());
        Observable.fromIterable(userList).reduce(new BiFunction<User, User, User>() {
            @Override
            public User apply(User user, User user2) throws Exception {
                return null;
            }
        });


        Observable.defer(new Callable<ObservableSource<?>>() {
            @Override
            public ObservableSource<?> call() throws Exception {
                return null;
            }
        });


        Observable<Server> serverObservable = userObservable.map(new Function<User, Server>() {
            @Override
            public Server apply(User user) throws Exception {
                return null;
            }
        });

        Observable<Server> serverObservable1 = userObservable.map(new Function<User, Server>() {
            @Override
            public Server apply(User user) throws Exception {
                return null;
            }
        });

        Observable<Client> clientObservable = Observable.zip(userObservable, serverObservable, new BiFunction<User, Server, Client>() {
            @Override
            public Client apply(User user, Server server) throws Exception {
                return null;
            }
        });

        Observable.interval(3, 2, TimeUnit.SECONDS);

        Observable.concat(serverObservable, serverObservable1, new ObservableSource<Server>() {
            @Override
            public void subscribe(Observer<? super Server> observer) {

            }
        });

        Observable.merge(serverObservable, serverObservable1, new ObservableSource<Server>() {
            @Override
            public void subscribe(Observer<? super Server> observer) {

            }
        });

    }


    private void demo1() {
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
                Log.e(TAG, "emitter: " + 1);
                e.onNext(1);
                Log.e(TAG, "emitter: " + 2);
                e.onNext(2);
                Log.e(TAG, "emitter: " + 3);
                e.onNext(3);
                Log.e(TAG, "emitter complete");
                e.onComplete();
            }
        }, BackpressureStrategy.ERROR).subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        mSubscription = s;
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG, "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e(TAG, "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete");
                    }
                });
    }


}
