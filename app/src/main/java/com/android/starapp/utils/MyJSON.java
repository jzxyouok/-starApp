package com.android.starapp.utils;

import android.util.Log;

import com.android.starapp.packa.Collocation;
import com.android.starapp.packa.Country;
import com.android.starapp.packa.Top;
import com.android.starapp.packa.Top_Items;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/12 0012.
 * <p/>
 * 首页顶部的滚动图片的数据封装类
 */
public class MyJSON {
    //参数1:json字符串   参数2：为标签头,返回Top对象
    public static Top getTop(String json_Str, String name_Str) {
        try {
            JSONObject jsonObject = new JSONObject(json_Str);

            JSONObject object = jsonObject.getJSONObject(name_Str);

            Top top = new Top();

            String title = object.optString("title");
            int id = object.optInt("id");
            long unixtime = object.optLong("unixtime");
            int v = object.optInt("v");
            int collectionCount = object.optInt("collectionCount");
            int commentCount = object.optInt("commentCount");


            top.setTitle(title);
            top.setId(id);
            top.setUnixtime(unixtime);
            top.setV(v);
            top.setCollectionCount(collectionCount);
            top.setCommentCount(commentCount);

            JSONArray array = object.optJSONArray("items");

            List<Top_Items> tops = new ArrayList<Top_Items>();//创建集合
            Top_Items top_items = null;

            int ii = 0;
            for (int i = 0; i < array.length(); i++) {
                JSONObject object1 = array.getJSONObject(i);
                JSONArray array1 = object1.getJSONArray("cells");

                for (int j = 0; j < array1.length(); j++) {
                    JSONObject object2 = array1.getJSONObject(j);
                    JSONObject object3 = object2.getJSONObject("component");

                    String componentType = object3.optString("componentType");
                    String url = object3.optString("picUrl");
                    int price = object3.optInt("price");
                    top_items = new Top_Items(componentType, url, price);//创建对象

                    tops.add(top_items);//对象添加到集合里面
                    ii++;

                }
            }

            top.setTops(tops);//对象设置集合

            return top;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    //搭配碎片的数据解析
    public static List<Collocation> getCollocations(String json_Str,boolean flag) {

        try {
            JSONObject jsonObject = new JSONObject(json_Str);
            JSONObject object = jsonObject.getJSONObject("data");
            List<Collocation> Collocations = new ArrayList<>();

            JSONArray array=object.getJSONArray("items");

            Collocation collocation=null;

            for (int i = 0; i <array.length() ; i++) {

                JSONObject object1=array.getJSONObject(i);

                JSONObject object2=object1.getJSONObject("component");

                String picUrl=object2.optString("picUrl");
                String v=object2.optString("v");
                String componentType=object2.optString("componentType");
                String title=object2.optString("title");
                String year=object2.optString("year");
                String month=object2.optString("month");
                String day=object2.optString("day");
                String category=object2.optString("category");

                String time=year+"-"+month+"-"+day;


                String description=object2.optString("description");


                int id=object2.optInt("id");



                JSONObject object3=object2.getJSONObject("action");
                String unixtime=object3.optString("unixtime");
                String actionType=object3.optString("actionType");
                String userName=object3.optString("userName");
                String itemsCount=object3.optString("itemsCount");

                String collectionCount=object3.optString("collectionCount");
                String commentCount=object3.optString("commentCount");


                if(flag){//是否是小搭配的碎片数据
                collocation=new Collocation(actionType,collectionCount,
                        componentType,description,id,itemsCount,picUrl,unixtime,userName);
                }else{//专题的碎片数据

                    collocation=new Collocation(v,time,title,picUrl,commentCount,collectionCount,category);
                }

                Collocations.add(collocation);
            }



            return Collocations;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    //首页ListView的数据
    public static Map<String,Map<Integer,Country>> getMAP(String json_Str) {

        try {
            JSONObject jsonObject = new JSONObject(json_Str);
            JSONObject object = jsonObject.getJSONObject("data");

            Map<String,Map<Integer,Country>>MAP=new HashMap<>();

            //json数组的名称
            String[] strs = {"region_name", "region_brands", "region_pictures", "region_skus"};
            String str;
            Country country=null;

            Map<Integer,Country>map=null;

            for (int i = 0; i < strs.length; i++) {//循环遍历对象里面的数组
                //馆的顶部
                JSONArray array1 = object.getJSONArray(strs[i]);
                str=strs[i];

                for (int j = 0; j < array1.length(); j++) {

                    JSONObject object1 = array1.getJSONObject(j);
                    JSONObject object2 = object1.getJSONObject("component");

                    String componentType = object2.optString("componentType");
                    String picUrl = object2.optString("picUrl");//网页
                    int price = object2.optInt("price");//商品价格
                    int origin_price = object2.optInt("origin_price");

                    JSONObject object3 = object2.getJSONObject("action");
                    String unixtime = object3.optString("unixtime");
                    String actionType = object3.optString("actionType");
                    int id = object3.optInt("id");
                    String source = object3.optString("source");
                    String sourceId = object3.optString("sourceId");

                    String bannerId = object3.optString("bannerId");
                    String title = object3.optString("title");

                    country=new Country(actionType,bannerId,componentType,id,origin_price,picUrl,
                            price,source,sourceId,title,unixtime);//创建对象

                    if(j==0){//第一次循环创建集合
                    map=new HashMap<>();
                    }
                    map.put(j,country);//添加对象到Map集合

                }
                MAP.put(str,map);//把两个集合添加到MAP集合里面
            }
            Log.i("Iterator","---------------MAP的长度为："+MAP.size());

            return MAP;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


}
