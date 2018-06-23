package com.parsa.myapp.Music.ListMusics;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.parsa.myapp.Music.ListMusics.PlayMusics.MusicPlayerService;
import com.parsa.myapp.Music.MusicPOJO;
import com.parsa.myapp.R;
import com.parsa.myapp.utils.BaseActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EActivity(R.layout.activity_music_list)
public class MusicListActivity extends BaseActivity implements MusicListContract.View {
    MusicListContract.Presenter presenter = new MusicListPresenter();
    MusicsListAdapter adapter;

    @ViewById
    ListView list;

    @AfterViews
    void init() {
        presenter.attachView(this);
    }

    @Override
    public void onLoadedMusics(List<MusicPOJO> musics) {
        adapter = new MusicsListAdapter(mContext, musics);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                MusicPOJO musicPOJO = (MusicPOJO) adapterView.getItemAtPosition(position);
                presenter.musicSelected(musicPOJO);
            }
        });
    }

    @Override
    public void playMusic(MusicPOJO musicPOJO) {
        Intent intent = new Intent(mContext, MusicPlayerService.class);
        intent.putExtra("music_id", musicPOJO.getId() + "");
        startService(intent);

        adapter.handleClick(musicPOJO);
    }
}
