package com.example.xiaochong.myapplication.net;


import java.io.UnsupportedEncodingException;

public class AppUrl {
    public static String  baseUrl="https://www.sojson.com/open/api/weather/json.shtml?city=";

    public static String getUrl(String city){
        String c = null;
        try {
            c = java.net.URLEncoder.encode(city, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String apiUrl = String.format("https://www.sojson.com/open/api/weather/json.shtml?city=%s",c);
        return apiUrl;
    }
}
