package com.wang.loginclient.net.base;


import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class BaseNetManager {
    private OkHttpClient mOkHttpClient;
    private Retrofit mRetrofit;

    private BaseNetManager() {

    }

    public static BaseNetManager getInstance() {
        return BaseNetInstance.instance;
    }

    private static class BaseNetInstance {
        private static final BaseNetManager instance = new BaseNetManager();
    }

    public void init() {
        mOkHttpClient = initOkHttp();
        mRetrofit = initRetrofit();

    }

    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message -> {
        // 打印retrofit日志
        Log.e("RetrofitLog", "retrofitBack = " + message);
    });

    private OkHttpClient initOkHttp() {
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        // 创建OkHttpClient对象
        return new OkHttpClient.Builder()
                // 连接超时
                .connectTimeout(10, TimeUnit.SECONDS)
                // 写入时间
                .writeTimeout(10, TimeUnit.SECONDS)
                // 读取超时
                .readTimeout(30, TimeUnit.SECONDS)
                // 增加log拦截器
                .addInterceptor(loggingInterceptor)
                .build();
    }

    public Retrofit initRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(NetConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(mOkHttpClient)
                .build();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }

}
