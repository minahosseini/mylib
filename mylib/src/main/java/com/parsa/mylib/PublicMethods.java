package com.parsa.mylib;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by hmd on 06/22/2018.
 */

public class PublicMethods {
    public static void toast(Context mContext,String msg){
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
