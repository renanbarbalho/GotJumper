package com.jrsolucoes.gotjumper.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by renan.b on 15/09/2017.
 */
public class ScreenUtils {

    private DisplayMetrics metrics;

    public ScreenUtils(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        metrics = new DisplayMetrics();
        display.getMetrics(metrics);
    }

    public int getHeight(){
        return metrics.heightPixels;
    }

    public int getWidth(){
        return metrics.widthPixels;
    }
}
