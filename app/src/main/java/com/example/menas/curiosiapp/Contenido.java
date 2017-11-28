package com.example.menas.curiosiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Contenido extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido);

    }


    public void onPreguntas(View v){

        String rUSUARIO_LOGUEADO = getIntent().getStringExtra("UL");

        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("UL",rUSUARIO_LOGUEADO);
        startActivity(intent);
    }

    public void onPuntaje(View v){

        String rUSUARIO_LOGUEADO = getIntent().getStringExtra("UL");

        Intent intent = new Intent(this, Puntaje.class);
        intent.putExtra("UL",rUSUARIO_LOGUEADO);
        startActivity(intent);
    }


}
