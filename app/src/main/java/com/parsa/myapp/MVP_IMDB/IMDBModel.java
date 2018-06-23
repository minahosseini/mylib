package com.parsa.myapp.MVP_IMDB;

import com.parsa.myapp.MVP_IMDB.pojo.IMDBPojo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hmd on 06/11/2018.
 */

public class IMDBModel implements IMDBContract.Model {
    private IMDBContract.Presenter presenter;

    @Override
    public void attachPresenter(IMDBContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void search(String word) {
        API.getClient().create(IMDBWebInterFace.class)
                .searchInIMDB(word,"70ad462a").enqueue(new Callback<IMDBPojo>() {
            @Override
            public void onResponse(Call<IMDBPojo> call, Response<IMDBPojo> response) {
                presenter.recievedDataSuccess(response.body());
            }

            @Override
            public void onFailure(Call<IMDBPojo> call, Throwable t) {
                presenter.onFailure(t.toString());
            }
        });

    }
}
