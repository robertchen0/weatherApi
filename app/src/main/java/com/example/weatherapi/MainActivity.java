package com.example.weatherapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherapi.CurrentWeatherClass.WeatherItemDetails;
import com.example.weatherapi.ThreeHourWeather.ThreeHourWeather;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    TextView tv_current_city, tv_current_temp, tv_current_sky;
    LinearLayout linearLayout;
    SharedPreferences sharedPreferences;
    String zip;
    String api_key = "448d3758fc3d980204a08f0d2a5b6e7e";
    String units;
    String unit;

    Callback<ThreeHourWeather> callback1 = new Callback<ThreeHourWeather>() {
        @Override
        public void onResponse(Call<ThreeHourWeather> call, Response<ThreeHourWeather> response) {

        }

        @Override
        public void onFailure(Call<ThreeHourWeather> call, Throwable t) {
            System.out.println(t.getMessage());
            Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
        }
    };

    Callback<WeatherItemDetails> callback = new Callback<WeatherItemDetails>() {
        @Override
        public void onResponse(Call<WeatherItemDetails> call, Response<WeatherItemDetails> response) {

            if (response.body() == null) {
                tv_current_sky.setText("N/A");
                tv_current_temp.setText("N/A");
                tv_current_city.setText("N/A");
            } else {
                tv_current_city.setText(response.body().getName());
                tv_current_sky.setText(response.body().getWeather().get(0).getMain());

                if (response.body().getMain().getTemp() < 60) {
                    linearLayout.setBackgroundColor(Color.parseColor("#40d2ff"));
                }
                if (response.body().getMain().getTemp() >= 60) {
                    linearLayout.setBackgroundColor(Color.parseColor("#f59e42"));
                }
                if (units.equals("Fahrenheit")) {
                    tv_current_temp.setText(response.body().getMain().getTemp().toString() + "°F");
                }
                if (units.equals("Celsius")) {
                    tv_current_temp.setText(response.body().getMain().getTemp().toString() + "°C");
                }
            }
        }

        @Override
        public void onFailure(Call<WeatherItemDetails> call, Throwable t) {
            System.out.println(t.getMessage());
            Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);

        if (sharedPreferences.getString("zip", null) == null) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
        } else {
            sharedPreferences.getString("zip", null);
            sharedPreferences.getString("unit", null);

            tv_current_city = findViewById(R.id.tv_current_city);
            tv_current_temp = findViewById(R.id.tv_current_temp);
            tv_current_sky = findViewById(R.id.tv_current_sky);
            linearLayout = findViewById(R.id.current_weather);

            floatingActionButton = findViewById(R.id.floating_action_btn);
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                }
            });
            initNetworkCall();
            initNetworkCallThreeHour();
        }
    }

    public void initNetworkCall() {

        units = sharedPreferences.getString("unit", null);
        zip = sharedPreferences.getString("zip", null);

        if (units.equals("Fahrenheit")) {
            unit = "imperial";
        }
        if (units.equals("Celsius")) {
            unit = "metric";
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherApi weatherAPi = retrofit.create(WeatherApi.class);
        weatherAPi.getCurrentWeather(
                zip,
                unit,
                api_key)
                .enqueue(callback);
    }
    public void initNetworkCallThreeHour() {

        units = sharedPreferences.getString("unit", null);
        zip = sharedPreferences.getString("zip", null);

        if (units.equals("Fahrenheit")) {
            unit = "imperial";
        }
        if (units.equals("Celsius")) {
            unit = "metric";
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherApi weatherAPi = retrofit.create(WeatherApi.class);
        weatherAPi.getThreeHourWeather(
                zip,
                unit,
                api_key)
                .enqueue(callback1);
    }
}
