package com.example.weatherapi.ThreeHourWeather;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapi.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private ArrayList<List> dataSet;
    String icon;
    Long time;

    public CustomAdapter(ArrayList<List> data) {
        this.dataSet = data;
        System.out.println(data);
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        time = dataSet.get(position).getDt() * 1000;
        Date df = new java.util.Date(time);
        String vv = new SimpleDateFormat("MM dd, hh:mma").format(df);
        holder.tv_time.setText(vv);

        holder.tv_temp.setText(String.format("%.0f",(dataSet.get(position).getMain().getTemp()))+ "°");

        icon = dataSet.get(position).getWeather().get(0).getIcon();
        if(icon.equals("01d")){
            holder.iv_image.setImageResource(R.drawable.a01d2x);
        }
        if(icon.equals("01n")){
            holder.iv_image.setImageResource(R.drawable.a01n2x);
        }
        if(icon.equals("02d")){
            holder.iv_image.setImageResource(R.drawable.a02d2x);
        }
        if(icon.equals("02n")){
            holder.iv_image.setImageResource(R.drawable.a02n2x);
        }
        if(icon.equals("03d")){
            holder.iv_image.setImageResource(R.drawable.a03d2x);
        }
        if(icon.equals("03n")){
            holder.iv_image.setImageResource(R.drawable.a03n2x);
        }
        if(icon.equals("04d")){
            holder.iv_image.setImageResource(R.drawable.a04d2x);
        }
        if(icon.equals("04n")){
            holder.iv_image.setImageResource(R.drawable.a04n2x);
        }
        if(icon.equals("09d")){
            holder.iv_image.setImageResource(R.drawable.a09d2x);
        }
        if(icon.equals("09n")){
            holder.iv_image.setImageResource(R.drawable.a09n2x);
        }
        if(icon.equals("10d")){
            holder.iv_image.setImageResource(R.drawable.a10d2x);
        }
        if(icon.equals("10n")){
            holder.iv_image.setImageResource(R.drawable.a10n2x);
        }
        if(icon.equals("11d")){
            holder.iv_image.setImageResource(R.drawable.a11d2x);
        }
        if(icon.equals("11n")){
            holder.iv_image.setImageResource(R.drawable.a11n2x);
        }
        if(icon.equals("13d")){
            holder.iv_image.setImageResource(R.drawable.a13d2x);
        }
        if(icon.equals("13n")){
            holder.iv_image.setImageResource(R.drawable.a13n2x);
        }
        if(icon.equals("50d")){
            holder.iv_image.setImageResource(R.drawable.a50d2x);
        }
        if(icon.equals("50n")){
            holder.iv_image.setImageResource(R.drawable.a50n2x);
        }
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.size() : 0;
    }
}
