package com.jrsolucoes.gotjumper.util;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by renan.b on 15/09/2017.
 */

public class Score {

    private static final Paint BLACK = ColorFactory.getScoreColor();
    private int myScore = 0;

    public void addPoints(){
        this.myScore += 1;
    }

    public void drawScore(Canvas canvas){
        canvas.drawText(String.valueOf(this.myScore), 100, 100, BLACK);
    }
}
