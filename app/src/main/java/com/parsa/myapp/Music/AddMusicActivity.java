package com.parsa.myapp.Music;

import com.parsa.myapp.Music.ListMusics.MusicListActivity_;
import com.parsa.myapp.R;
import com.parsa.myapp.customViews.CustomEditText;
import com.parsa.myapp.utils.BaseActivity;
import com.parsa.myapp.utils.PublicMethods;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_add_music)
public class AddMusicActivity extends BaseActivity implements AddMusicContract.View{
    @ViewById
    CustomEditText title;
    @ViewById
    CustomEditText singer;
    @ViewById
    CustomEditText album;
    @ViewById
    CustomEditText cover;
    @ViewById
    CustomEditText url;
    AddMusicContract.Presenter presenter=new AddMusicPresenter();

    @AfterViews
    void init(){
        presenter.attachView(this);
    }

    @Click
    void save(){
        MusicPOJO musicPOJO=MusicPOJO.newBuilder()
                .title(title.text())
                .singer(singer.text())
                .album(album.text())
                .cover(cover.text())
                .url(url.text())
                .build();
        presenter.addMusic(musicPOJO);
    }

    @Click
    void list(){
        presenter.list();
    }

    @Override
    public void afterSave() {
        clean();
        PublicMethods.showToast(mContext,"new music has been added.");
        PublicMethods.showToast(mContext,PublicMethods.getMusics().size()+"");
    }

    @Override
    public void showListPage() {
        MusicListActivity_.intent(mContext).start();
    }

    private void clean() {
        title.setText("");
        singer.setText("");
        album.setText("");
        cover.setText("");
        url.setText("");
    }
}
