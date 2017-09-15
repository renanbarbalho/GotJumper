package com.jrsolucoes.gotjumper.activities;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.jrsolucoes.gotjumper.util.ColorFactory;
import com.jrsolucoes.gotjumper.util.ScreenUtils;

/**
 * Created by renan.b on 15/09/2017.
 */

public class GameOver {

    private static final Paint RED = ColorFactory.getGameOverColor();
    private ScreenUtils screenUtils;

    public GameOver(ScreenUtils screenUtils){
        this.screenUtils = screenUtils;
    }

    public void drawGameOver(Canvas canvas){
        String text = "GAME OVER";
        canvas.drawText(text, centerText(text), screenUtils.getHeight() / 2, RED);
    }

    private int centerText(String texto) {
        Rect textLimit = new Rect();
        RED.getTextBounds(texto, 0, texto.length(), textLimit);

        return screenUtils.getWidth()/2 - (textLimit.right - textLimit.left)/2;
    }
}
