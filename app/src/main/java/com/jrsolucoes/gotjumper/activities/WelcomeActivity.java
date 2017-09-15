package com.jrsolucoes.gotjumper.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.games.Games;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jrsolucoes.gotjumper.MainActivity;
import com.jrsolucoes.gotjumper.R;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button btnNewGame = (Button) findViewById(R.id.btnNewGame);
        btnNewGame.setOnClickListener(this);

        //faz o report de itens utilizados na app
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mFirebaseAnalytics.setCurrentScreen(this, "welcomeScreen", null);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnNewGame){
            //envia tracking app para firebase
            Bundle params = new Bundle();
            params.putString("passo_corrente", "step01");
            params.putString("valor_definido", "new game");
            mFirebaseAnalytics.logEvent("stage_game", params);

            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
        }
    }
}
