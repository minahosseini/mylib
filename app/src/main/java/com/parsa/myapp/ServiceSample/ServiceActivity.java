package com.parsa.myapp.ServiceSample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.parsa.myapp.R;
import com.parsa.myapp.utils.BaseActivity;

public class ServiceActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sampleService = new Intent(mContext, SampleService.class);
                //ya be in shekl be service data mifrestim ya be shekl zir
               /* Bundle b=new Bundle();
                b.putString("name","amir");
                sampleService.putExtra("data",b);*/
                sampleService.putExtra("url", "urllll");
                startService(sampleService);
            }
        });
    }
}
