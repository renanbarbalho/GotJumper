package com.jrsolucoes.gotjumper.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.games.Games;
import com.jrsolucoes.gotjumper.MainActivity;
import com.jrsolucoes.gotjumper.R;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button btnNewGame = (Button) findViewById(R.id.btnNewGame);
        btnNewGame.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnNewGame){
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
        }
    }
}
