package com.example.xiaochong.myapplication.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.xiaochong.myapplication.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecycleActivity extends AppCompatActivity {


    @Bind(R.id.rcv)
    RecyclerView rcv;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle);
        ButterKnife.bind(this);
    }

}
