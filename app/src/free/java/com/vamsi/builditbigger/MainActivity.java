package com.vamsi.builditbigger;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.vamsi.andlib.JokeActivity;

public class MainActivity extends ActionBarActivity {

    MainActivityFragment mainFragment;

    InterstitialAd mInterstitialAd;
    String result="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment =  (MainActivityFragment) getSupportFragmentManager().findFragmentById( R.id.fragment );

        mainFragment.spinner.setVisibility(View.GONE);


        //for inter_Ad
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.ad_inter_id));

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                JokeActivity.startActivity(MainActivity.this, result);
            }
        });

        requestNewInterstitial();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        mainFragment.spinner.setVisibility(View.VISIBLE);

        new GCEPointsAsynTask(this).execute();
    }

    public void start(String result) {

        mainFragment.spinner.setVisibility(View.GONE);

        this.result = result;

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            JokeActivity.startActivity(this, result);
        }
    }


    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }


}
