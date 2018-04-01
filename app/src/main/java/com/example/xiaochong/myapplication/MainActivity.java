package com.example.xiaochong.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.xiaochong.myapplication.Adpter.ListAdapter;
import com.example.xiaochong.myapplication.net.AppUrl;
import com.example.xiaochong.myapplication.net.MyNet;
import com.example.xiaochong.myapplication.net.Observe;
import com.example.xiaochong.myapplication.net.ParseData;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //alt+enter 自动导包

    private ListView lv1;
    private ListAdapter d;
    private List list = new ArrayList();
    private Button bt;
    private TextView tvShow;
    private EditText editCity;
//    command+j     tagt
    private  static  final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    private void init() {
        lv1 = findViewById(R.id.listview);
        d = new ListAdapter(MainActivity.this, list);
        //listview绑定适配器
        lv1.setAdapter(d);
        tvShow = (TextView) findViewById(R.id.tv1);
        editCity = (EditText) findViewById(R.id.et1);

        bt = (Button) findViewById(R.id.bt_weather);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();//获取接口数据
            }
        });

    }


    void initData(){
        for (int i=1; i<=10; i++){
            list.add("name"+i);
        }
    }

    private void getData() {
        //获取用户输入框的值
        String city = editCity.getText().toString().trim();
        Log.d(TAG, "getData: city---"+city);
        if (city.isEmpty()){
            Log.d(TAG, "getData: 输入为空");
            return;
        }
        // String url= AppUrl.getUrl(city);//获取我们的接口url
        MyNet.requestGet(this, AppUrl.getUrl(city), new Observe() {
            @Override
            public void onSuccess(String response) {
                Log.d(TAG, "onSuccess: "+response);
                //解析基本数据类型（封装）
                String date = ParseData.parseString(response,"date");
                String message = ParseData.parseString(response,"messsage");
                int status = ParseData.parseInt(response,"status");

                //解析对象中的对象属性
                JSONObject data = ParseData.parseObject(response,"data");
                String shudu =   data.optString("shidu");
                String quality =  data.optString("quality");
                //解析对象中数组对象
                JSONArray  array = ParseData.parseObjectArray(data,"forecast");
                String high =   array.optJSONObject(0).optString("high");


                initData();
            }

            @Override
            public void onError(VolleyError ve) {
                Log.d(TAG, "onError: "+ve.toString());
            }
        });
    }

}
