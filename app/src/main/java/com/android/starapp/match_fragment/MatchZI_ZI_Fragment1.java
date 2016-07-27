package com.android.starapp.match_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.starapp.R;
import com.android.starapp.adaper.MatchZI_ZI_Adapter;
import com.android.starapp.packa.Collocation;
import com.android.starapp.utils.MyJSON;
import com.android.starapp.utils.OKHTTP;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/7/11 0011.
 *
 *
 *  小搭配碎片的子碎片
 *
 *
 */
public class MatchZI_ZI_Fragment1 extends Fragment{
    private ListView match_zi_zi_fragment1_listview;
    List<Collocation> collocations;//数据集合
    private String url;
    private MatchZI_ZI_Adapter adapter;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        url=getArguments().getString("url");
        OKHTTP.getOkHttp();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.matchzi_zi_fragment1,container,false);
        match_zi_zi_fragment1_listview= (ListView) view.findViewById(R.id.match_zi_zi_fragment1_listview);


        setListView();

        //没有网络时显示动画
        //No_Mesh.startAnmation(getContext(),matchzi_zi_fragment1_layout);

        return view;
    }

    private void setListView() {

        Request request=new Request.Builder()
                .url(url)
                .build();

        Call call=OKHTTP.okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonStr=response.body().string();
                //下载小搭配的数据
                collocations=MyJSON.getCollocations(jsonStr,true);

                if(collocations!=null && collocations.size()!=0){

                    getActivity().runOnUiThread(new Runnable() {//返回主线程，更新UI
                        @Override
                        public void run() {
                            adapter=new MatchZI_ZI_Adapter(collocations);
                            match_zi_zi_fragment1_listview.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                        }
                    });
                }

            }
        });
    }
}
