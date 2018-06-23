package com.parsa.mylib;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 * Created by hmd on 06/22/2018.
 */

public class CustomButton extends AppCompatButton {
    public CustomButton(Context context) {
        super(context);
        setTypeFace_(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeFace_(context);
    }

    void setTypeFace_(Context mContext){
        this.setTypeface(Typeface.createFromAsset(mContext.getAssets(),"ir_sans.ttf"));
    }
}
