package com.dhanurjan.weather.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Sys {

    @SerializedName("country")
    String country;

    @SerializedName("sunrise")
    String sunrise;

    @SerializedName("sunset")
    String sunset;


    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public String getSunrise() { return sunrise; }

    public void setSunrise(String sunrise) { this.sunrise = sunrise; }

    public String getSunset() { return sunset; }

    public void setSunset(String sunset) { this.sunset = sunset; }
}
