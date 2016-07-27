package com.android.starapp.utils;

import com.android.starapp.packa.Country;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/7/13 0013.
 *
 *  返回数据的类，回调接口
 */
public class Data {
    private List<Country> countries;

    public  void getDtata(String url) {//获得国家馆的对象集合(参数为网址)
        OKHTTP.getOkHttp();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = OKHTTP.okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String json_Str = response.body().string();


            }
        });
    }

    private OnHttpLienter onHttpLienter;//接口对象

    public void setOnHttpLienter(OnHttpLienter onHttpLienter) {
        this.onHttpLienter = onHttpLienter;
    }

    public interface OnHttpLienter{//回调接口
        void getCountrys(List<Country> countries);
    }


}
