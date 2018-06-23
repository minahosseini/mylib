package com.parsa.myapp.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by hmd on 05/28/2018.
 */

public interface WebServices {

    @GET("json")
    Call<IPPojoModel> getIP();

    //path
   /* http://google.com/user/1
    @GET("user/{id}")
    Call<IPPojoModel>  getIP(@Path("id") String id);*/


    //query
   /* http://google.com/?username=ali&family=hasani
    @GET("")
    Call<IPPojoModel> get(@Query("username") String username,@Query("family") String family );*/
}
