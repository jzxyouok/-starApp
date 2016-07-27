package com.android.starapp.adaper;

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
 * 小搭配碎片的子碎片里面的ListView的布局
 */
public class MatchZI_ZI_Adapter extends BaseAdapter{
    List<Collocation> collocations;//数据集合

    public MatchZI_ZI_Adapter(List<Collocation> collocations){
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
        ViewHolder holder;
        if(convertView==null){
            //加载布局文件，转换为View对象


            holder=new ViewHolder();
            holder.matchzi_zi_imagea= (ImageView) convertView.findViewById(R.id.matchzi_zi_imagea);
            holder.matchzi_zi_imageb= (ImageView) convertView.findViewById(R.id.matchzi_zi_imageb);
            holder.matchzi_zi_text1= (TextView) convertView.findViewById(R.id.matchzi_zi_text1);
            holder.matchzi_zi_text2= (TextView) convertView.findViewById(R.id.matchzi_zi_text2);
            holder.matchzi_zi_text3= (TextView) convertView.findViewById(R.id.matchzi_zi_text3);

            holder.matchzi_zi_text11= (TextView) convertView.findViewById(R.id.matchzi_zi_text11);
            holder.matchzi_zi_text22= (TextView) convertView.findViewById(R.id.matchzi_zi_text22);
            holder.matchzi_zi_text33= (TextView) convertView.findViewById(R.id.matchzi_zi_text33);

            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }

        Collocation collocation=collocations.get(position);

        if((position+1)%2!=0){//奇数
            MyListView.mma(parent.getContext(),holder.matchzi_zi_imagea,collocation.getPicUrl());
            holder.matchzi_zi_text1.setText(collocation.getDescription());
            holder.matchzi_zi_text2.setText(collocation.getItemsCount());
            holder.matchzi_zi_text3.setText(collocation.getCollectionCount());
        }else{
            MyListView.mma(parent.getContext(),holder.matchzi_zi_imageb,collocation.getPicUrl());
            holder.matchzi_zi_text11.setText(collocation.getDescription());
            holder.matchzi_zi_text22.setText(collocation.getItemsCount());
            holder.matchzi_zi_text33.setText(collocation.getCollectionCount());
        }


        return convertView;
    }



    class ViewHolder{
        public ImageView matchzi_zi_imagea,matchzi_zi_imageb;//图片(左右两边)
        public TextView matchzi_zi_text1,matchzi_zi_text2,matchzi_zi_text3;//左边的文本
        public TextView matchzi_zi_text11,matchzi_zi_text22,matchzi_zi_text33;//右边的文本
    }
}
