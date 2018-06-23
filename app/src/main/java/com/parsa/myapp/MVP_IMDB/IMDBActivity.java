package com.parsa.myapp.MVP_IMDB;

import android.app.ProgressDialog;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.parsa.myapp.MVP_IMDB.pojo.IMDBPojo;
import com.parsa.myapp.R;
import com.parsa.myapp.customViews.CustomEditText;
import com.parsa.myapp.utils.BaseActivity;
import com.parsa.myapp.utils.PublicMethods;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_imdb)
public class IMDBActivity extends BaseActivity implements IMDBContract.View {
    IMDBContract.Presenter presenter = new IMDBPresenter();
    @ViewById
    CustomEditText edtWord;
    @ViewById
    ImageView imgCover;
    @ViewById
    TextView txtResult;
    ProgressDialog dialog;

    @AfterViews
    void initViews() {
        presenter.attachView(this);
        dialog = new ProgressDialog(mContext);
        dialog.setTitle("Loading...");
        dialog.setMessage("Please wait");
    }

    @Click
    void btnSearch() {
        presenter.searchByWord(edtWord.text());
    }


    @Override
    public void showSuccessData(IMDBPojo serverResponse) {
        txtResult.setText(serverResponse.getTitle() + " " +
                serverResponse.getDirector());
//        Picasso.get().load(serverResponse.getPoster()).into(imgCover);
        Glide.with(mContext).load(serverResponse.getPoster()).into(imgCover);
        Log.e("img", "showSuccessData: img "+serverResponse.getPoster() );
    }

    @Override
    public void onFailure(String msg) {
        PublicMethods.showToast(mContext,msg);
    }

    @Override
    public void onDataLoading() {
        dialog.show();
    }

    @Override
    public void onDataLoadingFinished() {
        dialog.dismiss();
    }
}
