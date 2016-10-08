package com.vamsi.andlib;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    //start Activity
    public static void startActivity(Context context,String result){

        Intent iJokeActivity = new Intent(context, JokeActivity.class);
        iJokeActivity.putExtra("joke",result);
        context.startActivity(iJokeActivity);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView tvJoke = (TextView) findViewById(R.id.tvJoke);

        tvJoke.setText(""+getIntent().getExtras().getString("joke"));

    }

}
