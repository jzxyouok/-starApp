package com.android.starapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.starapp.R;
import com.android.starapp.activity.MyShare;
import com.android.starapp.activity.Mynews;

/**
 * Created by Administrator on 2016/7/11 0011.
 * <p/>
 * 社区的碎片
 */
public class Item_Fragment extends Fragment implements View.OnClickListener {
    private TextView tv;
    private String text;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        text = getArguments().getString("text2");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_fragment, container, false);
        tv = (TextView) view.findViewById(R.id.item_tv);
        tv.setText(text);

        initView(view);

        return view;
    }

    private void initView(View view) {
        view.findViewById(R.id.item_msg).setOnClickListener(this);
        view.findViewById(R.id.item_camera).setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.item_msg:
                intent.setClass(getActivity(), Mynews.class);
                break;
            case R.id.item_camera:
                intent.setClass(getActivity(), MyShare.class);
                break;
        }
        startActivity(intent);


    }
}
