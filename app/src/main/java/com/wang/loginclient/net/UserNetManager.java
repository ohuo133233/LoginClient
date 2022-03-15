package com.wang.loginclient.net;


import android.util.Log;

import androidx.annotation.NonNull;

import com.wang.loginclient.net.api.IUserApiService;
import com.wang.loginclient.net.base.BaseNetCallBack;
import com.wang.loginclient.net.base.BaseNetManager;
import com.wang.loginclient.net.bean.ResultUser;
import com.wang.loginclient.net.bean.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserNetManager {
    private static final String TAG = "UserNetManager";
    private Retrofit mRetrofit;
    private int mCode;

    private IUserApiService mIUserApiService;


    private UserNetManager() {
    }

    public static UserNetManager getInstance() {
        return UserNetManagerHolder.instance;
    }

    private static class UserNetManagerHolder {
        private static UserNetManager instance = new UserNetManager();
    }

    public void init() {
        mRetrofit = BaseNetManager.getInstance().getRetrofit();
        mIUserApiService = mRetrofit.create(IUserApiService.class);
    }

    public void login(User user, BaseNetCallBack baseNetCallBack) {
        Log.d(TAG, "user: " + user.toString());
        Call<ResultUser> login = mIUserApiService.login(user);
        login.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<ResultUser> call, @NonNull Response<ResultUser> response) {
                ResultUser resultUser = response.body();
                if (resultUser == null) {
                    baseNetCallBack.error("resultUser==null");
                } else if (response.code() == 200 && resultUser.getCode() == 200) {
                    baseNetCallBack.success(resultUser);
                } else {
                    baseNetCallBack.error("不等于200");
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResultUser> call, @NonNull Throwable t) {
                baseNetCallBack.error(t.getMessage());
                Log.e(TAG, "t.getMessage(): " + t.getMessage());
            }
        });
    }

    public void register(User user, BaseNetCallBack baseNetCallBack) {
        Log.d(TAG, "register user: " + user.toString());
        Call<ResultUser> register = mIUserApiService.register(user);
        register.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<ResultUser> call, @NonNull Response<ResultUser> response) {
                ResultUser resultUser = response.body();
                if (resultUser == null) {
                    baseNetCallBack.error("resultUser==null");
                } else if (response.code() == 200 && resultUser.getCode() == 200) {
                    baseNetCallBack.success(resultUser);
                } else {
                    baseNetCallBack.error("不等于200");
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResultUser> call, @NonNull Throwable t) {
                baseNetCallBack.error(t.getMessage());
                Log.e(TAG, "t.getMessage(): " + t.getMessage());
            }
        });
    }

    // 创建请求体的User对象
    public User createUser(String accountNumber, String password) {
        User user = new User();
        user.setAccount_number(accountNumber);
        user.setPassword(password);
        user.setPhone("默认手机号");
        return user;
    }


}
