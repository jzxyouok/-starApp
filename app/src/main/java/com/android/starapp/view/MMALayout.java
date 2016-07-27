package com.android.starapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.starapp.R;
import com.android.starapp.packa.Country;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/13 0013.
 *
 * 自定义的View
 *      加载首页ListView里面的全球馆的布局
 */
class MMALayout extends LinearLayout {
    String[] strs = {"region_name", "region_brands", "region_pictures", "region_skus"};

    private static Map<String, Map<Integer, Country>> MAPcountrys;//数据集合(单个展示馆)

    Map<Integer, Country> map1;//国家馆名
    Map<Integer, Country> map2;//LOGO
    Map<Integer, Country> map3;//展示的视图(可滑动)
    Map<Integer, Country> map4;//商品展示(价格、图片)

    private String topStr;//顶部馆名图片网址
    private String[] twoUrls;//LOGO小图片地址
    private String[] threeUrls;//展示视图的图片网址
    private String[] mma1_image_URLS;
    private String[] mma1_tv1s;
    private int[] mma1_tv2s;
    private int[] mma1_tv3s;


    private ImageView mma_image;//国家的标志
    //布局里面包含LOGO图片      商品展示图片和价格,都是可以拖动
    private LinearLayout mma_layout1, mma_layout2;//两个线性布局(需要动态添加控件)
    private ViewTop mma_viewtop;//可以滑动的图片View


    private ImageView mma1_image;//商品展示里面的图片，文本
    private TextView mma1_tv1, mma1_tv2, mma1_tv3;


    public static MMALayout getMMALayout(Context context, Map<String, Map<Integer, Country>> countrys) {
        MAPcountrys = countrys;
        return new MMALayout(context);
    }


    public MMALayout(Context context) {
        super(context);
        init();
    }

    public MMALayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {//加载XML文件
        View view = LayoutInflater.from(getContext()).inflate(R.layout.mma, this, true);
        //找出对应的控件，线性布局需要动态创建子View
        mma_layout1 = (LinearLayout) view.findViewById(R.id.mma_layout1);
        mma_layout2 = (LinearLayout) view.findViewById(R.id.mma_layout2);
        mma_viewtop = (ViewTop) view.findViewById(R.id.mma_viewtop);
        mma_image = (ImageView) view.findViewById(R.id.mma_image);


        for (int i = 0; i < strs.length; i++) {//解析数据
            Map<Integer, Country> map = MAPcountrys.get(strs[i]);
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


        //1、---------------------
        for (int i = 0; i < map1.size(); i++) {
            Country country = map1.get(i);
            topStr = country.getPicUrl();
        }

        MyListView.mma(getContext(), mma_image, topStr);//适配网络图片


        //2、-------------------
        twoUrls = new String[map2.size()];
        for (int i = 0; i < map2.size(); i++) {
            Country country = map2.get(i);
            twoUrls[i] = country.getPicUrl();
        }
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        100,
                        ViewGroup.LayoutParams.MATCH_PARENT
                );

        //动态添加LOGO小图片
        for (int i = 0; i < twoUrls.length; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(params);
            MyListView.mma(getContext(), imageView, twoUrls[i]);//加载网络图片
            mma_layout1.addView(imageView);
        }


        //3、-------------------
        //展示视图集合
        threeUrls = new String[map3.size()];
        for (int i = 0; i < map3.size(); i++) {
            Country country = map3.get(i);
            threeUrls[i] = country.getPicUrl();
        }

        //适配滑动图片
        mma_viewtop.setOnLienter(new ViewTop.OnListeren() {
            @Override
            public String[] getURL() {
                return threeUrls;
            }
        });

        mma_viewtop.setData(false);


        //4、-----------------
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

        for (int i = 0; i < mma1_image_URLS.length; i++) {
            //把XML文件转换为View对象
            View zi_View = LayoutInflater.from(getContext()).inflate(R.layout.mma1, mma_layout2, false);
            mma1_image = (ImageView) zi_View.findViewById(R.id.mma1_image);
            mma1_tv1 = (TextView) zi_View.findViewById(R.id.mma1_tv1);
            mma1_tv2 = (TextView) zi_View.findViewById(R.id.mma1_tv2);
            mma1_tv3 = (TextView) zi_View.findViewById(R.id.mma1_tv3);

            MyListView.mma(getContext(), mma1_image, mma1_image_URLS[i]);
            mma1_tv1.setText(mma1_tv1s[i]);
            mma1_tv2.setText(mma1_tv2s[i] + "");
            mma1_tv3.setText(mma1_tv3s[i] + "");

            mma_layout2.addView(view);//把View对象添加到线性布局里面
        }


    }
}