package com.dhanurjan.weather.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("weather?APPID=76a35a17f3e1bce771a09f3555b614a8&units=metric")//http://api.openweathermap.org/data/2.5/weather?q=London&APPID=76a35a17f3e1bce771a09f3555b614a8
    Call<Example> getWeatherData(@Query("q") String name);


}
