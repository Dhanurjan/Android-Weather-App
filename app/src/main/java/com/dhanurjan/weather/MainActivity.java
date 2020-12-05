package com.dhanurjan.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhanurjan.weather.Retrofit.ApiClient;
import com.dhanurjan.weather.Retrofit.ApiInterface;
import com.dhanurjan.weather.Retrofit.Example;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button searchBtn;
    TextView tempText , feelText , humidityText, lon, lat, country, sunrise, sunset, descText, windSpeed, pressure;
    EditText cityName;
    ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBtn = findViewById(R.id.searchBtn);
        tempText = findViewById(R.id.tempText);
        feelText = findViewById(R.id.feelText);
        humidityText = findViewById(R.id.humidityText);
        country = findViewById(R.id.country);
        sunrise = findViewById(R.id.sunrise);
        sunset = findViewById(R.id.sunset);
        lon = findViewById(R.id.lonText);
        lat = findViewById(R.id.latText);
        cityName = findViewById(R.id.cityName);
        descText = findViewById(R.id.descText);
        icon = findViewById(R.id.icon);
        windSpeed = findViewById(R.id.windSpeed);
        pressure = findViewById(R.id.pressure);


        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getWeatherData(cityName.getText().toString().trim());

            }
        });
    }

    private void getWeatherData(String name){

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        //String iconUrl = "http://openweathermap.org/img/wn/"+icon+"@2x.png";

        Call<Example> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                tempText.setText(response.body().getMain().getTemp()+" ℃");
                feelText.setText("Feels Like :"+" "+response.body().getMain().getFeels_like()+" ℃");
                lon.setText("Longitude :"+" "+response.body().getCoord().getLon()+" °E");
                lat.setText("Latitude :"+" "+response.body().getCoord().getLat()+" °N");
                humidityText.setText("Humidity :"+" "+response.body().getMain().getHumidity()+" %");
                country.setText(response.body().getSys().getCountry());
                sunrise.setText("Sunrise :"+" "+response.body().getSys().getSunrise()+" AM");
                sunset.setText("Sunset :"+" "+response.body().getSys().getSunset()+" PM");
                windSpeed.setText("Wind Speed :"+" "+response.body().getWind().getSpeed()+" km/h");
                descText.setText(response.body().getWeatherList().get(0).getDescription());
                pressure.setText("Pressure :"+" "+response.body().getMain().getPressure()+" hpa");
                //icon.setImageIcon(Icon.createWithContentUri(response.body().getWeatherList().get(0).getIcon()));

                //Picasso.get().load(iconUrl).into(icon);
                //Picasso.get().load("http://openweathermap.org/img/wn/10d@2x.png").into(icon);


            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });

    }
}
