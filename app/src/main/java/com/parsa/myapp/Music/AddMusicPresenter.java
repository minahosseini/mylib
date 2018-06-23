package com.parsa.myapp.Music;

/**
 * Created by hmd on 06/21/2018.
 */

public class AddMusicPresenter implements AddMusicContract.Presenter {
    private AddMusicContract.View view;
    AddMusicContract.Model model=new AddMusicModel();

    @Override
    public void attachView(AddMusicContract.View view) {
        this.view = view;
        model.attachPresenter(this);
    }

    @Override
    public void addMusic(MusicPOJO musicPOJO) {
        model.addMusic(musicPOJO);
    }

    @Override
    public void afterSave() {
        view.afterSave();
    }

    @Override
    public void list() {
        view.showListPage();
    }
}
