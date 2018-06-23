package com.parsa.myapp.customViews;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.squareup.picasso.Picasso;

/**
 * Created by hmd on 06/21/2018.
 */

public class CustomImageView extends AppCompatImageView {

    public CustomImageView(Context context) {
        super(context);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void load(String url){
        Picasso.get().load(url).into(this);
    }
}
