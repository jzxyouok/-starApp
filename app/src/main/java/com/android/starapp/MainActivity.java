package com.android.starapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.starapp.fragment.Cart_Fragment;
import com.android.starapp.fragment.Home_Fragment;
import com.android.starapp.fragment.Item_Fragment;
import com.android.starapp.fragment.Like_Fragment;
import com.android.starapp.fragment.Match_Fragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnClickListener {

    private RadioGroup main_group;
    private FrameLayout main_layout;
    private String[] strs = {"首页的碎片", "搭配的碎片", "社区的碎片", "购物车的碎片", "我的碎片"};
    private Fragment currentFragment;//记录当前显示的碎片对象
    private Bundle bundle;

    private Home_Fragment home;//首页碎片对象
    private Match_Fragment match;//搭配
    private Item_Fragment item;//社区
    private Cart_Fragment cart;//购物车
    private Like_Fragment like;//我的

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏应用的标题栏
        setContentView(R.layout.activity_main);





        initView();
    }

        private void initView() {
            main_group = (RadioGroup) findViewById(R.id.main_group);
            main_layout = (FrameLayout) findViewById(R.id.main_layout);

            for (int i = 0; i <main_group.getChildCount() ; i++) {
                RadioButton button= (RadioButton) main_group.getChildAt(i);
                button.setTag(i);
                button.setOnClickListener(this);
            }

            //获取碎片管理器对象
            FragmentManager fragmentManager = getSupportFragmentManager();
            //开启事物，获得操作碎片的对象
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            home = new Home_Fragment();
            bundle = new Bundle();
            bundle.putString("text0", strs[0]);
            home.setArguments(bundle);

            currentFragment = home;//记录当前的碎片
            transaction.add(R.id.main_layout, home);//添加布局和碎片对象
            transaction.commit();//提交事物
        }


    @Override
    public void onClick(View v) {
        int tag= (int) v.getTag();
        switch (tag) {
            case 0:
                showFragment(0);
                break;
            case 1:
                showFragment(1);
                break;
            case 2:
                showFragment(2);
                break;
            case 3:
                showFragment(3);
                break;
            case 4:
                showFragment(4);
                break;
        }

    }


    //显示碎片对象，隐藏当前的碎片对象
    private void showFragment(int index) {
        //获取碎片管理器
        FragmentManager fm = getSupportFragmentManager();
        //开启事物，获得操作碎片对象
        FragmentTransaction transaction = fm.beginTransaction();


        for (int i = 0; i <main_group.getChildCount() ; i++) {
               RadioButton button= (RadioButton) main_group.getChildAt(i);
           if(i==index){
               button.setTextColor(getResources().getColor(R.color.main_text_yes));
               continue;//跳过本次循环
           }
            button.setTextColor(getResources().getColor(R.color.main_text_no));
        }


        if (index == 0) {//1号碎片(首页)
            if (home == null) {
                home = new Home_Fragment();
                bundle = new Bundle();
                bundle.putString("text0", strs[0]);
                home.setArguments(bundle);
            }
            if (home.isAdded()) {//如果碎片对象存在
                transaction.show(home);//显示该碎片
                transaction.hide(currentFragment);//隐藏当前碎片(前一个)
            } else {//如果碎片对象不存在
                transaction.add(R.id.main_layout, home);//添加碎片
                transaction.hide(currentFragment);//隐藏当前的碎片
            }
            transaction.commit();//提交事件
            currentFragment = home;//记录当前显示的碎片

        } else if (index == 1) {//搭配碎片
            if (match == null) {
                match = new Match_Fragment();
                bundle = new Bundle();
                bundle.putString("text1", strs[1]);
                match.setArguments(bundle);

            }
            if (match.isAdded()) {//如果对象存在
                transaction.show(match);
                transaction.hide(currentFragment);
            } else {//否则对象不存在
                transaction.add(R.id.main_layout, match);
                transaction.hide(currentFragment);
            }
            transaction.commit();//提交事物
            currentFragment = match;

        } else if (index == 2) {//社区碎片
            if (item == null) {
                item = new Item_Fragment();
                bundle = new Bundle();
                bundle.putString("text2", strs[2]);
                item.setArguments(bundle);

            }
            if (item.isAdded()) {//如果对象存在
                transaction.show(item);
                transaction.hide(currentFragment);
            } else {//否则对象不存在
                transaction.add(R.id.main_layout, item);
                transaction.hide(currentFragment);
            }
            transaction.commit();//提交事物
            currentFragment = item;

        } else if (index == 3) {//购物车碎片
            if (cart == null) {
                cart = new Cart_Fragment();
                bundle = new Bundle();
                bundle.putString("text3", strs[3]);
                cart.setArguments(bundle);

            }
            if (cart.isAdded()) {//如果对象存在
                transaction.show(cart);
                transaction.hide(currentFragment);
            } else {//否则对象不存在
                transaction.add(R.id.main_layout, cart);
                transaction.hide(currentFragment);
            }
            transaction.commit();//提交事物
            currentFragment = cart;

        } else if (index == 4) {//我的碎片
            if (like == null) {
                like = new Like_Fragment();
                bundle = new Bundle();
                bundle.putString("text4", strs[4]);
                like.setArguments(bundle);


            }

            if (like.isAdded()) {//如果对象存在
                transaction.show(like);
                transaction.hide(currentFragment);

            } else {//否则对象不存在
                transaction.add(R.id.main_layout, like);
                transaction.addToBackStack("like");
                transaction.hide(currentFragment);
            }
            transaction.commit();//提交事物
            currentFragment = like;
        }
    }
}