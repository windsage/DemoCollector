package com.chao.democollector.util;

import android.util.Base64;

/**
 * Created by Jeffery on 2017/9/14.
 */

public class Utils {

    public static String base64Encode(String str){
        return Base64.encodeToString(str.getBytes(), Base64.DEFAULT);
    }

}

