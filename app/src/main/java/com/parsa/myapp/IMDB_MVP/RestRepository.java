package com.parsa.myapp.IMDB_MVP;

import com.parsa.myapp.MVP_IMDB.pojo.IMDBPojo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hmd on 06/14/2018.
 */

public class RestRepository implements ModelRepository.Rest{

    private Model model;

    @Override
    public void attachModel(Model model) {
        this.model = model;
    }

    @Override
    public void getData(final String word) {
        API.getClient().create(IMDBWebInterFace.class).searchInIMDB(word,"70ad462a").enqueue(new Callback<IMDBPojo>() {
            @Override
            public void onResponse(Call<IMDBPojo> call, Response<IMDBPojo> response) {
                model.onReceivedData(response.body(),RepoType.Rest);
            }

            @Override
            public void onFailure(Call<IMDBPojo> call, Throwable t) {
                model.onFailed(word,RepoType.Rest);
            }
        });
    }
}
