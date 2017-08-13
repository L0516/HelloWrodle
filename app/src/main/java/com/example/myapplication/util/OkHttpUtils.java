package com.example.myapplication.util;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by 刘文艺 on 2017/8/9.
 */

public class OkHttpUtils {
    public static void sendOkHttpRequest(String path, Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(path)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
