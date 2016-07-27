package com.android.starapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.starapp.R;

/**
 * 注册页面
 * Created by My on 2016/7/13 0013.
 */
public class Register extends AppCompatActivity implements View.OnClickListener {

    private String url_1 = "http://api-v2.mall.hichao.com/sms/identify?ga=/sms/identify&app_name=mxyc&sign=&phone=";

    private String url_2 = "&send_type=user_register";
    private EditText et_phone, et_code, et_key;
    private Button btn_gain, btn_yes;
    private String phone_num,gain_num,key_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏应用的标题栏
        setContentView(R.layout.register);

        initView();

    }

    private void initView() {
        et_code = (EditText) findViewById(R.id.register_code);
        et_key  = (EditText) findViewById(R.id.register_key);
        et_phone = (EditText) findViewById(R.id.register_phone);

        btn_gain = (Button) findViewById(R.id.register_gain);
        btn_gain.setOnClickListener(this);
        btn_yes = (Button) findViewById(R.id.register_yes);
        btn_yes.setOnClickListener(this);


      TextView  tv_return = (TextView) findViewById(R.id.feedback_return);
        tv_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                onKeyDown(KeyEvent.KEYCODE_BACK, null);//调用 返回键建的方法
//                onBackPressed();onBackPressed();
                onBackPressed();

            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_gain:
                phone_num = et_phone.getText().toString().trim();
                if (phone_num.equals("")) {
                    Toast.makeText(Register.this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                }






                break;
            case R.id.register_yes:
                phone_num = et_phone.getText().toString().trim();
                if (phone_num.equals("")) {
                    Toast.makeText(Register.this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                }
                gain_num = et_code.getText().toString().trim();
                if (gain_num.equals("")) {
                    Toast.makeText(Register.this, "请输入验证码", Toast.LENGTH_SHORT).show();
                }
                key_num = et_key.getText().toString().trim();
                if (key_num.equals("")) {
                    Toast.makeText(Register.this, "密码不能小于6位" +
                            "", Toast.LENGTH_SHORT).show();
                }



                break;



        }

    }
}
