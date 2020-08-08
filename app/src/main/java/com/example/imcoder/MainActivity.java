package com.example.imcoder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler() .postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent Splash  = new Intent(MainActivity.this,Login.class);
                startActivity(Splash);
                finish();
            }
        },SPLASH_SCREEN);
    }



}