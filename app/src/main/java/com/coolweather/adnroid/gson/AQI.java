package com.coolweather.adnroid.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wu on 2017/4/14.
 */
public class AQI {

    public City city;
    public class City {
        public String aqi;
        public String pm25;
    }
}
