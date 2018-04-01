package com.example.xiaochong.myapplication.entity;

import java.util.List;

/**
 * Created by xiaochong on 2018/4/1.
 */

public class Data {
    private String shidu;
    private int pm25;
    private int pm10;
    private String quality;
    private String wendu;
    private String ganmao;
    private Detail yesterday;
    private List<Detail> forecast;



    public String getShidu() {
        return shidu;
    }

    public void setShidu(String shidu) {
        this.shidu = shidu;
    }

    public int getPm25() {
        return pm25;
    }

    public void setPm25(int pm25) {
        this.pm25 = pm25;
    }

    public int getPm10() {
        return pm10;
    }

    public void setPm10(int pm10) {
        this.pm10 = pm10;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public Detail getYesterday() {
        return yesterday;
    }

    public void setYesterday(Detail yesterday) {
        this.yesterday = yesterday;
    }

    public List<Detail> getForecast() {
        return forecast;
    }

    public void setForecast(List<Detail> forecast) {
        this.forecast = forecast;
    }



    public String toString(){
        String str = "";
        str += " 温度："+this.getWendu()+"  \n" +
                " 湿度："+this.getShidu()+"  \n " +
                " PM 2.5："+this.getPm25()+"  \n " +
                " 空气质量："+this.getQuality()+"  \n " +
                " 建议："+this.getGanmao();
        return str;
    }


}


