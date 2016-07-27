package com.android.starapp.packa;

/**
 * Created by Administrator on 2016/7/14 0014.
 *
 *
 * 搭配的封装类
 */
public class Collocation {
    private String componentType;
    private String description;//商品名称
    private String itemsCount;//购买数
    private int id;
    private String actionType;
    private String userName;


    private String commentCount;//评论次数
    private String unixtime;//时间
    private String picUrl;//图片网址
    private String collectionCount;//喜欢的人数
    private String title;//标题
    private String category;//分类(潮流、星座....)
    private String v;//浏览次数

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public Collocation(String v, String unixtime, String title, String picUrl, String commentCount, String collectionCount, String category) {
        this.v = v;
        this.unixtime = unixtime;
        this.title = title;
        this.picUrl = picUrl;
        this.commentCount = commentCount;
        this.collectionCount = collectionCount;
        this.category = category;
    }

    public Collocation(String actionType, String category, String collectionCount, String componentType, String description, int id, String itemsCount, String picUrl, String title, String unixtime, String userName, String v) {
        this.actionType = actionType;
        this.category = category;
        this.collectionCount = collectionCount;
        this.componentType = componentType;
        this.description = description;
        this.id = id;
        this.itemsCount = itemsCount;
        this.picUrl = picUrl;
        this.title = title;
        this.unixtime = unixtime;
        this.userName = userName;
        this.v = v;
    }

    public String getCategory() {

        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getCollectionCount() {
        return collectionCount;
    }

    public void setCollectionCount(String collectionCount) {
        this.collectionCount = collectionCount;
    }

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(String itemsCount) {
        this.itemsCount = itemsCount;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(String unixtime) {
        this.unixtime = unixtime;
    }

    public String getUserName() {
        return userName;
    }

    public Collocation() {
    }

    @Override
    public String toString() {
        return "Collocation{" +
                "actionType='" + actionType + '\'' +
                ", componentType='" + componentType + '\'' +
                ", description='" + description + '\'' +
                ", itemsCount='" + itemsCount + '\'' +
                ", id=" + id +
                ", userName='" + userName + '\'' +
                ", commentCount='" + commentCount + '\'' +
                ", unixtime='" + unixtime + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", collectionCount='" + collectionCount + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", v='" + v + '\'' +
                '}';
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collocation(String actionType, String collectionCount, String componentType, String description, int id, String itemsCount, String picUrl, String unixtime, String userName) {
        this.actionType = actionType;
        this.collectionCount = collectionCount;
        this.componentType = componentType;
        this.description = description;
        this.id = id;
        this.itemsCount = itemsCount;
        this.picUrl = picUrl;
        this.unixtime = unixtime;
        this.userName = userName;
    }
}
