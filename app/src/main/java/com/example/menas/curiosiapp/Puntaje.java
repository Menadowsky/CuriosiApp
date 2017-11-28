package com.example.menas.curiosiapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Puntaje extends AppCompatActivity {

    ListView lv;

    ArrayList<String> lista = new ArrayList<>();

    private Cursor Fila;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntaje);

        lv = (ListView)findViewById(R.id.lista);
        mPuntaje();
    }

    public void mPuntaje() {
        String rUSUARIO_LOGUEADO = getIntent().getStringExtra("UL");
        DBHelper helper = new DBHelper(getApplicationContext());
        SQLiteDatabase db = helper.getWritableDatabase();

        Fila = db.rawQuery("SELECT correcta, incorrecta, nocontestada, promedio FROM puntaje WHERE nombre = '" + rUSUARIO_LOGUEADO + "'", null);

        if (Fila.moveToFirst()) {
            do {
                String dbCorrecto = Fila.getString(0);
                String dbIncorrecto = Fila.getString(1);
                String dbNocontestada = Fila.getString(2);
                String dbPromedio = Fila.getString(3);
                lista.add("Correctas: " + dbCorrecto + " Incorrectas: " + dbIncorrecto + " No Contestadas: " + dbNocontestada + " Promedio " + dbPromedio + "%");
            } while (Fila.moveToNext());
        }
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,lista);
        lv.setAdapter(adaptador);
    }
}