package com.example.weatherapi.ThreeHourWeather;

import android.os.Parcel;
import android.os.Parcelable;

class ItemDetails implements Parcelable {
    private ThreeHourWeather weatherInfo;

    public ThreeHourWeather getWeatherInfo() {
        return weatherInfo;
    }

    public void setWeatherInfo(ThreeHourWeather weatherInfo) {
        this.weatherInfo = weatherInfo;
    }

    public ItemDetails(){

    }

    protected ItemDetails(Parcel in) {
    }

    public static final Creator<ItemDetails> CREATOR = new Creator<ItemDetails>() {
        @Override
        public ItemDetails createFromParcel(Parcel in) {
            return new ItemDetails(in);
        }

        @Override
        public ItemDetails[] newArray(int size) {
            return new ItemDetails[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
