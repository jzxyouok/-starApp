package com.android.starapp.match_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.starapp.R;
import com.android.starapp.adaper.MatchZI_Fragment_Adapter;
import com.android.starapp.packa.Collocation;
import com.android.starapp.utils.MyJSON;
import com.android.starapp.utils.OKHTTP;
import com.android.starapp.utils.URLClass;

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
 *  搭配里面的子碎片(专题)
 */
public class MatchZI_Fragment2 extends Fragment{
    List<Collocation> collocations;
    private MatchZI_Fragment_Adapter adapter;
    private ListView matchzi2_listview;
    private String text;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        text=getArguments().getString("text");
        OKHTTP.getOkHttp();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.matchzi_fragment2,container,false);
        matchzi2_listview= (ListView) view.findViewById(R.id.matchzi2_listview);


        setListView();
        //加载布局(加载失败的布局文件)
        //No_Mesh.uploadView(getContext(),matchzi_fragment2_layout);
        return view;
    }

    private void setListView() {

        Request request=new Request.Builder()
                .url(URLClass.COLLOCATION_URL3)
                .build();

        Call call=OKHTTP.okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonStr=response.body().string();
                collocations= MyJSON.getCollocations(jsonStr,false);//加载专题里面的数据
                if(collocations!=null && collocations.size()!=0){
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {//返回主线程，设置适配器
                            adapter=new MatchZI_Fragment_Adapter(collocations);
                            matchzi2_listview.setAdapter(adapter);
                            adapter.notifyDataSetChanged();

                        }
                    });

                }
            }
        });
    }
}
