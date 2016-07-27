package com.android.starapp.utils;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.starapp.R;

/**
 * Created by Administrator on 2016/7/11 0011.
 *
 *
 *  加载/删除动画(布局)的工具类
 */
public class No_Mesh {

    //开启奋力加载动画的方法(参数1：上下文     参数2:布局)
    public static AnimationDrawable startAnmation(Context context, ViewGroup layout) {
        View view = LayoutInflater.from(context).inflate(R.layout.no_mesh, layout, false);
        layout.addView(view);
        TextView textView = (TextView) view.findViewById(R.id.no_mesh_tv);
        ImageView imageView = (ImageView) view.findViewById(R.id.no_mesh_image);
        AnimationDrawable drawable = (AnimationDrawable) imageView.getBackground();
        drawable.start();

        return drawable;//返回加载的动画对象
    }


    //删除加载的动画和布局(参数1：布局      参数2：要删除的View对象      参数3：取消的动画对象)
    public static void deleteAnmation(ViewGroup layout,View view,AnimationDrawable drawable){

        drawable.stop();//停止动画
        layout.removeView(view);//删除View
    }



    //显示加载失败的方法
    public static View uploadView(Context context, ViewGroup layout) {
        View view = LayoutInflater.from(context).inflate(R.layout.no_mesh_1, layout, false);
        layout.addView(view);
        return view;//返回添加的布局对象
    }



      //删除布局View对象(加载失败的布局)
    public static void   deleteView(ViewGroup layout,View view) {
        layout.removeView(view);
    }




}
