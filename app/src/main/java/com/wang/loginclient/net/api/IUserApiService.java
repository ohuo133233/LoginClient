package com.wang.loginclient.net.api;

import com.wang.loginclient.net.base.NetConstant;
import com.wang.loginclient.net.bean.ResultUser;
import com.wang.loginclient.net.bean.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IUserApiService {
    @POST(NetConstant.LOGIN)
    Call<ResultUser> login(@Body User user);

    @POST(NetConstant.REGISTER)
    Call<ResultUser> register(@Body User user);
}
