package com.parsa.myapp.Music;

/**
 * Created by hmd on 06/21/2018.
 */

public class AddMusicModel implements AddMusicContract.Model {
    private AddMusicContract.Presenter presenter;

    @Override
    public void attachPresenter(AddMusicContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void addMusic(MusicPOJO musicPOJO) {
        musicPOJO.save();
        presenter.afterSave();
    }
}
