package com.parsa.myapp.FCM;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.orhanobut.hawk.Hawk;

/**
 * Created by hmd on 06/16/2018.
 */

public class FCMGetToken extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Hawk.put("fcm_token", refreshedToken);
        Log.d("fcm_", "onTokenRefresh: " + refreshedToken);
    }
}
