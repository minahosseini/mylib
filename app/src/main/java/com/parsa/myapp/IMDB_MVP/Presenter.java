package com.parsa.myapp.IMDB_MVP;

import com.parsa.myapp.MVP_IMDB.pojo.IMDBPojo;

/**
 * Created by hmd on 06/14/2018.
 */

public class Presenter implements IMDBMVPContract.Presenter {

    private IMDBMVPContract.View view;
    Model model=new Model();

    @Override
    public void attachView(IMDBMVPContract.View view) {
        this.view = view;
        model.attachPresenter(this);
    }

    @Override
    public void search(String word) {
        view.showLoading(true);
        model.search(word);
    }

    @Override
    public void onSuccessSearch(IMDBPojo imdb) {
        view.showLoading(false);
        view.onSuccessSearch(imdb);
    }

    @Override
    public void onFail(String msg) {
        view.showLoading(false);
        view.onFail(msg);
    }

    @Override
    public void validateWord(String word) {
        if (word != null)
            search(word);
        else
            view.onWordNull();
    }
}