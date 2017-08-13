package com.example.myapplication.util;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by 刘文艺 on 2017/8/9.
 */

public class XUtilsHttp {
    public static void getHttp(String path, Callback.CommonCallback commonCallback){
        RequestParams params = new RequestParams(path);
        x.http().get(params, commonCallback);
    }
}
