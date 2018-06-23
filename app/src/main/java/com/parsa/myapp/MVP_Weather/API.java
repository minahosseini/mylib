package com.parsa.myapp.MVP_Weather;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hmd on 06/13/2018.
 */

public class API {
    public static String BASE_URL = "https://query.yahooapis.com/v1/public/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        //baraye log endakhtan retrofit baraye didane log log level ra ruye debug migozarim va okhttp ra search mikonim
        HttpLoggingInterceptor loggerInterceptorBody = new HttpLoggingInterceptor();
        loggerInterceptorBody.setLevel(HttpLoggingInterceptor.Level.BODY);

        HttpLoggingInterceptor loggerInterceptorHeader = new HttpLoggingInterceptor();
        loggerInterceptorHeader.setLevel(HttpLoggingInterceptor.Level.HEADERS);

        OkHttpClient client = (new okhttp3.OkHttpClient.Builder())
                .addInterceptor(loggerInterceptorBody)
                .addInterceptor(loggerInterceptorHeader).build();

        if (retrofit == null) {
            retrofit = (new Retrofit.Builder()).baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    //for RX
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
