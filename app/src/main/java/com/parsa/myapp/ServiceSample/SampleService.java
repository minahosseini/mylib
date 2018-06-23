package com.parsa.myapp.ServiceSample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.parsa.myapp.utils.PublicMethods;

/**
 * Created by hmd on 06/15/2018.
 */
//http://www.tahlildadeh.com/ArticleDetails/%D8%A2%D9%85%D9%88%D8%B2%D8%B4-%D8%A7%DB%8C%D8%AC%D8%A7%D8%AF-%D9%88-%D8%A8%D9%87%D8%B1%D9%87-%DA%AF%DB%8C%D8%B1%DB%8C-%D8%A7%D8%B2-service-%D9%87%D8%A7-%D8%AF%D8%B1-%D8%A7%D9%86%D8%AF%D8%B1%D9%88%DB%8C%D8%AF-%D8%A2%D9%85%D9%88%D8%B2%D8%B4-%D8%A7%DB%8C%D8%AC%D8%A7%D8%AF-%D9%88-%D8%A8%D9%87%D8%B1%D9%87-%DA%AF%DB%8C%D8%B1%DB%8C-%D8%A7%D8%B2-%D8%B3%D8%B1%D9%88%DB%8C%D8%B3-%D9%87%D8%A7-%D8%AF%D8%B1-%D8%A7%D9%86%D8%AF%D8%B1%D9%88%DB%8C%D8%AF
public class SampleService extends Service {

    //aval onCreate farakhani mishavad bad onStartCommand
    // agar dobare ejra konim service ra agar service hanuz destroy nahsode bashad dige onCreate ejra nemishe va
    //faghat onStartCommand ejra mishe
    @Override
    public void onCreate() {
        super.onCreate();
        PublicMethods.showToast(this,"onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        PublicMethods.showToast(this,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);


        //intent ra migirad
    }

    //vaghti service tamam shod call mishe
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
