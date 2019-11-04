package com.example.weatherapi.ThreeHourWeather;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThreeHourWeather implements Parcelable
{

    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private Integer message;
    @SerializedName("cnt")
    @Expose
    private Integer cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<com.example.weatherapi.ThreeHourWeather.List> list = null;

    public final static Parcelable.Creator<ThreeHourWeather> CREATOR = new Creator<ThreeHourWeather>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ThreeHourWeather createFromParcel(Parcel in) {
            return new ThreeHourWeather(in);
        }

        public ThreeHourWeather[] newArray(int size) {
            return (new ThreeHourWeather[size]);
        }

    }
            ;

    protected ThreeHourWeather(Parcel in) {
        this.cod = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cnt = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.list, (com.example.weatherapi.ThreeHourWeather.List.class.getClassLoader()));
    }

    public ThreeHourWeather() {
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public java.util.List<com.example.weatherapi.ThreeHourWeather.List> getList() {
        return list;
    }

    public void setList(java.util.List<com.example.weatherapi.ThreeHourWeather.List> list) {
        this.list = list;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(cod);
        dest.writeValue(message);
        dest.writeValue(cnt);
        dest.writeList(list);

    }

    public int describeContents() {
        return 0;
    }

}

