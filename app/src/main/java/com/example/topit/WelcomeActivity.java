package com.example.topit;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.topit.Fragments.ProfileFragment;

import java.util.Random;

public class WelcomeActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(WelcomeActivity.this, NavDrawerActivity.class);
                startActivity(intent);

            }

        }, SPLASH_TIME_OUT);
    }
}