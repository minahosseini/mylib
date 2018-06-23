package com.parsa.myapp.MVP_Weather;

import android.util.Log;

import com.parsa.myapp.weather.pojo.YahooWeatherPojo;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hmd on 06/11/2018.
 */

public class Model implements Contract.Model {
    private Contract.Presenter presenter;

    @Override
    public void attachPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void search(String word) {
        String query = "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"%s , %s\" )";
        query = String.format(query, word, "ir");
      /*  API.getClient().create(YahooWInterface.class).getWeather(query, "json").enqueue(new Callback<YahooWeatherPojo>() {
            @Override
            public void onResponse(Call<YahooWeatherPojo> call, Response<YahooWeatherPojo> response) {
                Log.e("w_y", "onResponse: " + response.body().getQuery().getCount());
                presenter.receivedDataSuccess(response.body());
            }

            @Override
            public void onFailure(Call<YahooWeatherPojo> call, Throwable t) {
                Log.e("w_y", "onFailure: " + t.toString());
                presenter.onFailure(t.toString());
            }
        });*/

        API.getClient().create(YahooWInterface.class).getWeather(query, "json")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<YahooWeatherPojo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(YahooWeatherPojo weatherPojo) {
                        presenter.receivedDataSuccess(weatherPojo);
                    }

                    @Override
                    public void onError(Throwable e) {
                        presenter.onFailure(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
