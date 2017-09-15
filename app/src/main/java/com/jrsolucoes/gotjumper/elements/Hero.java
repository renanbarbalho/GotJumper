package com.jrsolucoes.gotjumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.jrsolucoes.gotjumper.util.ColorFactory;
import com.jrsolucoes.gotjumper.util.ScreenUtils;

/**
 * Created by renan.b on 15/09/2017.
 */

public class Hero {

    //recupera a cor do heroi
    private static final Paint WHITE = ColorFactory.getHeroColor();
    public static final int X = 100;
    public static final int RAIO = 50;
    private int height;
    private ScreenUtils screenUtils;

    public Hero(ScreenUtils screenUtils){
        this.screenUtils = screenUtils;
        this.height = 100;
    }

    public void cai() {
        boolean chegouNoChao = height + RAIO > screenUtils.getHeight();

        if(!chegouNoChao)
            this.height += 5;
    }

    public void pular(){
        if(this.height > RAIO) {
            this.height -= 150;
        }
    }

    public void drawHero(Canvas canvas){
        canvas.drawCircle(X, height, RAIO, WHITE);
    }

    public int getHeight(){
        return this.height;
    }
}
