package com.jrsolucoes.gotjumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.jrsolucoes.gotjumper.R;
import com.jrsolucoes.gotjumper.activities.GameOver;
import com.jrsolucoes.gotjumper.util.CheckTouchElements;
import com.jrsolucoes.gotjumper.util.Score;
import com.jrsolucoes.gotjumper.util.ScreenUtils;

/**
 * Created by renan.b on 15/09/2017.
 */
public class TheGame extends SurfaceView implements Runnable, View.OnTouchListener {

    private boolean isRunning = true;
    private final SurfaceHolder holder = getHolder();
    private ScreenUtils screenUtils;
    private Hero jonSnow;
    private Enimes witheWalkers;
    private Score score;
    private Bitmap background;

    public TheGame(Context context) {
        super(context);
        screenUtils = new ScreenUtils(context);
        inicializaElementos();

        //inclui o evento de toque na tela
        setOnTouchListener(this);
    }

    public void inicializaElementos(){
        this.score = new Score();
        this.jonSnow = new Hero(this.screenUtils);
        this.witheWalkers = new Enimes(this.screenUtils, this.score);
        Bitmap back = BitmapFactory.decodeResource(getResources(),
                R.drawable.background);
        this.background = Bitmap.createScaledBitmap(back,
                back.getWidth(), screenUtils.getHeight(), false);
    }

    public void inicia() {
        this.isRunning = true;
    }

    public void cancela() {
        this.isRunning = false;
    }

    @Override
    public void run() {
        while(isRunning){
            if(!holder.getSurface().isValid()) continue;

            Canvas canvas = holder.lockCanvas();

            canvas.drawBitmap(this.background, 0, 0, null);

            //inserir elementos do jogo
            //hero
            jonSnow.drawHero(canvas);
            jonSnow.cai();

            //enime
            witheWalkers.drawEnime(canvas);
            witheWalkers.moveEnime();

            //placar
            score.drawScore(canvas);

            //valida colisões e define fim de jogo
            if(new CheckTouchElements(jonSnow, witheWalkers).hasAnyTouchEnimes()) {
                new GameOver(screenUtils).drawGameOver(canvas);
                isRunning = false;
            }

            //liberar uso da tela para o jogador
            holder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        jonSnow.pular();
        return false;
    }
}
