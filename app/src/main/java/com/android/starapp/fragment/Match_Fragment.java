package com.android.starapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.starapp.R;
import com.android.starapp.match_fragment.MatchZI_Fragment1;
import com.android.starapp.match_fragment.MatchZI_Fragment2;

/**
 * Created by Administrator on 2016/7/11 0011.
 *
 *  搭配的碎片
 */
public class Match_Fragment extends Fragment implements RadioGroup.OnClickListener {
    private RadioButton match_toolbar_b1, match_toolbar_b2;
    private ImageView match_toolbar_image;
    private FrameLayout match_layout;//帧布局

    private MatchZI_Fragment1 fragment1;//搭配的子碎片对象
    private MatchZI_Fragment2 fragment2;

    private Bundle bundle;
    private Fragment currentFragment;//记录当前显示的碎片对象
    private FragmentTransaction transaction;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.match_fragment, container, false);
        match_layout = (FrameLayout) view.findViewById(R.id.match_layout);
        match_toolbar_b1 = (RadioButton) view.findViewById(R.id.match_toolbar_b1);
        match_toolbar_b2 = (RadioButton) view.findViewById(R.id.match_toolbar_b2);
        match_toolbar_image = (ImageView) view.findViewById(R.id.match_toolbar_image);


        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        match_toolbar_b1.setOnClickListener(this);
        match_toolbar_b2.setOnClickListener(this);
        match_toolbar_image.setOnClickListener(this);

        //获取碎片管理器对象, //开启事物，获得操作碎片的对象
        transaction = getActivity().getSupportFragmentManager().beginTransaction();

        fragment1 = new MatchZI_Fragment1();
        bundle = new Bundle();
        bundle.putString("text", "搭配的碎片");
        fragment1.setArguments(bundle);

        currentFragment = fragment1;//记录当前的碎片
        transaction.add(R.id.match_layout, fragment1);//添加布局和碎片对象
        transaction.commit();//提交事物


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.match_toolbar_b1:
                showFragment(0);
                match_toolbar_b1.setTextColor(getResources().getColor(R.color.main_text_yes));
                match_toolbar_b2.setTextColor(getResources().getColor(R.color.main_text_no));
                break;
            case R.id.match_toolbar_b2:
                showFragment(1);
                match_toolbar_b2.setTextColor(getResources().getColor(R.color.main_text_yes));
                match_toolbar_b1.setTextColor(getResources().getColor(R.color.main_text_no));
                break;
            case R.id.match_toolbar_image:
                break;
        }
    }


    //显示碎片对象，隐藏当前的碎片对象
    private void showFragment(int index) {
        //碎片操作对象，不能定义全局的，负责秒报错
        FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();

        if (index == 0) {//小搭配碎片
            if (fragment1 == null) {
                fragment1 = new MatchZI_Fragment1();
                bundle = new Bundle();
                bundle.putString("text", "搭配的碎片");
                fragment1.setArguments(bundle);
            }
            if (fragment1.isAdded()) {//如果碎片对象存在
                transaction.show(fragment1);//显示该碎片
                transaction.hide(currentFragment);//隐藏当前碎片(前一个)
            } else {//如果碎片对象不存在
                transaction.add(R.id.match_layout, fragment1);//添加碎片
                transaction.hide(currentFragment);//隐藏当前的碎片
            }
            transaction.commit();//提交事件
            currentFragment = fragment1;//记录当前显示的碎片

        }  if (index == 1) {//专题碎片
            if (fragment2 == null) {
                fragment2 = new MatchZI_Fragment2();
                bundle = new Bundle();
                bundle.putString("text", "专题的碎片");
                fragment2.setArguments(bundle);
            }
            if (fragment2.isAdded()) {//如果碎片对象存在
                transaction.show(fragment2);//显示该碎片
                transaction.hide(currentFragment);//隐藏当前碎片(前一个)
            } else {//如果碎片对象不存在
                transaction.add(R.id.match_layout, fragment2);//添加碎片
                transaction.hide(currentFragment);//隐藏当前的碎片
            }
            transaction.commit();//提交事件
            currentFragment = fragment2;//记录当前显示的碎片
        }

    }
}