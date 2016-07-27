package com.android.starapp.adaper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.starapp.R;
import com.android.starapp.packa.Country;
import com.android.starapp.view.MyListView;
import com.android.starapp.view.ViewTop;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/13 0013.
 * <p/>
 * <p/>
 * 首页ListView的适配器
 */
public class MyListViewAdapter extends BaseAdapter {
    private String[] strs = {"region_name", "region_brands", "region_pictures", "region_skus"};
    List<Map<String, Map<Integer, Country>>> LISTcountrys;

    Map<Integer, Country> map1;//国家馆名
    Map<Integer, Country> map2;//LOGO
    Map<Integer, Country> map3;//展示的视图(可滑动)
    Map<Integer, Country> map4;//商品展示(价格、图片)

    private String topStr;//顶部馆名图片网址
    private String[] twoUrls;//LOGO小图片地址
    private String[] threeUrls;//展示视图的图片网址
    private String[] mma1_image_URLS;//商品展示区的数据
    private String[] mma1_tv1s;
    private int[] mma1_tv2s;
    private int[] mma1_tv3s;


    public MyListViewAdapter(List<Map<String, Map<Integer, Country>>> LISTcountrys) {
        this.LISTcountrys = LISTcountrys;
    }


    @Override
    public int getCount() {
        return LISTcountrys.size();
    }

    @Override
    public Object getItem(int position) {
        return LISTcountrys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private int iiii;
        ViewHolder holder;
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        initData(position);


        if (view == null) {
            //加载XML布局
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mma, parent, false);
            holder = new ViewHolder();

            //找出对应的控件，线性布局需要动态创建子View
            holder.mma_layout1 = (LinearLayout) view.findViewById(R.id.mma_layout1);
            holder.mma_layout2 = (LinearLayout) view.findViewById(R.id.mma_layout2);
            holder.mma_viewtop = (ViewTop) view.findViewById(R.id.mma_viewtop);
            holder.mma_image = (ImageView) view.findViewById(R.id.mma_image);

            view.setTag(holder);

        }else{
        holder = (ViewHolder) view.getTag();
        }

        //1、适配网络图片(馆名图片)
        holder.mma_image.setTag(topStr);//给控件设置Tag
        MyListView.mma(parent.getContext(), holder.mma_image, topStr);


        params1.setMargins(10,10,10,10);
        //2、在线性布局里面添加图片控件显示logo小图片
        for (int i = 0; i < twoUrls.length; i++) {//LOGO小图片
            iiii=i;
            final ImageView imageView = new ImageView(parent.getContext());
            imageView.setLayoutParams(params1);
            imageView.setPadding(5, 5, 5, 5);
            imageView.setBackgroundResource(R.drawable.mma);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    for (int i = 0; i <holder.mma_layout1.getChildCount(); i++) {
                        imageView.setEnabled(false);
                        ImageView image= (ImageView) holder.mma_layout1.getChildAt(i);
                        if(imageView.equals(image)){
                            image.setEnabled(false);
                        }else{
                            image.setEnabled(true);
                        }

                    }


                }
            });

            if(i==0){
                imageView.setEnabled(false);

            }

            MyListView.mma(parent.getContext(),imageView,twoUrls[i]);

            holder.mma_layout1.addView(imageView);//添加到线性布局里面
        }



        //3、适配滑动图片
        holder.mma_viewtop.setOnLienter(new ViewTop.OnListeren() {
            @Override
            public String[] getURL() {
                return threeUrls;
            }
        });

        holder.mma_viewtop.setData(false);//设置为不进行自动轮播

        //4、添加布局到线性布局里面(商品展示区的内容)
        for (int i = 0; i < mma1_image_URLS.length; i++) {


            //把XML文件转换为View对象
            final View zi_View = LayoutInflater.from(parent.getContext()).inflate(R.layout.mma1,null);
            holder.mma1_image = (ImageView) zi_View.findViewById(R.id.mma1_image);
            holder.mma1_tv1 = (TextView) zi_View.findViewById(R.id.mma1_tv1);
            holder.mma1_tv2 = (TextView) zi_View.findViewById(R.id.mma1_tv2);
            holder.mma1_tv3 = (TextView) zi_View.findViewById(R.id.mma1_tv3);


            MyListView.mma(parent.getContext(),holder.mma1_image,mma1_image_URLS[i]);
            holder.mma1_tv1.setText(mma1_tv1s[i]);
            holder.mma1_tv2.setText(mma1_tv2s[i] + "");
            holder.mma1_tv3.setText(mma1_tv3s[i]+"");

            holder.mma_layout2.addView(zi_View);//把View对象添加到线性布局里面
        }


        return view;
    }



    LinearLayout.LayoutParams params1;

    private void initData(int position) {
        Map<String, Map<Integer, Country>> MAP = LISTcountrys.get(position);

        for (int i = 0; i < MAP.size(); i++) {
            Map<Integer, Country> map = MAP.get(strs[i]);
            if ("region_name".equals(strs[i])) {
                map1 = map;
            } else if ("region_brands".equals(strs[i])) {
                map2 = map;
            } else if ("region_pictures".equals(strs[i])) {
                map3 = map;
            } else if ("region_skus".equals(strs[i])) {
                map4 = map;
            }
        }

        //1、获得顶部的馆名(图片网址)---------------------
        for (int i = 0; i < map1.size(); i++) {
            Country country = map1.get(i);
            topStr = country.getPicUrl();
        }

        //2、获得小logo图片网址-------------------
        twoUrls = new String[map2.size()];
        for (int i = 0; i < map2.size(); i++) {
            Country country = map2.get(i);
            twoUrls[i] = country.getPicUrl();
        }
        params1 = new LinearLayout.LayoutParams(100, ViewGroup.LayoutParams.MATCH_PARENT);


        //3、展示视图集合(可滑动图片网址)-------------------
        threeUrls = new String[map3.size()];
        for (int i = 0; i < map3.size(); i++) {
            Country country = map3.get(i);
            threeUrls[i] = country.getPicUrl();
        }


        //4、商品展示区的各种数据-----------------
        mma1_image_URLS = new String[map4.size()];
        mma1_tv1s = new String[map4.size()];
        mma1_tv2s = new int[map4.size()];
        mma1_tv3s = new int[map4.size()];
        for (int i = 0; i < map4.size(); i++) {
            Country country = map4.get(i);
            mma1_image_URLS[i] = country.getPicUrl();
            mma1_tv1s[i] = country.getTitle();
            mma1_tv2s[i] = country.getPrice();
            mma1_tv3s[i] = country.getOrigin_price();
        }
    }

    static class ViewHolder {
        private ImageView mma_image;//国家的标志
        //布局里面包含LOGO图片      商品展示图片和价格,都是可以拖动
        private LinearLayout mma_layout1, mma_layout2;//两个线性布局(需要动态添加控件)
        private ViewTop mma_viewtop;//可以滑动的图片View

        private ImageView mma1_image;//商品展示里面的图片，文本
        private TextView mma1_tv1, mma1_tv2, mma1_tv3;
    }


}
