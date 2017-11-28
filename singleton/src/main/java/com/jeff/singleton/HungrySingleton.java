package com.jeff.singleton;

/**
 * Created by Jeffery on 17/11/28.
 */

public class HungrySingleton {
    private static HungrySingleton instance = null;

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        if (instance == null)
            instance = new HungrySingleton();
        return instance;
    }
}
