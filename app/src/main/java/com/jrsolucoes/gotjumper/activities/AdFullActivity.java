package com.jrsolucoes.gotjumper.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jrsolucoes.gotjumper.R;

public class AdFullActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_full);

        //faz o report de itens utilizados na app
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mFirebaseAnalytics.setCurrentScreen(this, "adScreen", null);

        mInterstitialAd = new InterstitialAd(this);

        // set the ad unit ID
        mInterstitialAd.setAdUnitId("ca-app-pub-2076705468378655/2615795687");

        /*AdRequest adRequest = new AdRequest.Builder()
                .build();*/

        AdRequest adRequest = new AdRequest.Builder().addTestDevice("A646429C5D4FBEAA99BE19F75236C1EC").build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }

            @Override
            public void onAdClosed() {
                finish();
                /*Intent result = new Intent(AdFullActivity.this, ResultActivity.class);
                result.putExtra(ConstantsApp.KEY_PASSWORD, yourPassword);
                startActivity(result);*/

                //envia tracking app para firebase
                Bundle params = new Bundle();
                params.putString("passo_corrente", "step04");
                params.putString("valor_definido", "end_game");
                mFirebaseAnalytics.logEvent("show_ad_full", params);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                finish();
            }

            @Override
            public void onAdLeftApplication() {
                finish();
            }
        });
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
}
