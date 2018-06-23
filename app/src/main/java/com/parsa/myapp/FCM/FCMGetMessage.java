package com.parsa.myapp.FCM;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by hmd on 06/16/2018.
 */

public class FCMGetMessage extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d("fcm_body", "Message data payload: " + remoteMessage.getNotification().getBody());
        Log.d("fcm_title", "Message data payload: " + remoteMessage.getNotification().getTitle());

        if (remoteMessage.getData().size() > 0) {
            Log.d("fcm_", "Message data payload: " + remoteMessage.getData());

        }
    }
}
