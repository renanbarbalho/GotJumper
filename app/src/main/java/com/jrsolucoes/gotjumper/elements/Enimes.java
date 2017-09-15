package com.jrsolucoes.gotjumper.elements;

/**
 * Created by renan.b on 15/09/2017.
 */

import android.graphics.Canvas;

import com.jrsolucoes.gotjumper.util.Score;
import com.jrsolucoes.gotjumper.util.ScreenUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/**
 * Created by renan.b on 15/09/2017.
 */
public class Enimes {

    private static final int ENIMES_SIZE = 5;
    private static final int ENIMES_DISTANCE = 250;
    private final List<Enime> enimes = new ArrayList<Enime>();

    private ScreenUtils screenUtils;
    private Score score;

    public Enimes(ScreenUtils screenUtils, Score score){
        this.screenUtils = screenUtils;
        this.score = score;
        int startPosition = 800;
        for(int i = 0 ; i < ENIMES_SIZE ; i++) {
            startPosition += ENIMES_DISTANCE;
            enimes.add(new Enime(screenUtils, startPosition));
        }
    }

    public void moveEnime(){
        ListIterator<Enime> iterator = enimes.listIterator();
        while(iterator.hasNext()) {
            Enime enime = iterator.next();
            enime.moveEnime();
            if(enime.outScreen()) {
                score.addPoints();
                iterator.remove();
                Enime newEnime =
                        new Enime(screenUtils, getMax() + ENIMES_DISTANCE);
                iterator.add(newEnime);
            }
        }
    }

    public void drawEnime(Canvas canvas){
        for(Enime enime : enimes)
            enime.drawEnime(canvas);
    }

    private int getMax() {
        int maximo = 0;
        for(Enime enime : enimes) {
            maximo = Math.max(enime.getPosition(), maximo);
        }

        return maximo;
    }

    public boolean hasTouchInEnimes(Hero hero) {
        for (Enime enime : enimes) {
            if (enime.hasHorizontalTouch(hero) && enime.hasVerticalTouch(hero)) {
                return true;
            }
        }
        return false;
    }
}
