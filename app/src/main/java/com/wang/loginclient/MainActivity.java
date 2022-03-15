package com.wang.loginclient;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.wang.loginclient.net.UserNetManager;
import com.wang.loginclient.net.base.BaseNetCallBack;
import com.wang.loginclient.net.base.BaseNetManager;
import com.wang.loginclient.net.bean.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mRegister;
    private Button mLogin;
    private EditText mAccountNumber;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        BaseNetManager.getInstance().init();
        UserNetManager.getInstance().init();
    }

    private void initView() {
        mRegister = findViewById(R.id.register);
        mLogin = findViewById(R.id.login);
        mAccountNumber = findViewById(R.id.account_number);
        mPassword = findViewById(R.id.password);

        mRegister.setOnClickListener(this);
        mLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                register();
                break;
            case R.id.login:
                login();
                break;
        }
    }

    private User getUser() {
        String accountNumber = mAccountNumber.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        return UserNetManager.getInstance().createUser(accountNumber, password);
    }

    private void register() {
        UserNetManager.getInstance().register(getUser(), new BaseNetCallBack() {
            @Override
            public <T> void success(T t) {
                upDataUI("注册", true);
            }

            @Override
            public void error(String message) {
                upDataUI("注册", false);
            }
        });
    }

    private void login() {
        UserNetManager.getInstance().login(getUser(), new BaseNetCallBack() {
            @Override
            public <T> void success(T t) {
                upDataUI("登录", true);
            }

            @Override
            public void error(String message) {
                upDataUI("登录", false);
            }
        });
    }

    public void upDataUI(String message, boolean isSuccess) {
        runOnUiThread(() -> {
            if (isSuccess) {
                Toast.makeText(MainActivity.this, message + "成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, message + "失败", Toast.LENGTH_SHORT).show();
            }
        });

    }
}