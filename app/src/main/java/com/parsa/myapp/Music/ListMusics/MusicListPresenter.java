package com.parsa.myapp.Music.ListMusics;

import com.parsa.myapp.Music.MusicPOJO;

import java.util.List;

/**
 * Created by hmd on 06/21/2018.
 */

public class MusicListPresenter implements MusicListContract.Presenter {
    private MusicListContract.View view;
    MusicListContract.Model model=new MusicListModel();

    @Override
    public void attachView(MusicListContract.View view) {
        this.view = view;
        model.attachPresenter(this);
        model.loadMusics();
    }

    @Override
    public void onLoadedMusics(List<MusicPOJO> musics) {
        view.onLoadedMusics(musics);
    }

    @Override
    public void musicSelected(MusicPOJO musicPOJO) {
        view.playMusic(musicPOJO);
    }
}
