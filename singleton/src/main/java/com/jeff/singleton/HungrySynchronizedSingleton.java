package com.jeff.singleton;

/**
 * Created by Jeffery on 17/11/28.
 */

public class HungrySynchronizedSingleton {

    private static HungrySynchronizedSingleton instance = null;

    private HungrySynchronizedSingleton() {
    }

    //method one
    public static HungrySynchronizedSingleton getInstance() {
        synchronized (HungrySynchronizedSingleton.class) {
            if (instance == null)
                instance = new HungrySynchronizedSingleton();
        }
        return instance;
    }

/**
 *
 * method two
 public static synchronized HungrySynchronizedSingleton getInstance() {
 if (instance == null)
 instance = new HungrySynchronizedSingleton();
 return instance;
 }
 **/
}
