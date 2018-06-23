package com.parsa.myapp.IMDB_MVP;


import com.parsa.myapp.MVP_IMDB.pojo.IMDBPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hmd on 06/11/2018.
 */

public interface IMDBWebInterFace {
    @GET("/")
    Call<IMDBPojo> searchInIMDB(@Query("t") String word,
                                @Query("apikey") String apikey);
}
