package com.android.starapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.starapp.R;
import com.android.starapp.packa.Collocation;
import com.android.starapp.utils.MyJSON;
import com.android.starapp.utils.OKHTTP;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public class MyActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        OKHTTP.getOkHttp();
        initView();

    }

    private void initView() {


        Request request=new Request.Builder()
                .url("http://api-v2.mall.hichao.com/mix_topics?category=2&ga=/mix_topics&flag=")
                .build();

        Call call=OKHTTP.okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonStr=response.body().string();

                List<Collocation>collocations=MyJSON.getCollocations(jsonStr,false);

                for (int i = 0; i <collocations.size() ; i++) {

                }


            }
        });









    }


}
