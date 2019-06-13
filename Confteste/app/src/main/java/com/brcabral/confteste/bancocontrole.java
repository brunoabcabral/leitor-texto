package com.brcabral.confteste;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

public class bancocontrole {

    private SQLiteDatabase db;
    private banco banco;

    public bancocontrole(Context context) {
        banco = new bancocontrole(context);
    }

    public String insereDados(String tabela, String nome, String tempo) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores.put(com.brcabral.confteste.banco.TABELA, tabela);
        valores.put(com.brcabral.confteste.banco.COLUMN_NOME, nome);
        valores.put(com.brcabral.confteste.banco.COLUMN_TEMPO, tempo);

        resultado = db.insert(banco.TABELA, null, valores);
        db.close();
        if (resultado == -1)
            return "erro";
        else
            return "Sucesso";
    }
}
