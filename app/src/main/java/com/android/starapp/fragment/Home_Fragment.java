package com.android.starapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.starapp.R;
import com.android.starapp.adaper.MyListViewAdapter;
import com.android.starapp.packa.Country;
import com.android.starapp.utils.MyJSON;
import com.android.starapp.utils.OKHTTP;
import com.android.starapp.utils.URLClass;
import com.android.starapp.view.MyListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/7/11 0011.
 * <p/>
 * 首页的碎片
 */
public class Home_Fragment extends Fragment {

    private TextView home_toolbar_tv1, home_toolbar_tv2, home_toolbar_tv;
    private MyListViewAdapter adapter;
    private List<Map<String, Map<Integer, Country>>> LISTcountrys;
    private Map<String, Map<Integer, Country>> map;
    private List<String> strs;

    private MyListView home_listview;
    private String text;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        text = getArguments().getString("text0");

        OKHTTP.getOkHttp();
        LISTcountrys = new ArrayList<>();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        home_toolbar_tv1 = (TextView) view.findViewById(R.id.home_toolbar_tv1);
        home_toolbar_tv2 = (TextView) view.findViewById(R.id.home_toolbar_tv2);
        home_toolbar_tv = (TextView) view.findViewById(R.id.home_toolbar_tv);
        home_listview = (MyListView) view.findViewById(R.id.home_listview);


        return view;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        for (int i = 1; i < 7; i++) {
            Request request = new Request.Builder()
                    .url(URLClass.COUNTRY_URL1 + i + URLClass.COUNTRY_URL2)
                    .build();

            Call call = OKHTTP.okHttpClient.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    map = null;

                    String jsonStr = response.body().string();
                    map = MyJSON.getMAP(jsonStr);

                    if (map != null) {
                        LISTcountrys.add(map);
                    }
                    if (LISTcountrys.size() == 6) {

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter = new MyListViewAdapter(LISTcountrys);
                                home_listview.setAdapter(adapter);
                                adapter.notifyDataSetChanged();
                            }
                        });
                    }


                }
            });
        }
    }


}
