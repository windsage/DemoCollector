package com.jeff.singleton;

/**
 * Created by Jeffery on 17/11/28.
 */

public class LazySingleton {
    private static final LazySingleton instance = new LazySingleton();

    public static LazySingleton getInstance() {
        return instance;
    }

    private LazySingleton() {
    }
}
