package com.parsa.myapp.Music.ListMusics;

import com.parsa.myapp.utils.PublicMethods;

/**
 * Created by hmd on 06/21/2018.
 */

public class MusicListModel implements MusicListContract.Model {
    private MusicListContract.Presenter presenter;

    @Override
    public void attachPresenter(MusicListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loadMusics() {
        presenter.onLoadedMusics(PublicMethods.getMusics());
    }
}
