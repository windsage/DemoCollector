package com.jeff.singleton;

/**
 * Created by Jeffery on 17/11/28.
 */

public class InnerSingleton {
    private static class InnerSingletonHolder {
        public static InnerSingleton intance = new InnerSingleton();
    }

    private InnerSingleton() {
    }

    public static InnerSingleton getInstance() {
        return InnerSingletonHolder.intance;
    }
}
