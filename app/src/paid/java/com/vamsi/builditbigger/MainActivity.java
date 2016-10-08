package com.vamsi.builditbigger;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.vamsi.andlib.JokeActivity;

public class MainActivity extends ActionBarActivity {

    MainActivityFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment =  (MainActivityFragment) getSupportFragmentManager().findFragmentById( R.id.fragment );

        mainFragment.spinner.setVisibility(View.GONE);

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


    //start JokeActivity
    public void start(String result) {
        mainFragment.spinner.setVisibility(View.GONE);
        JokeActivity.startActivity(this, result);
    }

}
