package com.android.starapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.starapp.R;
import com.android.starapp.utils.URLClass;
import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2016/7/12 0012.
 * <p>
 * 首页的自定义ListView、
 *
 *      mma方法，加载图片，并且显示到控件上
 */
public class MyListView extends ListView {

    //限时购的图片网址
    private String url1="http://s.pimg.cn/group5/M00/09/E9/wKgBfVeDb_CAOPJoAAEX87Jy728163.jpg";
    private String url2="http://s.pimg.cn/group5/M00/09/CF/wKgBfVeDPeuAPQwGAAEMYjYzmBw773.jpg";



    private TextView loosen_textview;//松开刷新的布局，里面的文本控件
    private ImageView loosen_image;//图片控件


    private ImageView time_image1,time_image2;


    private View view;//下拉刷新的View对象
    private ViewTop viewTop;//首页顶部的滚动
    private View view1;//限时抢购View

    private int headerHeight;//添加的顶部布局高度(松开刷新)
    private boolean isComplete = false;//判断是否拖动到底部了
    private RotateAnimation  animationUp,animationDown,animationBar;//旋转的补间动画对象

    public MyListView(Context context) {
        super(context);
        init();
    }


    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {
        addTOPView();//初始化两个View
        initAnimation();//动画的方法

    }

    private void addTOPView() {
        //把布局文件转换为View对象
        view = LayoutInflater.from(getContext()).inflate(R.layout.loosen, null);
        loosen_textview = (TextView) view.findViewById(R.id.loosen_textview);
        loosen_image= (ImageView) view.findViewById(R.id.loosen_image);

        //获取布局的高度
        view.measure(0, 0);
        headerHeight = view.getMeasuredHeight();
        view.setPadding(0, -headerHeight, 0, 0);//设置内边距，不可见(隐藏View)
        this.addHeaderView(view);//把View对象加载到ListView的顶部


        viewTop=new ViewTop(getContext());
        viewTop.setOnLienter(new ViewTop.OnListeren() {
            @Override
            public String[] getURL() {
                return URLClass.TOPS;
            }
        });


        this.addHeaderView(viewTop);
        viewTop.setData(true);



        view1=LayoutInflater.from(getContext()).inflate(R.layout.time, null);
        time_image1= (ImageView) view1.findViewById(R.id.time_image1);
        time_image2= (ImageView) view1.findViewById(R.id.time_image2);

        this.addHeaderView(view1);

       mma(getContext(),time_image1,url1);
       mma(getContext(),time_image2,url2);
    }

    private float down_y;//点击的Y坐标

    //定义表示ListView状态的常量
    private final int PULLREFRESH = 0;//下拉刷新
    private final int RELLRESH = 1;//松开刷新
    private final int RELLRESHING = 2;//正在刷新
    private int currentState = PULLREFRESH;//记录当前状态(初始化为下拉刷新)
    private int paddingTop = 0;




    @Override
    public boolean onTouchEvent(MotionEvent ev) {


        switch (ev.getAction()) {//判断ListView的状态
            case MotionEvent.ACTION_DOWN://按下状态

                down_y = ev.getY();//获得按下的Y坐标(高度)
                break;
            case MotionEvent.ACTION_MOVE://移动状态
                float y = ev.getY();
                //往下拉(获得用户往下拉的距离，高度)
                int length = (int) (y - down_y);

                paddingTop = length - headerHeight;//往下拉的距离和顶部View的内边距

                //正在刷新
                if (currentState == RELLRESHING) {
                    break;
                }

                //大于顶部View的高度
                if (paddingTop > -headerHeight && getFirstVisiblePosition() == 0) {


                    view.setPadding(0, paddingTop, 0, 0);//设置顶部的内边距(显示出来)

                    //下拉刷新
                    if (paddingTop >= 0 && currentState == PULLREFRESH) {//正在刷新
                        currentState = RELLRESH;//松开刷新
                        refreshState();//修改界面的方法
                    } else if (paddingTop < 0 && currentState == RELLRESH) {//松开刷新
                        currentState = PULLREFRESH;//正在刷新
                        refreshState();//处理事件的方法
                    }
                    return true;//ListView不用处理滑动事件

                }
                break;

            case MotionEvent.ACTION_UP://松开状态
                if (currentState == PULLREFRESH) {//下拉刷新
                    view.setPadding(0, -headerHeight, 0, 0);//隐藏View
                } else if (currentState == RELLRESH) {//松开刷新
                    currentState = RELLRESHING;//正在刷新
                    refreshState();

                }
        }

        return super.onTouchEvent(ev);//不消费此次触屏事件
    }


    private void refreshState() {//修改界面的显示
        switch (currentState) {//当前状态
            case PULLREFRESH://下拉刷新
                loosen_textview.setText("下拉刷新");
                loosen_image.startAnimation(animationDown);
                break;
            case RELLRESH://松开刷新
                loosen_textview.setText("松开刷新");
                loosen_image.startAnimation(animationUp);
                break;
            case RELLRESHING://正在刷新
                loosen_textview.setText("正在刷新");
                view.setPadding(0, 0, 0, 0);//设置内边距(完全显示)

                complete(true);

                break;

        }

    }


    public void initAnimation() {
        animationUp=new RotateAnimation(0,-180,
                RotateAnimation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);

        animationUp.setDuration(1000);
        animationUp.setFillAfter(true);

        animationDown=new RotateAnimation(-180,-360,
                RotateAnimation.RELATIVE_TO_SELF,0.5f,
                RotateAnimation.RELATIVE_TO_SELF,0.5f);
        animationDown.setDuration(1000);
        animationDown.setFillAfter(true);


        //图片的旋转动画
        animationBar = new RotateAnimation(
                0, 360, RotateAnimation.RELATIVE_TO_PARENT, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animationBar.setDuration(1000);
        animationBar.setFillAfter(true);
        animationBar.setRepeatCount(Animation.INFINITE);//无限循环

    }


    public void complete(boolean isPull) {
        if (isPull) {
            currentState = PULLREFRESH;//下拉刷新
            loosen_textview.setText("下拉刷新");
            view.setPadding(0, -headerHeight, 0, 0);//隐藏顶部View
        }
    }

    //加载图片并且显示在控件上的方法
    public static void mma(Context context,ImageView imageView,String url){
        Picasso.with(context)
                .load(url)
                //.placeholder(R.mipmap.bb6)
                //.error(R.mipmap.bb7)
                .into(imageView);
    }
}