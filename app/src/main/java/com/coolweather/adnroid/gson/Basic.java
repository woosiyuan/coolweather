package com.coolweather.adnroid.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wu on 2017/4/14.
 */
public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
