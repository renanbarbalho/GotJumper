package com.jrsolucoes.gotjumper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.jrsolucoes.gotjumper.elements.TheGame;

public class MainActivity extends AppCompatActivity {

    TheGame got;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recupera o layout que vai receber o jogo
        FrameLayout frame = (FrameLayout) findViewById(R.id.container);

        //instancia a classe que controla o jogo
        got = new TheGame(this);
        //insere o jogo dentro do container
        frame.addView(got);
    }

    @Override
    protected void onPause(){
        super.onPause();
        got.cancela();
    }

    protected void onResume(){
        super.onResume();
        got.inicia();
        new Thread(got).start();
    }
}
