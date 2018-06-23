
package com.parsa.myapp.weather.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YahooWeatherPojo {

    @SerializedName("query")
    @Expose
    private Query query;

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

}
