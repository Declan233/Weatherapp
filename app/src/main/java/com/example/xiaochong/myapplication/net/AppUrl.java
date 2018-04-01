package com.example.xiaochong.myapplication.net;



public class AppUrl {
    public static String  baseUrl="https://www.sojson.com/open/api/weather/json.shtml?city=";

    public static String getUrl(String city){
        return baseUrl+city;
    }
}
