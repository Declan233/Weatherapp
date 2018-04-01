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
import com.example.xiaochong.myapplication.entity.Data;
import com.example.xiaochong.myapplication.entity.Detail;
import com.example.xiaochong.myapplication.entity.Weather;
import com.example.xiaochong.myapplication.net.AppUrl;
import com.example.xiaochong.myapplication.net.MyNet;
import com.example.xiaochong.myapplication.net.Observe;
import com.example.xiaochong.myapplication.net.ParseData;
import com.google.gson.Gson;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //alt+enter 自动导包

    private ListView lv1;
    private ListAdapter d;
    private List<String> list = new ArrayList();
    private Button bt;
    private TextView tv1,tv2,tv3;
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

        editCity = (EditText) findViewById(R.id.et1);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        lv1 = findViewById(R.id.listview);

        d = new ListAdapter(MainActivity.this, list);
        //listview绑定适配器
        lv1.setAdapter(d);

        bt = (Button) findViewById(R.id.bt_weather);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();//获取接口数据
            }
        });

    }


    void initData(JSONArray jsonArray){
        for (int i=0; i<5; i++){
            try {
                String date = jsonArray.getJSONObject(i).getString("date");
                String sunrise = jsonArray.getJSONObject(i).getString("sunrise");
                String high = jsonArray.getJSONObject(i).getString("high");
                String low = jsonArray.getJSONObject(i).getString("low");
                String sunset = jsonArray.getJSONObject(i).getString("sunset");
                String fx = jsonArray.getJSONObject(i).getString("fx");
                String fl = jsonArray.getJSONObject(i).getString("fl");
                String type = jsonArray.getJSONObject(i).getString("type");
                String notice = jsonArray.getJSONObject(i).getString("notice");
                String str = "日期："+date+"   天气类型："+type+" \n " +
                        "最高温："+high+"   最低温："+low+" \n " +
                        "日出：" +sunrise+ "   日落：" +sunset+ " \n " +
                        "风力："+fl+"    风向"+fx+" \n " +
                        "温馨提示："+notice;
                list.add(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    void initData2(Data d){
        for (int i=0; i<5; i++){
            List<Detail> dt = d.getForecast();
            list.add(dt.get(i).toString());
        }
    }
    private void getData() {
        //获取用户输入框的值
        final String city = editCity.getText().toString().trim();
        if (city.isEmpty()){
            Log.d(TAG, "getData: 输入为空");
            return;
        }
        MyNet.requestGet(this, AppUrl.getUrl(city), new Observe() {
            @Override
            public void onSuccess(String response) {
                Log.d(TAG, "onSuccess: "+response);
                String message = ParseData.parseString(response,"message");
                if(!message.equals("Success !")){
                    return;
                }

//                //解析基本数据类型（封装）
//                String date = ParseData.parseString(response,"date");
//
//                tv1.setText(city+" "+date+" 天气");
//
//                //解析对象中的对象属性
//
//                JSONObject data = ParseData.parseObject(response,"data");
//                String shidu =   data.optString("shidu");
//                double pm25 =  data.optInt("pm25");
//                String quality =  data.optString("quality");
//                String wendu =  data.optString("wendu");
//                String ganmao =  data.optString("ganmao");

//              Gson解析
                Gson gson = new Gson();
                Weather w = gson.fromJson(response,Weather.class);
                tv1.setText(city+" "+w.getDate()+" 天气");
                Data d = w.getData();

                tv2.setText(d.toString());


//                tv2.setText(" 温度："+wendu+"  \n" +
//                        " 湿度："+shidu+"  \n " +
//                        " PM 2.5："+pm25+"  \n " +
//                        " 空气质量："+quality+"  \n " +
//                        " 建议："+ganmao);
                //解析对象中数组对象
                tv3.setText(city+" 最近5日天气预报：");

//                JSONArray array = ParseData.parseObjectArray(data,"forecast");

//                initData(array);
                initData2(d);
            }

            @Override
            public void onError(VolleyError ve) {
                Log.d(TAG, "onError: "+city+"  "+ve.toString());
            }
        });
    }
}
