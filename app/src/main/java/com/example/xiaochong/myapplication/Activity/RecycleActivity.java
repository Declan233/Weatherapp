package com.example.xiaochong.myapplication.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.VolleyError;
import com.example.xiaochong.myapplication.Adpter.MyBaseAdapter;
import com.example.xiaochong.myapplication.R;
import com.example.xiaochong.myapplication.entity.Detail;
import com.example.xiaochong.myapplication.entity.Weather;
import com.example.xiaochong.myapplication.net.AppUrl;
import com.example.xiaochong.myapplication.net.MyNet;
import com.example.xiaochong.myapplication.net.Observe;
import com.example.xiaochong.myapplication.net.ParseData;
import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecycleActivity extends AppCompatActivity {


    @Bind(R.id.rcv)
    RecyclerView rcv;

    Weather w;
    List<String> list = new ArrayList<>();

    private static final String TAG = "RecycleActivity";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle);
        ButterKnife.bind(this);
        init();
    }


    public void initData(List<Detail> d){
        for(int i=0;i<d.size();i++){
            list.add(d.get(i).toString());
        }

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rcv.setLayoutManager(llm);
        Log.d(TAG, "init: 数据"+list.size());

        MyBaseAdapter mba = new MyBaseAdapter(list);

        rcv.setAdapter(mba);

    }

    public void init(){



        final String city = "重庆";
        MyNet.requestGet(this, AppUrl.getUrl(city), new Observe() {
            @Override
            public void onSuccess(String response) {
                Log.d(TAG, "onSuccess: " + response);
                String message = ParseData.parseString(response, "message");
                if (!message.equals("Success !")) {
                    return;
                }
                Gson gson = new Gson();
                w = gson.fromJson(response, Weather.class);
                initData(w.getData().getForecast());
            }

            @Override
            public void onError(VolleyError ve) {
                Log.d(TAG, "onError: " + city + "  " + ve.toString());
            }
        });


    }

}
