package com.android.starapp.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.starapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/2 0002.
 * <p>
 * 综合碎片：
 * 子碎片：咨询碎片的自定义ListView顶部的布局
 * 自定义View
 * <p>
 *       picasso:Android图形缓存库,设置占位图
 * <p>
 * 需要实现回调接口，然后调用setData()方法，传进来图片网址的集合，就调用成功了
 */
public class ViewTop extends RelativeLayout implements View.OnClickListener, ViewPager.OnPageChangeListener {



        private ViewPager viewtop_topviewpager;
        private LinearLayout viewtop_layout;//线性布局(小圆点的父控件)


        private List<ImageView> images;//小圆点集合

        private String [] urls;//ViewPager的图片网址
        private List<String> texts;//文本控件显示的内容
        private PagerAdapter adapter;//适配器


        private int count;//记录图片网址集合的大小


        private Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                int i = msg.what;
                viewtop_topviewpager.setCurrentItem(i, true);
                images.get(i).setEnabled(false);

            }
        };

        public ViewTop(Context context) {
            super(context);
            init();
        }

        public ViewTop(Context context, AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        private void init() {
            //把XML文件加载进来
            View view = LayoutInflater.from(getContext()).inflate(R.layout.viewtop, this, true);
            //找出对应的控件
            viewtop_topviewpager = (ViewPager) view.findViewById(R.id.viewtop_topviewpager);
            viewtop_layout = (LinearLayout) view.findViewById(R.id.viewtop_layout);


            viewtop_topviewpager.addOnPageChangeListener(this);//添加滑动事件


        }


        public void setImage() {//设置底部小圆点的方法

            images = new ArrayList<ImageView>();

            for (int i = 0; i <urls.length; i++) {
                ImageView image = new ImageView(getContext());//创建图片控件

                LinearLayout.LayoutParams params =
                        new LinearLayout.LayoutParams(//设置高和宽
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT);

                params.rightMargin = 5;//设置圆点之间的距离

                image.setLayoutParams(params);//设置到控件里面
                image.setScaleType(ImageView.ScaleType.CENTER);//设置图片在中间
                if (i == 0) {
                    image.setEnabled(false);//第一张图片设置为不可用
                }

                //设置图片控件的背景(资源里面的选择器)
                image.setBackgroundResource(R.drawable.viewtop_selective);

                image.setTag(i);//给控件设置Tag

                image.setOnClickListener(this);//设置点击事件


                viewtop_layout.addView(image);//把创建的控件添加到线性布局里面

                images.add(image);//添加到集合里面

            }
        }


        @Override
        public void onClick(View v) {
            int tag = (int) v.getTag();

            switch (tag) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 5:
                case 6:
                case 7:
                case 8:
                    v.setEnabled(false);
                    viewtop_topviewpager.setCurrentItem(tag, true);
                    break;
            }
        }


        @Override//监听ViewPager的滑动事件(滑动的时候)
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override//选中或者停止滑动的时候
        public void onPageSelected(int position) {

            //改变底部小圆点图片的状态
            for (int i = 0; i < viewtop_layout.getChildCount(); i++) {//遍历线性布局
                ImageView image = (ImageView) viewtop_layout.getChildAt(i);

                if (i == position) {
                    image.setEnabled(false);//选中的那张设置为不可用
                } else {
                    image.setEnabled(true);
                }
            }
        }

        @Override//滑动状态改变的时候
        public void onPageScrollStateChanged(int state) {
        }

        //ViewPager的适配器
        class One_Fragment1_TopViewAdapter extends PagerAdapter {

            private Context context;

            public One_Fragment1_TopViewAdapter(Context context) {
                this.context = context;
            }

            @Override
            public int getCount() {
                return urls.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override//实例图片控件
            public Object instantiateItem(ViewGroup container, final int position) {
                ImageView image = new ImageView(context);

                //image.setImageBitmap(bitmaps.get(position));
                //picasso:Android图形缓存库,设置占位图
                Picasso.with(getContext())//参数1：上下文
                        .load(urls[position])//网址
                        //.placeholder(R.mipmap.bb6)//正在加载时
                        //.error(R.mipmap.bb7)//加载失败时
                        .into(image);//控件

                image.setScaleType(ImageView.ScaleType.FIT_XY);//填充父控件

                image.setOnClickListener(
                        new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getContext(), "点击了" + (position + 1) + "号图片!", Toast.LENGTH_LONG).show();
                            }
                        }
                );

                container.addView(image);//添加进容器
                return image;
            }


            @Override//删除控件的方法
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        }


        public void setData(boolean flag) {//获得传递过来的数据
            if (onListeren != null) {
                urls = onListeren.getURL();//获得图片网址集合

                count = urls.length;
                adapter = new One_Fragment1_TopViewAdapter(getContext());//创建适配器

                setImage();//调用设置线性布局底部小圆点的方法
                viewtop_topviewpager.setAdapter(adapter);//给ViewPager设置适配器

                if(flag){
                play();//子线程的方法(图片进行滚动)
                }

            }
        }

        private void play() {//子线程发送空消息
            new Thread() {
                @Override
                public void run() {
                    int i = 0;

                    while (true) {


                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        handler.sendEmptyMessage(i % count);//发送空信息回去
                        i++;


                    }

                }
            }.start();//开启线程

        }


        private OnListeren onListeren;//接口对象

        public void setOnLienter(OnListeren onListeren) {
            this.onListeren = onListeren;
        }

        //定义一个回调接口
        public interface OnListeren {
            public String[] getURL();//返回位图对象的集合
        }



}
