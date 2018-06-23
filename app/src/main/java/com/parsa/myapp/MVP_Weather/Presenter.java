package com.parsa.myapp.MVP_Weather;

import com.parsa.myapp.weather.pojo.Forecast;
import com.parsa.myapp.weather.pojo.YahooWeatherPojo;

/**
 * Created by hmd on 06/11/2018.
 */

public class Presenter implements Contract.Presenter {
    private Contract.View view;
    Model model=new Model();

    @Override
    public void attachView(Contract.View view) {
        this.view = view;
        model.attachPresenter(this);
    }

    @Override
    public void searchByWord(String word) {
        model.search(word);
        view.onDataLoading();
    }

    @Override
    public void receivedDataSuccess(YahooWeatherPojo yahoo) {
        view.showSuccessData(yahoo);
        view.onDataLoadingFinished();
    }

    @Override
    public void onFailure(String msg) {
        view.onFailure(msg);
        view.onDataLoadingFinished();
    }

    @Override
    public void onSelectForecast(Forecast forecast) {
        view.showForecastData(forecast);
    }
}
