package com.jrsolucoes.gotjumper.util;

import com.jrsolucoes.gotjumper.elements.Enimes;
import com.jrsolucoes.gotjumper.elements.Hero;

/**
 * Created by renan.b on 15/09/2017.
 */

public class CheckTouchElements {

    private Hero hero;
    private Enimes enimes;

    public CheckTouchElements(Hero hero, Enimes enimes){
        this.hero = hero;
        this.enimes = enimes;
    }

    public boolean hasAnyTouchEnimes(){
        return enimes.hasTouchInEnimes(hero);
    }
}
