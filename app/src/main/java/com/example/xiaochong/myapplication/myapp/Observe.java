package com.example.xiaochong.myapplication.myapp;

import com.android.volley.VolleyError;

/**
 * Created by xiaochong on 2018/3/25.
 */

public interface Observe {

    void onSuccess(String respones);
    void onError(VolleyError ve);
}
