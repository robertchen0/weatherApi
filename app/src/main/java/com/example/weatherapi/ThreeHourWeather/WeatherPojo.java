package com.example.weatherapi.ThreeHourWeather;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class WeatherPojo implements Parcelable {

    private List<ItemDetails> items;

    public WeatherPojo(){

    }

    protected WeatherPojo(Parcel in) {
    }

    public static final Creator<WeatherPojo> CREATOR = new Creator<WeatherPojo>() {
        @Override
        public WeatherPojo createFromParcel(Parcel in) {
            return new WeatherPojo(in);
        }

        @Override
        public WeatherPojo[] newArray(int size) {
            return new WeatherPojo[size];
        }
    };

    public List<ItemDetails> getItems() {
        return items;
    }

    public void setItems(List<ItemDetails> items) {
        this.items = items;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(items);
    }
}
