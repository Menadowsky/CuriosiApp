package com.example.menas.curiosiapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    EditText etUsuario, etContrasena;

    private Cursor Fila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etUsuario = (EditText)findViewById(R.id.usuario);
        etContrasena = (EditText)findViewById(R.id.contrasena);
    }

    public void onRegistrar(View v) {

        String strUsuario = etUsuario.getText().toString();
        String strContrasena = etContrasena.getText().toString();

        strUsuario = strUsuario.toUpperCase();

        if(strUsuario.equals("") || strContrasena.equals("")){

            Toast.makeText(getApplicationContext(), "Debe agregar Usuario y Contraseña" , Toast.LENGTH_LONG).show();
        }else{

            DBHelper helper = new DBHelper(getApplicationContext());
            SQLiteDatabase db = helper.getWritableDatabase();
            ContentValues valores = new ContentValues();

            Fila = db.rawQuery("SELECT nombre FROM usuario WHERE nombre ='" + strUsuario + "'",null);

            if (Fila.moveToFirst()){
                String dbNombre = Fila.getString(0);

                if (strUsuario.equals(dbNombre)){
                    Toast.makeText(getApplicationContext(), "El nombre de usuario ya existe" , Toast.LENGTH_LONG).show();
                }

            }else{
                valores.put(DBHelper.COLUMNA_USUARIO, strUsuario);
                valores.put(DBHelper.COLUMNA_CONTRASENA, strContrasena);

                db.insert(DBHelper.NOMBRE_TABLA, null, valores);

                Toast.makeText(getApplicationContext(), "Se ha registrado exitosamente", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
            }
        }
    }


    public void onCancelar(View v){
        finish();

    }

}
