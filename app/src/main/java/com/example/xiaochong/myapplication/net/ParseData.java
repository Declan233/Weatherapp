package com.example.xiaochong.myapplication.net;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class ParseData {
    /**
     * 方法：解析字符串
     *
     * @param response:相应的数据
     * @param key            返回数据的字段
     * @return 返回字段value值
     */
    public static String parseString(String response, String key) {
        String value = "";
        try {
            JSONObject object = new JSONObject(response);
            value = object.optString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 解析int数据
     *
     * @param response
     * @param key
     * @return
     */
    public static int parseInt(String response, String key) {
        int value = -1;
        try {
            JSONObject object = new JSONObject(response);
            value = object.optInt(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 解析布尔类型的方法
     *
     * @param response
     * @param key
     * @return
     */
    public static boolean parseBoolean(String response, String key) {
        Boolean value = false;
        try {
            JSONObject object = new JSONObject(response);
            value = object.optBoolean(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 解析对象中的对象
     * @param response
     * @param key
     * @return
     */
    public static JSONObject parseObject(String response, String key){
        JSONObject jobject = null;
        try {
            JSONObject object = new JSONObject(response);
            jobject = object.optJSONObject(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jobject;
    }

    public static JSONArray parseObjectArray(JSONObject object, String key){
        JSONArray array = null;
        try {
            array  = object.getJSONArray(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return array;
    }
}
