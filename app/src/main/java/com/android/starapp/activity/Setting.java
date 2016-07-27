package com.android.starapp.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.android.starapp.R;
import com.android.starapp.utils.AppUtils;
import com.android.starapp.utils.DataCleanManager;
import com.android.starapp.utils.UpdateManager;

/**
 * 设置页面
 * Created by My on 2016/7/13 0013.
 */
public class Setting extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_Version, tv_login;

    Setting mCouent;//上下文
    private boolean isLogin = true;//是否登录

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏应用的标题栏
        setContentView(R.layout.setting);


        initView();


    }

    private void initView() {
        mCouent = this;
        tv_Version = (TextView) findViewById(R.id.setting_version);
        tv_Version.setText(AppUtils.getVersion(mCouent));//获取软件版本
        findViewById(R.id.setting_all).setOnClickListener(this);//大家都在玩
        findViewById(R.id.setting_clean).setOnClickListener(this);//清理缓存
        tv_login = (TextView) findViewById(R.id.setting_login);
        tv_login.setOnClickListener(this);//退出登录

        findViewById(R.id.setting_updata).setOnClickListener(this);//更新
        findViewById(R.id.setting_updatakey).setOnClickListener(this);//修改密码
        findViewById(R.id.setting_declare).setOnClickListener(this);//声明
        findViewById(R.id.setting_recommend).setOnClickListener(this);//推荐
        findViewById(R.id.setting_praise).setOnClickListener(this);//好评
         TextView tv_retren= (TextView) findViewById(R.id.setting_return);//返回

        tv_retren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                onKeyDown(KeyEvent.KEYCODE_BACK, null);//调用 返回键建的方法  不能用，
                onBackPressed();
            }
        });



    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();

        switch (v.getId()) {
            case R.id.setting_updata:
                UpdateManager manager = new UpdateManager(Setting.this);
                // 检查软件更新
                manager.checkUpdate();

                break;
            case R.id.setting_clean:
                AppUtils.showShort(this, "正在清除缓存");
                DataCleanManager.cleanExternalCache(mCouent);//清除缓存
                AppUtils.showShort(this, "清除缓存完成");
                break;

            case R.id.setting_recommend:
                share();
                break;
            case R.id.setting_praise://好评
                //以下代码为打开本机自带的 应用市场，进行评分
                Uri uri = Uri.parse("market://details?id=" + getPackageName());
                intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                break;
            case R.id.setting_declare://声明
                intent.setClass(this, Setting_Declare.class);
                startActivity(intent);

                break;
            case R.id.setting_all:

                AppUtils.showShort(this, "Let's go shopping ");
                break;

            case R.id.setting_login:
                if (isLogin = true) {
                    AppUtils.showShort(this, "Let's login ");
                    intent.setClass(this,MyLogin.class);
                    startActivity(intent);

                } else {
                    tv_login.setText("退出登录");
                }
                break;


        }

    }

    //分享
    public void share() {
        // 启动分享发送的属性
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain"); // 分享发送的数据类型
        String msg = "推荐给大家";
        // 分享的内容
        intent.putExtra(Intent.EXTRA_TEXT, msg);
        // 目标应用选择对话框的标题
        startActivity(Intent.createChooser(intent, "选择分享到"));
    }
}

