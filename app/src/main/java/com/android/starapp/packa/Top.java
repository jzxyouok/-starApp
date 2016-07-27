package com.android.starapp.packa;

import java.util.List;

/**
 * Created by Administrator on 2016/7/12 0012.
 *
 * 每周ＴＯＰ榜单(首页滚动的图片都可以)
 *  衣橱Top的封装类
 */
public class Top {

    private String title;//标题
    private int id;
    private long unixtime; //不知道是啥，看着像时间
    private int v;//浏览次数
    private int collectionCount;//喜欢的人数
    private int commentCount;//评论的次数
    private String items;//JSON(数组，数据)字符串


    private List<Top_Items> tops;

    public List<Top_Items> getTops() {
        return tops;
    }

    public void setTops(List<Top_Items> tops) {
        this.tops = tops;
    }

    public int getCollectionCount() {
        return collectionCount;
    }

    public void setCollectionCount(int collectionCount) {
        this.collectionCount = collectionCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(long unixtime) {
        this.unixtime = unixtime;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }


    @Override
    public String toString() {
        return "Top{" +
                "collectionCount=" + collectionCount +
                ", title='" + title + '\'' +
                ", id=" + id +
                ", unixtime=" + unixtime +
                ", v=" + v +
                ", commentCount=" + commentCount +
                ", items='" + items + '\'' +
                '}';
    }
}
