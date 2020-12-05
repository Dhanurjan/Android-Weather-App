package com.dhanurjan.weather.Retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {
    @SerializedName("wind")
    private Wind wind;

    @SerializedName("sys")
    private Sys sys;

    @SerializedName("coord")
    private Coord coord;

    @SerializedName("main")
    private Main main;

    @SerializedName("weather")
    private List<Weather> weatherList;
    public List<Weather> getWeatherList() { return weatherList; }
    public void setWeatherList(List<Weather> weatherList) { this.weatherList = weatherList; }

    public Wind getWind() { return wind; }
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Sys getSys() { return sys; }
    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Coord getCoord() {
        return coord;
    }
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Main getMain() {
        return main;
    }
    public void setMain(Main main) {
        this.main = main;
    }

}
