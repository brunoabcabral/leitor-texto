package com.brcabral.confteste;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Alterar extends Activity {
    EditText nome;
    EditText tempo;
    Button salvar;
    Cursor cursor;
    bancocontrole crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        codigo = this.getIntent().getStringExtra("codigo");
        crud = new bancocontrole(getBaseContext());
        nome = findViewById(R.id.txtnome);
        tempo = findViewById(R.id.txttempo);
        salvar = findViewById(R.id.btnsalvar);
        cursor = crud.insereDados(Integer.parseInt(codigo));
        nome.setText(cursor.getString(cursor.getColumnIndexOrThrow(banco.COLUMN_NOME)));
        tempo.setText(cursor.getString(cursor.getColumnIndexOrThrow(banco.COLUMN_TEMPO)));
    }
}
