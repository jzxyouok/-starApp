package com.android.starapp.match_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.starapp.R;
import com.android.starapp.packa.Collocation;
import com.android.starapp.utils.URLClass;

import java.util.List;

/**
 * Created by Administrator on 2016/7/11 0011.
 *
 *
 *  搭配里面的子碎片(小搭配碎片)
 *
 *      ViewPager嵌套多个碎片
 */
public class MatchZI_Fragment1 extends Fragment{
    private TabLayout matchzi1_tablayout;
    private ViewPager matchzi1_viewpager;

    List<Collocation> collocations;//创建子碎片传递的数据集合


    private String[] tabs = {"热门","欧美","日韩","本土","型男","复古","最新","OL","清新","混搭","甜美","街头","闺蜜"};


    private String text;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        text=getArguments().getString("text");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.matchzi_fragment1,container,false);

        matchzi1_tablayout= (TabLayout) view.findViewById(R.id.matchzi1_tablayout);
        matchzi1_viewpager= (ViewPager) view.findViewById(R.id.matchzi1_viewpager);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //设置适配器
        matchzi1_viewpager.setAdapter(new MyAdapter(getChildFragmentManager()));
        matchzi1_tablayout.setupWithViewPager(matchzi1_viewpager);//设置关联ViewPager



    }

    //ViewPager的碎片专用适配器
    class MyAdapter extends FragmentPagerAdapter{

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
            MatchZI_ZI_Fragment1 fragment=new MatchZI_ZI_Fragment1();
            Bundle bundle=new Bundle();
            bundle.putString("url",URLClass.COLLOCATION_URL1+tabs[position]+ URLClass.COLLOCATION_URL2);
            fragment.setArguments(bundle);

            return fragment;
        }

        @Override//设置导航条的名称
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }
    }



}
