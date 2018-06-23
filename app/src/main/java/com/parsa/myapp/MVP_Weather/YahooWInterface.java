package com.parsa.myapp.MVP_Weather;

import com.parsa.myapp.weather.pojo.YahooWeatherPojo;
//hatman in Observable ra import mikonim
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hmd on 06/13/2018.
 */

public interface YahooWInterface {
    //dar RX Call ro Observable mikonim
    @GET("yql/")
    Observable<YahooWeatherPojo> getWeather(@Query("q") String query,
                                            @Query("format") String format);
}
