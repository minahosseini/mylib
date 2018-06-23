package com.parsa.myapp.MVP_Weather;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parsa.myapp.R;
import com.parsa.myapp.customViews.CustomEditText;
import com.parsa.myapp.utils.BaseActivity;
import com.parsa.myapp.utils.PublicMethods;
import com.parsa.myapp.weather.pojo.Forecast;
import com.parsa.myapp.weather.pojo.YahooWeatherPojo;

public class WeatherActivityMVP extends BaseActivity implements Contract.View, View.OnClickListener, OnItemClick {
    TextView result;
    RecyclerView forecasts;
    Button search;
    CustomEditText edtCityName;
    Contract.Presenter presenter = new Presenter();
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_mvp);
        bind();
        presenter.attachView(this);
        dialog = new ProgressDialog(mContext);
        dialog.setTitle("Loading...");
        dialog.setMessage("Please wait");
    }

    private void bind() {
        result = findViewById(R.id.result);
        forecasts = findViewById(R.id.forecasts);
        search = findViewById(R.id.search);
        edtCityName = findViewById(R.id.edtCityName);
        search.setOnClickListener(this);
    }

    @Override
    public void showSuccessData(YahooWeatherPojo yahoo) {
        WeatherMVPAdapter adapter = new WeatherMVPAdapter(mContext, yahoo.getQuery().getResults().getChannel().getItem().getForecast());
        forecasts.setAdapter(adapter);
        adapter.setOnItemClick(this);
    }

    @Override
    public void onItemClick(Forecast forecast) {
        presenter.onSelectForecast(forecast);
    }

    @Override
    public void onFailure(String msg) {
        PublicMethods.showToast(mContext, msg);
    }

    @Override
    public void onDataLoading() {
        dialog.show();
    }

    @Override
    public void onDataLoadingFinished() {
        dialog.dismiss();
    }

    @Override
    public void showForecastData(Forecast forecast) {
        PublicMethods.showToast(mContext,forecast.getDay()+" "+forecast.getText());
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search:
                presenter.searchByWord(edtCityName.text());
                break;
        }

    }
}
