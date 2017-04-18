package com.coolweather.adnroid.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wu on 2017/4/14.
 */
public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{
        @SerializedName("txt")
        public String info;
    }
}
