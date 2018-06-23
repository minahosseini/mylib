package com.parsa.myapp.Music.ListMusics;

import com.parsa.myapp.Music.MusicPOJO;
import java.util.List;

/**
 * Created by hmd on 06/21/2018.
 */

public interface MusicListContract {
    interface View {
        void onLoadedMusics(List<MusicPOJO> musics);
        void playMusic(MusicPOJO musicPOJO);
    }

    interface Presenter {
        void attachView(View view);
        void onLoadedMusics(List<MusicPOJO> musics);
        void musicSelected(MusicPOJO musicPOJO);
    }

    interface Model {
        void attachPresenter(Presenter presenter);
        void loadMusics();
    }
}
