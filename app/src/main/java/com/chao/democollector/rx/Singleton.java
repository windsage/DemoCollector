package com.chao.democollector.rx;

/**
 * Created by Jeffery on 17/11/21.
 */

public class Singleton{
    private static class SingletonHolder{
        public static Singleton instance = new Singleton();
    }

    private Singleton(){}

    public static Singleton getInstance(){
        return SingletonHolder.instance;
    }

}