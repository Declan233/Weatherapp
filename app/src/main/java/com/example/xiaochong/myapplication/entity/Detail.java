package com.example.xiaochong.myapplication.entity;

/**
 * Created by xiaochong on 2018/4/1.
 */

public class Detail {
    private String date;
    private String sunrise;
    private String high;
    private String low;
    private  String sunset;
    private int aqi;
    private String fx;
    private String fl;
    private String type;
    private String notice;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }


    public String toString(){
        String str = "";
        str += "日期："+this.getDate()+"   天气类型："+this.getType()+" \n " +
                "最高温："+this.getHigh()+"   最低温："+this.getLow()+" \n " +
                "日出：" +this.getSunrise()+ "   日落：" +this.getSunset()+ " \n " +
                "风力："+this.getFl()+"    风向"+this.getFx()+" \n " +
                "温馨提示："+this.getNotice();
        return str;
    }
}
