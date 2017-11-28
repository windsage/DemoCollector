package com.jeff.singleton;

/**
 * Created by Jeffery on 17/11/28.
 */

public class DoubleSynchronizedSingleton {
    private static volatile DoubleSynchronizedSingleton instance = null;

    private DoubleSynchronizedSingleton() {
    }

    public static DoubleSynchronizedSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleSynchronizedSingleton.class) {
                if (instance == null)
                    instance = new DoubleSynchronizedSingleton();
            }
        }
        return instance;
    }
}
