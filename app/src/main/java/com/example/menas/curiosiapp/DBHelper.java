package com.example.menas.curiosiapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by MENAS on 27/10/2017.
 */

public class DBHelper  extends SQLiteOpenHelper {

    SQLiteDatabase db;

    //public static final int DATABASE_VERSION = 1;
    //public static final String DATABASE_NAME = "dbCuriosiApp.db";

    // Valores de tabla Usuario
    public static final String NOMBRE_TABLA = "usuario";
    public static final String COLUMNA_USUARIO = "nombre";
    public static final String COLUMNA_CONTRASENA = "contrasena";

    public static final String NOMBRE_TABLA_2 = "puntaje";
    public static final String COLUMNA_ID_PUNTAJE = "id_puntaje";
    public static final String COLUMNA_CORRECTA = "correcta";
    public static final String COLUMNA_INCORRECTA = "incorrecta";
    public static final String COLUMNA_NOCONTESTADA = "nocontestada";
    public static final String COLUMNA_PROMEDIO = "promedio";
    public static final String COLUMNA_NOMBRE = "nombre";

    public static final String USUARIO_LOGUEADO = "a";

    //private static final String CREAR_TABLA_USUARIO = "CREATE TABLE usuario (nombre TEXT PRIMARY KEY NOT NULL, contrasena TEXT NOT NULL)";

    // Constructor
    public DBHelper(Context context) {
        super(context, "dbCursiosiApp.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuario (nombre TEXT PRIMARY KEY NOT NULL, contrasena TEXT NOT NULL)");
        db.execSQL("CREATE TABLE puntaje (id_puntaje INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, correcta INTEGER NOT NULL, incorrecta INTEGER NOT NULL, nocontestada INTEGER NOT NULL, promedio INTEGER NOT NULL, nombre TEXT NOT NULL,FOREIGN KEY (nombre) REFERENCES usuario(nombre))");

        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuario");
        db.execSQL("DROP TABLE IF EXISTS puntaje");
        this.onCreate(db);
    }
}
