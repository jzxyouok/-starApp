package com.android.starapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.starapp.R;
import com.android.starapp.utils.No_Mesh;

/**
 * Created by Administrator on 2016/7/11 0011.
 *
 * 我的消息
 */
public class News_Fragment extends Fragment {
    private LinearLayout news_layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment, container, false);
        news_layout = (LinearLayout) view.findViewById(R.id.news_layout);

        No_Mesh.uploadView(getContext(), news_layout);

        return view;
    }




}
