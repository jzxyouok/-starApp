package com.android.starapp.utils;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2016/7/12 0012.
 * <p/>
 * 网络请求的单例模式
 */
public class OKHTTP {
    public static OKHTTP okhttp;
    public static OkHttpClient okHttpClient;

    private OKHTTP() {
        okHttpClient = new OkHttpClient();
    }

    public static OKHTTP getOkHttp() {
        if (okhttp == null) {
            synchronized (OKHTTP.class) {
                if (okhttp == null) {
                    okhttp = new OKHTTP();
                }
            }
        }
        return okhttp;
    }









}