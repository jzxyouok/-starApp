package com.android.starapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.android.starapp.R;

/**
 *  反馈页面
 * Created by My on 2016/7/12 0012.
 */
public class My_Feedback extends Activity {
    private WebView webView;
    private String url = "http://fed.hichao.com/templates/webview/buy_help_new.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
       TextView button = (TextView) findViewById(R.id.feedback_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                onKeyDown(KeyEvent.KEYCODE_BACK, null);//调用 返回键建的方法
                onBackPressed();


            }
        });
        init();
    }

    private void init() {
        webView = (WebView) findViewById(R.id.feedback_web);

        //WebView加载web资源
        webView.loadUrl(url);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
    }

}
