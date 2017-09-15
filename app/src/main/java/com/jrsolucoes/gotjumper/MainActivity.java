package com.jrsolucoes.gotjumper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.jrsolucoes.gotjumper.activities.AdFullActivity;
import com.jrsolucoes.gotjumper.elements.TheGame;

public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;

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

        //faz o report de itens utilizados na app
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mFirebaseAnalytics.setCurrentScreen(this, "gameScreen", null);
    }

    @Override
    protected void onPause(){
        super.onPause();
        got.cancela();
    }

    @Override
    protected void onResume(){
        super.onResume();
        got.inicia();
        new Thread(got).start();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        got.cancela();
        startActivity(new Intent(this, AdFullActivity.class));
    }
}
