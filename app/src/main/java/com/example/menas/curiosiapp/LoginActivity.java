package com.example.menas.curiosiapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUsuario, etContrasena;

    private Cursor Fila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = (EditText) findViewById(R.id.usuario);
        etContrasena = (EditText) findViewById(R.id.contrasena);

    }


    public void  onIngresar(View v){

        String strUsuario = etUsuario.getText().toString();
        String strContrasena = etContrasena.getText().toString();

        strUsuario = strUsuario.toUpperCase();

        if (strUsuario.equals("") || strContrasena.equals("")) {

            Toast.makeText(getApplicationContext(), "Debe agregar Usuario y Contraseña" , Toast.LENGTH_LONG).show();

        } else {

            DBHelper helper = new DBHelper(getApplicationContext());
            SQLiteDatabase db = helper.getWritableDatabase();

            Fila = db.rawQuery("SELECT nombre, contrasena FROM usuario WHERE nombre ='" + strUsuario + "' AND contrasena ='" + strContrasena + "'", null);

            if (Fila.moveToFirst()) {
                String dbNombre = Fila.getString(0);
                String dbContrasena = Fila.getString(1);

                if (strUsuario.equals(dbNombre) && strContrasena.equals(dbContrasena)) {

                    //Toast.makeText(getApplicationContext(), "USUARIOLOGIN:" + USUARIO_LOGUEADO , Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(this, Contenido.class);
                    intent.putExtra("UL",strUsuario);
                    startActivity(intent);
                }
            }else{
                Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrecto", Toast.LENGTH_LONG).show();
            }
        }
    }


    public void onRegistrar(View v){
        Intent intent = new Intent(this,Registro.class);
        startActivity(intent);
    }
}


