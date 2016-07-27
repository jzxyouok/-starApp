package com.android.starapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import com.android.starapp.R;

/**
 * 找回密码界面
 * Created by My on 2016/7/12 0012.
 */
public class FindPassword extends AppCompatActivity implements View.OnClickListener {

    private EditText et_password;

    private final int SHOWINFO = 0;
    private final int CHANGEUI = 1;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SHOWINFO:
//                    ShowInfo(FindPassword.this, msg.obj.toString());
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
        setContentView(R.layout.activity_findpassword);
        initView();

    }

    private void initView() {
        findViewById(R.id.find_return).setOnClickListener(this);
        findViewById(R.id.find_yes).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.find_return:
//                onKeyDown(KeyEvent.KEYCODE_BACK, null);//调用 返回键建的方法
                onBackPressed();
                break;
            case R.id.find_yes:

//  intent.setClass(this,Register.class);
                break;

        }


    }

   /* public void click(final View view) {
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
                                    ShowInfo(FindPassword.this, res);
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
*/
}