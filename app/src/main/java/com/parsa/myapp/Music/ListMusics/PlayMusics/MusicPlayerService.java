package com.parsa.myapp.Music.ListMusics.PlayMusics;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.parsa.myapp.Music.ListMusics.MusicListActivity_;
import com.parsa.myapp.Music.MusicPOJO;
import com.parsa.myapp.R;
import com.parsa.myapp.utils.PublicMethods;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

//service dar main thread ejra mishe vali intent service dar yek thread dige ast
public class MusicPlayerService extends Service {
    MediaPlayer mediaPlayer;
    private NotificationManager mNotificationManager;
    private NotificationCompat.Builder mBuilder;
    private MusicPOJO music;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String musicId = intent.getStringExtra("music_id");
        music = PublicMethods.getMusicById(musicId);
        PublicMethods.showToast(this, music.toString());
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            mediaPlayer = new MediaPlayer();
        }

        try {
            mediaPlayer.setDataSource(music.getUrl());
            mediaPlayer.prepare();
            mediaPlayer.start();
            showNotification(music);
            timer();
        } catch (IOException e) {

        }


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    public void timer() {
        int duration = mediaPlayer.getDuration();
        int currentPosition = mediaPlayer.getCurrentPosition();
        int percentage = (int) (currentPosition * 100.0 / duration + 0.5);

        mBuilder.setProgress(100, percentage, false);
        mNotificationManager.notify(0, mBuilder.build());

        music.setPercent(percentage);
        EventBus.getDefault().post(music);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //bad az 1s dobare khodash ra call mikonad
                timer();
            }
        }, 1000);
    }

    void showNotification(MusicPOJO musicPOJO) {
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("default",
                    "Music player",
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Music player");
            mNotificationManager.createNotificationChannel(channel);
            channel.setSound(null, null);
        }
        mBuilder = new NotificationCompat.Builder(getApplicationContext(), "default")
                .setSmallIcon(R.mipmap.ic_launcher) // notification icon
                .setContentTitle(musicPOJO.getTitle()) // title for notification
                .setContentText(musicPOJO.getAlbum()) // message for notification
                .setProgress(100, 0, false)
                .setColor(getResources().getColor(R.color.colorAccent))
//                    .setColorized(true)
                .setAutoCancel(true); // clear notification after click
        Intent intent = new Intent(getApplicationContext(), DetailMusicActivity_.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pi);


        //image
        Glide.with(getApplicationContext()).asBitmap().load(musicPOJO.getCover()).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                if (bitmap != null) {
                    NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
                    bigPictureStyle.bigPicture(bitmap);
                    mBuilder.setStyle(bigPictureStyle);
                    mNotificationManager.notify(0, mBuilder.build());
                }
            }
        });

        mNotificationManager.notify(0, mBuilder.build());

    }

}
