package com.android.starapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.starapp.MainActivity;
import com.android.starapp.R;
import com.android.starapp.activity.Mynews;
import com.android.starapp.utils.No_Mesh;

/**
 * Created by Administrator on 2016/7/11 0011.
 * <p/>
 * 购物车的碎片
 */
public class Cart_Fragment extends Fragment implements View.OnClickListener {
    private TextView tv;
    private String text;
    private LinearLayout cart_layout;
    private MainActivity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
//        activity.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏应用的标题栏

        super.onCreate(savedInstanceState);

        text = getArguments().getString("text3");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.cart_fragment, container, false);
        cart_layout = (LinearLayout) view.findViewById(R.id.cart_layout);

        No_Mesh.uploadView(getContext(),cart_layout);

        initView(view);
        return view;
    }

    private void initView(View view) {
        view.findViewById(R.id.cart_msg).setOnClickListener(this);
        view.findViewById(R.id.cart_edit).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cart_edit:

                break;
            case R.id.cart_msg:
                Intent intnet = new Intent(getActivity(), Mynews.class);
                startActivity(intnet);
                break;
        }


    }
}
