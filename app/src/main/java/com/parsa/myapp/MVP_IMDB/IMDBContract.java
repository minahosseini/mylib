package com.parsa.myapp.MVP_IMDB;

import com.parsa.myapp.MVP_IMDB.pojo.IMDBPojo;

/**
 * Created by hmd on 06/11/2018.
 */

public interface IMDBContract {
    interface View {
        void showSuccessData(IMDBPojo result);
        void onFailure(String msg);
        void onDataLoading();
        void onDataLoadingFinished();
    }

    interface Presenter {
        void attachView(View view);
        void searchByWord(String word);
        void recievedDataSuccess(IMDBPojo result);
        void onFailure(String msg);
    }

    interface Model {
        void attachPresenter(Presenter presenter);
        void search(String word);
    }
}
