package com.parsa.myapp.MVP_IMDB;

import com.parsa.myapp.MVP_IMDB.pojo.IMDBPojo;

/**
 * Created by hmd on 06/11/2018.
 */

public class IMDBPresenter implements IMDBContract.Presenter{
    private IMDBContract.View view;
    IMDBContract.Model model=new IMDBModel();

    @Override
    public void attachView(IMDBContract.View view) {
        this.view = view;
        model.attachPresenter(this);
    }

    @Override
    public void searchByWord(String word) {
        model.search(word);
        view.onDataLoading();
    }

    @Override
    public void recievedDataSuccess(IMDBPojo result) {
        view.showSuccessData(result);
        view.onDataLoadingFinished();
    }

    @Override
    public void onFailure(String msg) {
        view.onFailure(msg);
        view.onDataLoadingFinished();
    }
}
