package com.parsa.myapp.Music;

/**
 * Created by hmd on 06/21/2018.
 */

public interface AddMusicContract {
    interface View {
        void afterSave();
        void showListPage();
    }

    interface Presenter {
        void attachView(View view);
        void addMusic(MusicPOJO musicPOJO);
        void afterSave();
        void list();
    }

    interface Model {
        void attachPresenter(Presenter presenter);
        void addMusic(MusicPOJO musicPOJO);
    }
}
