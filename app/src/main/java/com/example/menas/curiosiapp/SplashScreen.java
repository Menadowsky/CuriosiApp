package com.example.menas.curiosiapp;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends  Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreen.this, LoginActivity.class); // Creamos un Intent para que pase a la siguiente actividad.
                startActivity(intent);


            }
        }, 4000); //Tiempo que demora en pantalla el SplashScreen

    }

}
