package com.parsa.myapp.sampleMVP;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.parsa.myapp.R;
import com.parsa.myapp.customViews.CustomEditText;
import com.parsa.myapp.utils.PublicMethods;

public class SampleMVPActivity extends AppCompatActivity implements SampleMVPContract.View {

    CustomEditText edtName, edtFamily;
    SampleMVPPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_mvp);

        bindViews();
        presenter = new SampleMVPPresenter();
        presenter.attachView(this);
    }

    private void bindViews() {
        edtName = findViewById(R.id.edtName);
        edtFamily = findViewById(R.id.edtFamily);

        findViewById(R.id.btnShow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.recievedNameFamily(edtName.text(), edtFamily.text());
            }
        });
    }

    @Override
    public void onAgeRecieved(int age) {
        PublicMethods.showToast(this, "my age is: " + age);
    }
}
