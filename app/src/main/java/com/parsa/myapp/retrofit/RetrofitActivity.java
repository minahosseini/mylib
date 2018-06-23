package com.parsa.myapp.retrofit;

import android.os.Bundle;
import android.widget.TextView;

import com.parsa.myapp.R;
import com.parsa.myapp.utils.BaseActivity;
import com.parsa.myapp.utils.PublicMethods;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


//site amoozeshe retfrofit >>> https://futurestud.io

public class RetrofitActivity extends BaseActivity {
    TextView txtResult;
    private IPPojoModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        txtResult = findViewById(R.id.txtResult);


        //ba enqueue web service dar background thread call mishe va javab barmigarde be UI thread
        API.getClient().create(WebServices.class).getIP().enqueue(new Callback<IPPojoModel>() {
            @Override
            public void onResponse(Call<IPPojoModel> call, Response<IPPojoModel> response) {
                IPPojoModel model = response.body();
                txtResult.setText(model.getCountry() + " " + model.getCity() + " " + model.getIsp());
            }
            @Override
            public void onFailure(Call<IPPojoModel> call, Throwable t) {
                PublicMethods.showToast(mContext, t.toString());
            }
        });


        //ba execute web service dar background thread call mishe va javab bar nemigarde dar UI thread
        // agar bekhahim javab be UI thread bargarde bayad az runOnUiThread estefade konim.
       /* new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //call inside background thread
                    model = API.getClient().create(WebServices.class).getIP().execute().body();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //call inside UI thread
                            txtResult.setText(model.getCountry() + " " + model.getCity() + " " + model.getIsp());
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/


        //path
       /* API.getClient().create(WebServices.class).getIP("274827").enqueue(new Callback<IPPojoModel>() {
            @Override
            public void onResponse(Call<IPPojoModel> call, Response<IPPojoModel> response) {
                IPPojoModel model = response.body();
                txtResult.setText(model.getCountry() + " " + model.getCity() + " " + model.getIsp());
            }
            @Override
            public void onFailure(Call<IPPojoModel> call, Throwable t) {
                PublicMethods.showToast(mContext, t.toString());
            }
        });*/


        //query
      /*  API.getClient().create(WebServices.class).get("ali","hashemi").enqueue(new Callback<IPPojoModel>() {
            @Override
            public void onResponse(Call<IPPojoModel> call, Response<IPPojoModel> response) {
            }
            @Override
            public void onFailure(Call<IPPojoModel> call, Throwable t) {
            }
        });*/


    }
}
