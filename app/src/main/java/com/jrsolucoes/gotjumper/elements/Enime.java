package com.jrsolucoes.gotjumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.jrsolucoes.gotjumper.util.ColorFactory;
import com.jrsolucoes.gotjumper.util.ScreenUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by renan.b on 15/09/2017.
 */
public class Enime {

    private final Paint red = ColorFactory.getEnimeColor();

    private static final int ENIMES_DISTANCE = 250;
    private final List<Enime> enimes = new ArrayList<Enime>();

    private static final int HEIGHT_ENIME = 250;
    private static final int WIDTH_ENIME = 100;
    private int HEIGHT_LOWER_ENIME;
    private int position;
    private ScreenUtils screenUtils;

    public Enime(ScreenUtils screenUtils, int position){
        this.screenUtils = screenUtils;
        this.position = position;
        this.HEIGHT_LOWER_ENIME = this.screenUtils.getHeight() - HEIGHT_ENIME - getEnimeHeightRandom();
    }

    private int getEnimeHeightRandom() {
        return (int) (Math.random() * 350);
    }

    public void moveEnime(){
        this.position -= 5;
    }

    public void drawEnime(Canvas canvas){
        canvas.drawRect(this.position, HEIGHT_LOWER_ENIME, position + WIDTH_ENIME, this.screenUtils.getHeight(), red);
    }

    public boolean outScreen() {
        return position + WIDTH_ENIME < 0;
    }

    public int getPosition(){
        return this.position;
    }

    public boolean hasVerticalTouch(Hero hero) {
        return hero.getHeight() + hero.RAIO > HEIGHT_LOWER_ENIME;
    }

    public boolean hasHorizontalTouch(Hero hero) {
        return this.position - hero.X < hero.RAIO;
    }
}
