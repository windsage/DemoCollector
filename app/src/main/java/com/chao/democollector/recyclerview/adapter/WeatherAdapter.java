package com.chao.democollector.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chao.democollector.R;

import java.util.List;

/**
 * Created by Jeffery on 2017/9/6.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    private List<String> cityList;


    private LayoutInflater mInflater;

    private OnItemClickListener mItemClickListener;

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(TextView text, int position);

        void onItemLongClick(View view, int position);
    }

    public WeatherAdapter(Context ctx, List<String> cityList) {
        this.cityList = cityList;
        mInflater = LayoutInflater.from(ctx);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_weather, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.cityName.setText(cityList.get(position));
        holder.cityName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(holder.cityName, holder.getLayoutPosition());
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemLongClick(holder.itemView, holder.getLayoutPosition());
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return cityList == null ? 0 : cityList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView cityName;
        TextView cityWeather;

        ViewHolder(View itemView) {
            super(itemView);
            cityName = itemView.findViewById(R.id.cityName);
            cityWeather = itemView.findViewById(R.id.cityWeather);
        }
    }
}
