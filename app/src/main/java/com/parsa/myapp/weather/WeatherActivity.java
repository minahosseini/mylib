package com.parsa.myapp.weather;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;
import com.parsa.myapp.R;
import com.parsa.myapp.customViews.CustomEditText;
import com.parsa.myapp.utils.BaseActivity;
import com.parsa.myapp.utils.PublicMethods;
import com.parsa.myapp.weather.pojo.YahooWeatherPojo;

import cz.msebera.android.httpclient.Header;

public class WeatherActivity extends BaseActivity implements View.OnClickListener {

    CustomEditText edtCityName;
    TextView txtResult;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        bind();

    }

    private void bind() {
        edtCityName = findViewById(R.id.edtCityName);
        txtResult = findViewById(R.id.txtResult);
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setTitle("Waiting");
        progressDialog.setMessage("Please wait to load response");
        findViewById(R.id.btnShow).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnShow)
            getWeather(edtCityName.text());

    }

    private void getWeather(String cityName) {
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        String url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22" + cityName + "%2C%20ir%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";

        asyncHttpClient.get(url, new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                super.onStart();
                progressDialog.show();
            }

            @Override
            public void onFinish() {
                super.onFinish();
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                PublicMethods.showToast(mContext, throwable.toString());
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                parseResponse(responseString);
            }
        });
    }

    void parseResponse(String response) {
        Gson gson = new Gson();
        YahooWeatherPojo yahooWeatherPojo = gson.fromJson(response, YahooWeatherPojo.class);
        txtResult.setText(edtCityName.text() + " : " + yahooWeatherPojo.getQuery().getResults().getChannel().getItem().getCondition().getTemp() + " F ");

    }
}
