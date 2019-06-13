package com.brcabral.confteste;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class consulta extends Activity {
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bancocontrole crud = new bancocontrole(getBaseContext());

        String[] nomeCampos = new String[]{banco.TABELA};
        int[] idViews = new int[]{R.id.txtnome, R.id.txttempo};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(), R.layout.activity_main, Cursor, nomeCampos, idViews, 0);
        lista = findViewById(R.id.retorno);
        lista.setAdapter(adapter);
    }
}