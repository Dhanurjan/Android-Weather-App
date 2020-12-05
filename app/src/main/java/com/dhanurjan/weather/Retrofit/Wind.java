package com.dhanurjan.weather.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    String speed;

    public String getSpeed() {
        return speed;
    }
    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
