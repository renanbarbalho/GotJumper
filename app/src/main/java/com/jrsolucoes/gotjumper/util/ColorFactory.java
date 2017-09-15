package com.jrsolucoes.gotjumper.util;

import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * Created by renan.b on 15/09/2017.
 */
public class ColorFactory {

    public static Paint getHeroColor() {
        Paint white = new Paint();
        white.setColor(0xFFFFFFFF);
        return white;
    }

    public static Paint getEnimeColor(){
        Paint red = new Paint();
        red.setColor(0XFFFF0000);
        return red;
    }

    public static Paint getScoreColor(){
        Paint black = new Paint();
        black.setColor(0xFFFFFFFF);
        black.setTextSize(80);
        black.setTypeface(Typeface.DEFAULT_BOLD);
        black.setShadowLayer(3, 5, 5, 0xFF000000);
        return black;
    }

    public static Paint getGameOverColor(){
        Paint red = new Paint();
        red.setColor(0xFFFF0000);
        red.setTextSize(50);
        red.setTypeface(Typeface.DEFAULT_BOLD);
        red.setShadowLayer(2, 3, 3, 0xFF000000);
        return red;
    }
}
