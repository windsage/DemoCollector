package com.chao.democollector;

import android.app.Application;

import com.chao.democollector.util.ALog;

/**
 * Created by Jeffery on 17/9/20.
 */

public class Jpp extends Application {
    public static ALog.Builder builder;

    @Override
    public void onCreate() {
        super.onCreate();
        builder = new ALog.Builder(this)
                .setLogSwitch(BuildConfig.DEBUG)// 设置log总开关，默认开
                .setGlobalTag("Jeff")// 设置log全局标签，默认为空
                .setLogHeadSwitch(true)// 设置log头部是否显示，默认显示
                .setLog2FileSwitch(false)// 打印log时是否存到文件的开关，默认关
                .setBorderSwitch(true)// 输出日志是否带边框开关，默认开
                .setLogFilter(ALog.E);// log过滤器，和logcat过滤器同理，默认Verbose
    }
}
