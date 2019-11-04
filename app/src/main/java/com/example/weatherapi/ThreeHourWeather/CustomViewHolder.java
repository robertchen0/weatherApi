package com.example.weatherapi.ThreeHourWeather;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapi.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    TextView tv_time, tv_temp;
    ImageView iv_image;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_temp = itemView.findViewById(R.id.tv_temp);
        tv_time = itemView.findViewById(R.id.tv_time);
        iv_image = itemView.findViewById(R.id.iv_weather_icon);
    }

    public void bindItem(final ThreeHourWeather item) {
        tv_temp.setText(Double.toString(item.getList().get(0).getMain().getTemp()));
        tv_time.setText(Long.toString(item.getList().get(0).getDt()));
        iv_image.setImageResource(R.drawable.a10d2x);
    }
}
