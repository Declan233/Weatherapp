package com.example.xiaochong.myapplication.net;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.xiaochong.myapplication.myapp.MyApplication;


public class MyNet {

    public static String TAG = "MyMet";

    public static void requestGet(Context context, String url, final Observe observe) {
        //2.得到一个请求队列
        RequestQueue requestQueue = MyApplication.getRequestQueue();
        //3.以什么方式进行网络请求:get post;
        //参数：get、post：请求方式；url：请求地址；Listener：请求成功回调事件；ErrorListener：请求是失败回调方法
        Log.d(TAG, "requestGet: 111"+url);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: " + response);
                observe.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d(TAG, "onErrorResponse: " + volleyError.toString());
                observe.onError(volleyError);
            }
        });
        Log.d(TAG, "requestGet: 222"+url);

        //4.将我们的请求放入到我们的队列中
        requestQueue.add(stringRequest);
        requestQueue.start();
    }
}
