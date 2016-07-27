package com.android.starapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.starapp.R;
import com.android.starapp.activity.MyLogin;
import com.android.starapp.activity.My_Feedback;
import com.android.starapp.activity.Mynews;
import com.android.starapp.activity.Setting;
import com.android.starapp.utils.AppUtils;

/**
 * Created by Administrator on 2016/7/11 0011.
 * 我的碎片
 */
public class Like_Fragment extends Fragment implements View.OnClickListener {
    private TextView tv_feedback;
    private ImageView like_toolbar_image1, like_toolbar_image2, like_toolbar_image3;
    private String text;
    private boolean isLogin = true;//是否登陆

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        text = getArguments().getString("text4");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.like_fragment, container, false);


        initView(view);

        return view;
    }

    private void initView(View view) {

        tv_feedback = (TextView) view.findViewById(R.id.my_feedback);
        tv_feedback.setOnClickListener(this);

        like_toolbar_image1 = (ImageView) view.findViewById(R.id.like_toolbar_image1);
        like_toolbar_image2 = (ImageView) view.findViewById(R.id.like_toolbar_image2);
        like_toolbar_image3 = (ImageView) view.findViewById(R.id.like_toolbar_image3);
        like_toolbar_image3.setOnClickListener(this);
        like_toolbar_image1.setOnClickListener(this);

        view.findViewById(R.id.my_coll).setOnClickListener(this);
        view.findViewById(R.id.my_collect).setOnClickListener(this);
        view.findViewById(R.id.my_follow).setOnClickListener(this);
        view.findViewById(R.id.my_follow2).setOnClickListener(this);
        view.findViewById(R.id.my_follow3).setOnClickListener(this);
        view.findViewById(R.id.my_login).setOnClickListener(this);
        view.findViewById(R.id.my_note).setOnClickListener(this);
        view.findViewById(R.id.my_pay).setOnClickListener(this);
        view.findViewById(R.id.my_address).setOnClickListener(this);
        view.findViewById(R.id.my_red).setOnClickListener(this);
        view.findViewById(R.id.my_send).setOnClickListener(this);
        view.findViewById(R.id.my_coupon).setOnClickListener(this);
        view.findViewById(R.id.my_all).setOnClickListener(this);
        view.findViewById(R.id.my_pj).setOnClickListener(this);
        view.findViewById(R.id.my_return1).setOnClickListener(this);
        view.findViewById(R.id.my_return2).setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        AppUtils.showShort(getContext(), "亲、你还没有登录哦！！！");
        if (isLogin) {
            Intent intent = new Intent();
            switch (v.getId()) {
                case R.id.my_feedback:
                    intent.setClass(getActivity(), My_Feedback.class);//反馈帮助
                    break;
                case R.id.like_toolbar_image3:
                    intent.setClass(getActivity(), Mynews.class);//我的消息
                    break;
                case R.id.like_toolbar_image1:
                    intent.setClass(getActivity(), Setting.class);//我的消息
                    break;
                case R.id.my_all:
                    intent.setClass(getActivity(), MyLogin.class);
                    break;
                case R.id.my_coll:
                    intent.setClass(getActivity(), MyLogin.class);
                    break;
                case R.id.my_collect:
                    intent.setClass(getActivity(), MyLogin.class);
                    break;
                case R.id.my_follow:
                    intent.setClass(getActivity(), MyLogin.class);
                    break;
                case R.id.my_follow2:
                    intent.setClass(getActivity(), MyLogin.class);
                    break;
                case R.id.my_follow3:
                    intent.setClass(getActivity(), MyLogin.class);
                    break;
                case R.id.my_login:
                    intent.setClass(getActivity(), MyLogin.class);
                    break;
                case R.id.my_note:
                    intent.setClass(getActivity(), MyLogin.class);
                    break;
                case R.id.my_pay:
                    intent.setClass(getActivity(), MyLogin.class);
                    break;
                case R.id.my_send:
                    intent.setClass(getActivity(), MyLogin.class);
                    break;
                case R.id.my_coupon:
                    intent.setClass(getActivity(), MyLogin.class);
                    break;
                case R.id.my_pj:
                    intent.setClass(getActivity(), MyLogin.class);
                    break;
                case R.id.my_address:
                    intent.setClass(getActivity(), MyLogin.class);
                    break;
                case R.id.my_return1:
                    intent.setClass(getActivity(), MyLogin.class);
                    break;
                case R.id.my_return2:
                    intent.setClass(getActivity(), MyLogin.class);
                    break;
                case R.id.my_red:
                    intent.setClass(getActivity(), MyLogin.class);
                    break;


            }

            startActivity(intent);
        } else {
            AppUtils.showShort(getContext(), "系统正在升级，请稍后访问！！！");
            Intent intent = new Intent();
            switch (v.getId()) {
                case R.id.my_feedback:
                    intent.setClass(getActivity(), My_Feedback.class);//反馈帮助
                    break;
                case R.id.like_toolbar_image3:
                    intent.setClass(getActivity(), Mynews.class);//我的消息
                    break;
                case R.id.like_toolbar_image1:
                    intent.setClass(getActivity(), Setting.class);//我的消息
                    break;
            }


        }
    }

}
