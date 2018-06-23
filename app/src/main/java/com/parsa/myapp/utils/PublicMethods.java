package com.parsa.myapp.utils;

import android.content.Context;
import android.widget.Toast;

import com.parsa.myapp.Music.MusicPOJO;

import java.util.List;

public class PublicMethods {

    public static void showToast(Context mContext,String msg){
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    public static List<MusicPOJO> getMusics(){
        return MusicPOJO.listAll(MusicPOJO.class);
    }

    public static MusicPOJO getMusicById(String id){
        return MusicPOJO.findById(MusicPOJO.class, Long.parseLong(id));
    }
}
