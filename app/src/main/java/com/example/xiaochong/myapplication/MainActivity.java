package com.example.xiaochong.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.xiaochong.myapplication.Adpter.ListAdapter;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //alt+enter 自动导包

    private ListView lv1;
    private ListAdapter d;
    private List list = new ArrayList();
    private Button bt;
    private TextView tv;
//    command+j     tagt
    private  static  final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        init();
    }


    void initData(){
        for (int i=1; i<=10; i++){
            list.add("name"+i);
        }
    }

    void init(){
        lv1 = findViewById(R.id.listview);
        d = new ListAdapter(MainActivity.this, list);
        //listview绑定适配器
        lv1.setAdapter(d);
        bt = findViewById(R.id.bt_weather);
        tv = findViewById(R.id.tv1);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });
    }

    void getData(){
        //参数url化
        String city = null;
        try {
            city = java.net.URLEncoder.encode("北京", "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //拼地址
        String url = String.format("http" +
                "s://www.sojson.com/open/api/weather/json.shtml?city=%s",city);
        //建队列
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //请求
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.d(TAG, "onResponse: "+s);
                try{
                    JSONObject object = new JSONObject(s);
                    final String msg = object.getString("message");
                    JSONObject data = new JSONObject(object.getString("data"));
                    final String pm25 = data.getString("pm25");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.d(TAG, "run: "+ msg);
                            if (msg.equals("Success !")) {
                                tv.setText(pm25);
                            }
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d(TAG, "onErrorResponse: "+volleyError.toString());
            }
        });
        //放入队列
        requestQueue.add(stringRequest);
        //队列运行
        requestQueue.start();
    }

}
