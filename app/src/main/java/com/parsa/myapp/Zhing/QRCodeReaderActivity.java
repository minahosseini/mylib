package com.parsa.myapp.Zhing;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.parsa.myapp.R;
import com.parsa.myapp.utils.BaseActivity;
import com.parsa.mylib.PublicMethods;

public class QRCodeReaderActivity extends BaseActivity implements View.OnClickListener {

    TextView resultValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_reader);
        getPermission();
        findViewById(R.id.read).setOnClickListener(this);
        resultValue = findViewById(R.id.resultValue);
        PublicMethods.toast(mContext,"hi");
    }

    void getPermission() {
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(mActivity,
                    new String[]{Manifest.permission.CAMERA},
                    1500);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            resultValue.setText(result.getContents());
        } else {
            PublicMethods.toast(mContext, "result is null");
        }
    }

    @Override
    public void onClick(View view) {
        new IntentIntegrator(this).initiateScan();
    }
}
