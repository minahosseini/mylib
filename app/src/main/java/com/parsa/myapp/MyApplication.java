package com.parsa.myapp;

import android.app.Application;

import com.google.firebase.messaging.FirebaseMessaging;
import com.orhanobut.hawk.Hawk;
import com.orm.SugarApp;
import com.parsa.myapp.FCM.FCMGetToken;

/**
 * Created by hmd on 06/16/2018.
 */

public class MyApplication extends SugarApp {
    @Override
    public void onCreate() {
        super.onCreate();
        Hawk.init(this).build();
        FCMGetToken fcmGetToken=new FCMGetToken();
        FirebaseMessaging.getInstance().subscribeToTopic("news");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}

