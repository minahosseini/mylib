package com.parsa.myapp.MVP_Weather;

import com.parsa.myapp.weather.pojo.Forecast;
import com.parsa.myapp.weather.pojo.YahooWeatherPojo;

/**
 * Created by hmd on 06/11/2018.
 */

public interface Contract {
    interface View {
        void showSuccessData(YahooWeatherPojo yahoo);

        void onFailure(String msg);

        void onDataLoading();

        void onDataLoadingFinished();

        void showForecastData(Forecast forecast);
    }

    interface Presenter {
        void attachView(View view);

        void searchByWord(String word);

        void receivedDataSuccess(YahooWeatherPojo yahoo);

        void onFailure(String msg);

        void onSelectForecast(Forecast forecast);
    }

    interface Model {
        void attachPresenter(Presenter presenter);

        void search(String word);
    }
}
