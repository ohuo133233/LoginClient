package com.wang.loginclient.net.base;

public interface BaseNetCallBack {
    <T> void success(T t);

    void error(String message);
}
