package com.android.starapp.packa;

/**
 * Created by Administrator on 2016/7/12 0012.
 *
 *  Top封装的子对象
 *
 *      component
 */
public class Top_Items {

    private String componentType;
    private String picUrl;//图片网址
    private int price;//价格

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public Top_Items() {
    }

    @Override
    public String toString() {
        return "Top_Items{" +
                "componentType='" + componentType + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", price=" + price +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Top_Items(String componentType, String picUrl, int price) {

        this.componentType = componentType;
        this.picUrl = picUrl;
        this.price = price;
    }
}
