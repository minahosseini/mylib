package com.parsa.myapp.Music.ListMusics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.parsa.myapp.Music.ListMusics.PlayMusics.DetailMusicActivity_;
import com.parsa.myapp.Music.MusicPOJO;
import com.parsa.myapp.R;
import com.parsa.myapp.customViews.CustomImageView;

import java.util.List;

/**
 * Created by hmd on 06/21/2018.
 */

public class MusicsListAdapter extends BaseAdapter {
    Context mContext;
    List<MusicPOJO> musics;
    private CustomImageView cover;

    public MusicsListAdapter(Context mContext, List<MusicPOJO> musics) {
        this.mContext = mContext;
        this.musics = musics;
    }

    @Override
    public int getCount() {
        return musics.size();
    }

    @Override
    public Object getItem(int i) {
        return musics.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.music_list_item, viewGroup, false);
        TextView title = v.findViewById(R.id.title);
        title.setText(musics.get(i).getTitle());
        cover = v.findViewById(R.id.cover);
        cover.load(musics.get(i).getCover());
        return v;
    }

    public void handleClick(MusicPOJO musicPOJO) {
        Intent detail = new Intent(mContext, DetailMusicActivity_.class);
        detail.putExtra("cover", musicPOJO.getCover());
        Activity mActivity = (Activity)mContext ;
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity, cover, "img");

        mContext.startActivity(detail, options.toBundle());
    }
}
