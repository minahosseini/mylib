package com.parsa.myapp.Music.ListMusics.PlayMusics;

import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.parsa.myapp.Music.MusicPOJO;
import com.parsa.myapp.R;
import com.parsa.myapp.customViews.CustomImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@EActivity(R.layout.activity_detail_music)
public class DetailMusicActivity extends AppCompatActivity {
    @ViewById
    CustomImageView cover;
    @ViewById
    TextView title;
    @ViewById
    TextView album;
    @ViewById
    ProgressBar progress;

    @AfterViews
    void init() {
        if (getIntent().hasExtra("cover"))
            cover.load(getIntent().getStringExtra("cover"));
    }

    @Subscribe
    public void onMusicPlaying(MusicPOJO musicPOJO) {
        title.setText(musicPOJO.getTitle());
        album.setText(musicPOJO.getAlbum());
        progress.setProgress(musicPOJO.getPercent());
        cover.load(musicPOJO.getCover());
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }
}
