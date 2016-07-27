package com.android.starapp.item_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.starapp.R;

/**
 * Created by Administrator on 2016/7/14 0014.
 *
 * 社区的子碎片
 */
public class ItemZI_Fragment extends Fragment{
    private TextView textview;
    private String text;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        text=getArguments().getString("text");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.itemzi_fragment1,container,false);
        textview= (TextView) view.findViewById(R.id.itemzi_fragment_tv);

        textview.setText(text);
        return view;
    }
}
