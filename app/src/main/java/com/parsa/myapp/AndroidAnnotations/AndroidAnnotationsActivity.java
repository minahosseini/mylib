package com.parsa.myapp.AndroidAnnotations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.parsa.myapp.R;
import com.parsa.myapp.customViews.CustomEditText;
import com.parsa.myapp.utils.BaseActivity;
import com.parsa.myapp.utils.PublicMethods;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_android_annotations)
public class AndroidAnnotationsActivity extends BaseActivity {
    @ViewById
    CustomEditText edtUsername;

    @Click
    void btnShowToast() {
        PublicMethods.showToast(mContext, edtUsername.text());
    }


}
