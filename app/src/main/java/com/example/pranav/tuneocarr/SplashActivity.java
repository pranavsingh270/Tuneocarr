package com.example.pranav.tuneocarr;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

public class SplashActivity extends AppCompatActivity {

    CircularProgressButton circularProgressButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        circularProgressButton=(CircularProgressButton)findViewById(R.id.btn_splash);
        circularProgressButton.startAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,BottomNavigationActivity.class));
                finish();
            }
        },2000);
    }
}
