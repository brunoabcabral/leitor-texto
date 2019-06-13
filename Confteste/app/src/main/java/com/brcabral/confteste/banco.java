package com.brcabral.confteste;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class banco extends SQLiteOpenHelper {
    public banco(Context context){
        super(context, NOME_DB,null,VERSAO_DB);
    }

    public static final String NOME_DB = "teste";
    public static final int VERSAO_DB = 1;
    public static final String TABELA = "tabela";
    public static final String COLUMN_NOME = "nome";
    public static final String COLUMN_TEMPO = "tempo";

    public void onCreate(SQLiteDatabase db){
        String sql = " CREATE TABLE "
                + TABELA
                + "tabela"
                + NOME_DB
                + " tempo "
                + COLUMN_TEMPO
                + " nome "
                + COLUMN_NOME;

        db.execSQL(sql);
    }

// atualizar banco
    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
