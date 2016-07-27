package com.android.starapp.activity;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.android.starapp.R;
import com.android.starapp.fragment.News_Fragment;

/**
 * 我的消息页面
 *
 * Created by My on 2016/7/12 0012.
 */
public class Mynews extends AppCompatActivity  {
    private String[] tabs = {"客服", "回复", "评论", "通知"};
    private TabLayout mynews_tablayout;
    private ViewPager mynews_viewpager;
    private ImageView tv_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏应用的标题栏
        setContentView(R.layout.mynews);

        //设置适配器
        initView();


    }

    private void initView() {
        mynews_tablayout = (TabLayout) findViewById(R.id.mynews_tablayout);
        mynews_viewpager = (ViewPager) findViewById(R.id.mynews_viewpager);
        tv_return = (ImageView) findViewById(R.id.mynews_return);
        tv_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();//调用返回的方法
            }
        });

        //设置适配器
        mynews_viewpager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mynews_tablayout.setupWithViewPager(mynews_viewpager);//设置关联ViewPager



    }


    //ViewPager的碎片专用适配器
    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return tabs.length;
        }

        @Override
        public Fragment getItem(int position) {
            //创建碎片对象
            News_Fragment fragment = new News_Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("text", tabs[position] + "的碎片");
            fragment.setArguments(bundle);

            return fragment;
        }

        @Override//设置导航条的名称
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }
    }


}