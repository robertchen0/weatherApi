package com.example.weatherapi.ThreeHourWeather;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapi.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private ThreeHourWeather dataSet;

    public void setDataSet(ThreeHourWeather dataSet) {
        this.dataSet = dataSet;

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
        holder.bindItem(dataSet);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
