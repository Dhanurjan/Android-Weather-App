package com.dhanurjan.weather.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Coord{

    @SerializedName("lon")
    String lon;

    @SerializedName("lat")
    String lat;


    public String getLon() { return lon; }

    public void setLon(String lon) { this.lon = lon; }

    public String getLat() { return lat; }

    public void setLat(String lat) { this.lat = lat; }
}
