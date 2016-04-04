package com.example.database;

/**
 * Created by Administrator on 2016/3/29.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
