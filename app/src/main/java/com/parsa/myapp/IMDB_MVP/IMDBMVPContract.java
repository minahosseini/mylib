package com.parsa.myapp.IMDB_MVP;

import com.parsa.myapp.MVP_IMDB.pojo.IMDBPojo;

/**
 * Created by hmd on 06/14/2018.
 */

public interface IMDBMVPContract {
    interface View {
        void onWordNull();
        void onSuccessSearch(IMDBPojo imdb);
        void onFail(String msg);
        void showLoading(Boolean show);
    }

    interface Presenter {
        void attachView(View view);
        void search(String word);
        void onSuccessSearch(IMDBPojo imdb);
        void onFail(String msg);
        void validateWord(String word);
    }

    interface Model {
        void attachPresenter(Presenter presenter);
        void search(String word);
        void onReceivedData(IMDBPojo imdb,RepoType type);
        void onFailed(String word,RepoType type);
    }
}
