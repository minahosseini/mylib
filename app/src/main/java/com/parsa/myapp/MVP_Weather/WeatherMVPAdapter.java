package com.parsa.myapp.MVP_Weather;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.parsa.myapp.R;
import com.parsa.myapp.weather.pojo.Forecast;
import java.util.List;

/**
 * Created by hmd on 06/13/2018.
 */

public class WeatherMVPAdapter extends RecyclerView.Adapter<WeatherMVPAdapter.Holder> {
    Context mContext;
    List<Forecast> forecasts;

    public WeatherMVPAdapter(Context mContext, List<Forecast> forecasts) {
        this.mContext = mContext;
        this.forecasts = forecasts;
    }

    @Override
    public WeatherMVPAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.forecast_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherMVPAdapter.Holder holder, int position) {
        holder.day.setText(forecasts.get(position).getDay());
        holder.high.setText(forecasts.get(position).getHigh());
        holder.low.setText(forecasts.get(position).getLow());
        holder.text.setText(forecasts.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return forecasts.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView day, high, low,text;
        public Holder(View itemView) {
            super(itemView);
            day=itemView.findViewById(R.id.day);
            high=itemView.findViewById(R.id.high);
            low=itemView.findViewById(R.id.low);
            text=itemView.findViewById(R.id.text);
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClick.onItemClick(forecasts.get(getAdapterPosition()));
                }
            });
        }
    }

    OnItemClick onItemClick;
    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
