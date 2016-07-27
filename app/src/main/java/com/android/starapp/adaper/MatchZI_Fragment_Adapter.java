package com.android.starapp.adaper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.starapp.R;
import com.android.starapp.packa.Collocation;
import com.android.starapp.view.MyListView;

import java.util.List;

/**
 * Created by Administrator on 2016/7/14 0014.
 *
 * 专题碎片ListView的布局
 */
public class MatchZI_Fragment_Adapter extends BaseAdapter{
    List<Collocation> collocations;//数据集合

    public MatchZI_Fragment_Adapter(List<Collocation> collocations){
        this.collocations=collocations;

    }

    @Override
    public int getCount() {
        return collocations.size();
    }

    @Override
    public Object getItem(int position) {
        return collocations.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder holder;
        if(convertView==null){
            //加载布局文件，转换为View对象
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.matchzi_fragment2_listview,parent,false);
            holder=new MyViewHolder();
            holder.imageView= (ImageView) convertView.findViewById(R.id.matchzi_fragment2_listview_image);
            holder.tv1= (TextView) convertView.findViewById(R.id.matchzi_fragment2_listview_tv1);
            holder.tv2= (TextView) convertView.findViewById(R.id.matchzi_fragment2_listview_tv2);
            holder.tv3= (TextView) convertView.findViewById(R.id.matchzi_fragment2_listview_tv3);
            holder.tv4= (TextView) convertView.findViewById(R.id.matchzi_fragment2_listview_tv4);
            holder.tv5= (TextView) convertView.findViewById(R.id.matchzi_fragment2_listview_tv5);
            holder.tv6= (TextView) convertView.findViewById(R.id.matchzi_fragment2_listview_tv6);

            convertView.setTag(holder);
        }else{
            holder= (MyViewHolder) convertView.getTag();
        }

        Collocation collocation=collocations.get(position);



        MyListView.mma(parent.getContext(), holder.imageView, collocation.getPicUrl());
        holder.tv1.setText(collocation.getTitle());
        holder.tv2.setText(collocation.getUnixtime());
        holder.tv3.setText(collocation.getCategory());
        holder.tv4.setText(collocation.getCommentCount());
        holder.tv5.setText(collocation.getV());
        holder.tv6.setText(collocation.getCollectionCount());

        return convertView;
    }



   static  class MyViewHolder{
        public ImageView imageView;
        public TextView tv1,tv2,tv3,tv4,tv5,tv6;
    }
}
