package com.example.xiaochong.myapplication.net;



import com.android.volley.VolleyError;

/**
 * 属性：常量
 * 方法：抽象方法
 */
public interface Observe {

    void onSuccess(String response);
    void onError(VolleyError ve);

}
