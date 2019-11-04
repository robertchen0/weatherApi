package com.example.weatherapi;

import com.example.weatherapi.CurrentWeatherClass.WeatherItemDetails;
import com.example.weatherapi.ThreeHourWeather.ThreeHourWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    // api.openweathermap.org/data/2.5/weather?zip={zip code},{country code}

    @GET("data/2.5/weather/")
    Call<WeatherItemDetails> getCurrentWeather(
            @Query("zip") String zip,
            @Query("units") String units,
            @Query("appid") String key);

    // api.openweathermap.org/data/2.5/forecast?zip={zip code},{country code}

    @GET("data/2.5/forecast/")
    Call<ThreeHourWeather> getThreeHourWeather(
            @Query("zip") String zip,
            @Query("units") String units,
            @Query("appid") String key);

}
