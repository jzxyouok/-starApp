package com.android.starapp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.starapp.R;
import com.android.starapp.utils.AppUtils;
import com.android.starapp.utils.StreamTools;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * 登录界面
 * <p/>
 * Created by My on 2016/7/12 0012.
 */
public class MyLogin extends AppCompatActivity implements View.OnClickListener {

    private EditText et_username;
    private EditText et_password;
    private Jumper jumper1;

    ImageView img, img1,img2,img3;

    private ImageView tv_return;
    private final int SHOWINFO = 0;
    private final int CHANGEUI = 1;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case SHOWINFO:
                    ShowInfo(MyLogin.this, msg.obj.toString());
                    break;
                case CHANGEUI:
                    break;
                default:
                    break;
            }
        }

        ;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏应用的标题栏
        setContentView(R.layout.activity_login);
        et_username = (EditText) findViewById(R.id.login_phone);
        et_password = (EditText) findViewById(R.id.login_key);
        initView();

    }

    private void initView() {

        tv_return = (ImageView) findViewById(R.id.login_return);
        tv_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// onKeyDown(KeyEvent.KEYCODE_BACK, null);//调用 返回键建的方法
                onBackPressed();

            }
        });
        findViewById(R.id.login_register).setOnClickListener(this);
        findViewById(R.id.login_nokey).setOnClickListener(this);
        findViewById(R.id.imageViewItem).setOnClickListener(this);
        findViewById(R.id.imageViewItem1).setOnClickListener(this);

        findViewById(R.id.imageViewItem2).setOnClickListener(this);
        findViewById(R.id.imageViewItem3).setOnClickListener(this);
        findViewById(R.id.login_yes).setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {

            case R.id.login_register:
                intent.setClass(this, Register.class);
                startActivity(intent);

                break;
            case R.id.login_nokey:
                intent.setClass(this, FindPassword.class);
                startActivity(intent);

                break;
            case R.id.imageViewItem:
                AppUtils.showShort(this, "第三方登录接口正在升级中...");
                break;
            case R.id.imageViewItem1:
                AppUtils.showShort(this,"第三方登录接口正在升级中...");

                break;
            case R.id.imageViewItem3:
                AppUtils.showShort(this,"第三方登录接口正在升级中...");

                break;
            case R.id.imageViewItem2:
                AppUtils.showShort(this,"第三方登录接口正在升级中...");

                break;
            case R.id.login_yes:
                AppUtils.showShort(this,"登录系统正在升级中...");

                break;
        }


    }

    public void click(final View view) {
        final String username = et_username.getText().toString().trim();
        final String password = et_password.getText().toString().trim();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "信息不可为空", Toast.LENGTH_LONG).show();
        } else {

            new Thread() {
                @Override
                public void run() {
                    try {
                        InputStream is = null;
                        // GET方式
                        if (view.getId() == R.id.login_yes) {
                            is = postByHttpConnection(username, password);
                        }

                        final String res = StreamTools.StreamToString(is);
                        if (res != null) {
                            // 不使用handler的另一种方式
                            // 这种方式也可以封装
                            runOnUiThread(new Runnable() {

                                @Override
                                public void run() {
                                    ShowInfo(MyLogin.this, res);
                                }
                            });
                        } else {
                            handler.sendMessage(getMsg(SHOWINFO, "失败"));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        handler.sendMessage(getMsg(SHOWINFO, "获取失败"));
                    }
                }
            }.start();
        }
    }

    private InputStream postByHttpConnection(final String username, final String password) throws MalformedURLException, IOException, ProtocolException {
        HttpURLConnection conn;
        // POST方式
        String path = "http://oauth.hichao.com/connect/app/login";
        URL post_url = new URL(path);
        conn = (HttpURLConnection) post_url.openConnection();
        conn.setRequestMethod("POST");

        // 准备数据
        String data = "username=" + username + "&ga=http://oauth.hichao.com/connect/app/login&password=" + password;
        byte[] data_bytes = data.getBytes();

        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", data_bytes.length + "");
        // POST方式：浏览器将数据以流的方式写入服务器
        conn.setDoOutput(true);// 允许向外部写入数据
        OutputStream os = conn.getOutputStream();
        os.write(data_bytes);
        conn.setConnectTimeout(5000);

        if (200 == conn.getResponseCode()) {
            return conn.getInputStream();
        }
        return null;
    }


    public Message getMsg(int what, Object obj) {
        Message msg = new Message();
        msg.what = what;
        msg.obj = obj;
        return msg;
    }

    public void ShowInfo(Context context, String info) {
        Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
        System.out.println("返回信息：" + info);
    }

    @Override
    protected void onStart() {
        super.onStart();

        img = (ImageView) findViewById(R.id.imageViewItem);
        img1 = (ImageView) findViewById(R.id.imageViewItem1);
        img2 = (ImageView) findViewById(R.id.imageViewItem2);
        img3 = (ImageView) findViewById(R.id.imageViewItem3);
        jumper1 = new Jumper(1000, 50);

     /*   jumper1 = new Jumper(1000, 50);
        jumper2 = new jumper(1000, 50);
        jumper3 = new jumpe(1000, 50);
        jumper4 = new jumper4(1000, 50)*/;
        jumper1.attachToView(img);jumper1.attachToView(img1);jumper1.attachToView(img2);jumper1.attachToView(img3);
    }



}