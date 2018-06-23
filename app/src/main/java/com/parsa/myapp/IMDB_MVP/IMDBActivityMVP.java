package com.parsa.myapp.IMDB_MVP;

import android.widget.ImageView;
import android.widget.TextView;
import com.parsa.myapp.MVP_IMDB.pojo.IMDBPojo;
import com.parsa.myapp.R;
import com.parsa.myapp.customViews.CustomEditText;
import com.parsa.myapp.utils.BaseActivity;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_imdbmvp)
public class IMDBActivityMVP extends BaseActivity implements IMDBMVPContract.View {
    Presenter presenter = new Presenter();

    @ViewById
    CustomEditText edtWord;
    @ViewById
    ImageView imgCover;
    @ViewById
    TextView txtResult;

    @Click
    void btnSearch() {
        presenter.validateWord(edtWord.text());
    }

    @AfterViews
    void init() {
        presenter.attachView(this);
    }

    @Override
    public void onWordNull() {
        edtWord.setError("Field is empty");
    }

    @Override
    public void onSuccessSearch(IMDBPojo imdb) {
        showLoading(false);
    }

    @Override
    public void onFail(String msg) {
        showLoading(false);
    }

}
