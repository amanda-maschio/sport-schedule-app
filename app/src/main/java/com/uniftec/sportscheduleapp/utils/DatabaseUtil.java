package com.uniftec.sportscheduleapp.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseUtil extends SQLiteOpenHelper {

    private static DatabaseUtil sInstance;

    private Context context;
    private static final String DATABASE_NAME = "sport_schedule.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseUtil(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        StringBuilder create = new StringBuilder();
        create.append("CREATE TABLE IF NOT EXISTS pessoa (");
        create.append("cod_pessoa INTEGER PRIMARY KEY AUTOINCREMENT,");
        create.append("nome TEXT NOT NULL,");
        create.append("cpf TEXT NOT NULL,");
        create.append("data_nascimento TEXT NOT NULL,");
        create.append("foto BLOB)");

        db.execSQL(create.toString());

        create = new StringBuilder();

        create.append("CREATE TABLE IF NOT EXISTS usuario (");
        create.append("cod_usuario INTEGER PRIMARY KEY AUTOINCREMENT,");
        create.append("cod_pessoa INTEGER,");
        create.append("email TEXT NOT NULL,");
        create.append("senha TEXT NOT NULL,");
        create.append("ind_tp_usuario TEXT NOT NULL,");
        create.append("FOREIGN KEY (cod_pessoa) REFERENCES pessoa(cod_pessoa))");

        db.execSQL(create.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS pessoa");
        db.execSQL("DROP TABLE IF EXISTS usuario");
        onCreate(db);
    }

    public SQLiteDatabase GetConexaoDataBase() {
        return this.getWritableDatabase();
    }
}
