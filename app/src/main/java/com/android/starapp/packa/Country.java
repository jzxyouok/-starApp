package com.android.starapp.packa;

/**
 * Created by Administrator on 2016/7/12 0012.
 *
 *
 String unixtime = object3.optString("unixtime");
 String actionType = object3.optString("actionType");
 String id = object3.optString("id");
 String bannerId = object3.optString("bannerId");
 String title = object3.optString("title");

 String componentType = object2.optString("componentType");
 String picUrl = object2.optString("picUrl");//网页
 int price = object2.optInt("price");//商品价格
 int origin_price = object2.optInt("origin_price");


 * 什么美国馆、高丽棒子馆
 */
public class Country {
    private String componentType;
    private String picUrl;
    private String title;//商品名称
    private int price;//价格
    private int origin_price;//原来的价格
    private String unixtime;
    private String actionType;
    private int id;
    private String bannerId;
    private String source;
    private String sourceId;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Country(String actionType, String bannerId, String componentType, int id, int origin_price, String picUrl, int price, String source, String sourceId, String title, String unixtime) {

        this.actionType = actionType;
        this.bannerId = bannerId;
        this.componentType = componentType;
        this.id = id;
        this.origin_price = origin_price;
        this.picUrl = picUrl;
        this.price = price;
        this.source = source;
        this.sourceId = sourceId;
        this.title = title;
        this.unixtime = unixtime;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(String unixtime) {
        this.unixtime = unixtime;
    }



    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public int getOrigin_price() {
        return origin_price;
    }

    public void setOrigin_price(int origin_price) {
        this.origin_price = origin_price;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Country() {
    }


    @Override
    public String toString() {
        return "Country{" +
                "actionType='" + actionType + '\'' +
                ", componentType='" + componentType + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", origin_price=" + origin_price +
                ", unixtime='" + unixtime + '\'' +
                ", id=" + id +
                ", bannerId='" + bannerId + '\'' +
                ", source='" + source + '\'' +
                ", sourceId='" + sourceId + '\'' +
                '}';
    }
}
