package com.parsa.myapp.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public Context mContext;
    public Activity mActivity;
    public ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mActivity = this;

        dialog=new ProgressDialog(mContext);
        dialog.setMessage("Loading...");
        dialog.setMessage("Please wait");
    }

    public void showLoading(Boolean show) {
        if (show)
            dialog.show();
        else
            dialog.dismiss();
    }
}
