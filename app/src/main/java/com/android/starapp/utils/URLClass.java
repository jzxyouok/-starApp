package com.android.starapp.utils;

/**
 * Created by Administrator on 2016/7/12 0012.
 */
public class URLClass {
    public static final String URL_TOP1 = "http://api-v2.mall.hichao.com/topic/view?width=480&ga=%2Ftopic%2Fview&twm=1&topic_id=13900";


    //首页滑动图片网址的数组
    public static final String[] TOPS = {
            "http://s0.pimg.cn/group5/M00/09/76/wKgBfVd_fdCAEuTaAAPrL0CZbnY529.jpg?imageMogr2?imageMogr2?imageMogr2",
            "http://s0.pimg.cn/group6/M00/4B/BE/wKgBjVeDBauAWwl1AAQq0JEMGcI003.jpg?imageMogr2?imageMogr2?imageMogr2",
            "http://s0.pimg.cn/group5/M00/0B/C3/wKgBf1eDUTKAdTZtAANmGESuyNY391.jpg?imageMogr2?imageMogr2?imageMogr2",
            "http://s0.pimg.cn/group5/M00/0B/B4/wKgBf1eDLImAD5PpAAPvmhWGRjw573.jpg?imageMogr2?imageMogr2?imageMogr2"
    };


    //国家馆的网址(上、下部分) region_id：value值1--6
    public static final String COUNTRY_URL1 = "http://api-v2.mall.hichao.com/mall/region/new?region_id=";
    public static final String COUNTRY_URL2 = "&ga=/mall/region/new";


    //搭配的网址(上下两部分)
    /**
     * 参数：category =  热门、本土、欧美、日韩、型男、复古、最新、轻熟、OL、清新、混搭、甜美、街头、闺蜜、
     * 休闲、摩登、逛街、约会、派对、运动、出游、典礼、高挑、较小、丰满、优选/
     * <p/>
     * <p/>
     * lts=???  页数
     */
    public static final String COLLOCATION_URL1 = "http://api-v2.mall.hichao.com/star/list?category=";
    public static final String COLLOCATION_URL2 = "&pin=&ga=/star/list&flag=&lts=";

    //搭配里面的专题
    public static final String COLLOCATION_URL3 = "http://api-v2.mall.hichao.com/mix_topics?category=2&ga=/mix_topics&flag=";

    //社区顶部的轮播图片
    public static final String[] ItemTops = {
            "http://s0.pimg.cn/group6/M00/4C/A4/wKgBjFeGEmmAF2-bAANwkos6u8g358.jpg?imageMogr2?imageMogr2?imageMogr2",
            "http://s0.pimg.cn/group5/M00/0C/63/wKgBf1eF5POATZRDAAOrmvIbBfA598.jpg?imageMogr2?imageMogr2?imageMogr2",
            "http://s0.pimg.cn/group5/M00/06/C1/wKgBfVd2O6OAJ4IBAAOMyEFA0xU731.jpg?imageMogr2?imageMogr2?imageMogr2"};


}
