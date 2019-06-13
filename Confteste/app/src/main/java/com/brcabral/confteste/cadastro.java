package com.brcabral.confteste;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cadastro extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }
    //configurando o botão de  salvar
    Button btnsalvar = findViewById(R.id.btnsalvar);

    btnsalvar.setOnClickListener (new View.OnClickListener()){

        //configurando o formulário de cadastro
        EditText nome = findViewById(R.id.txtnome);
        EditText tempo = findViewById(R.id.txttempo);
        String nome (nome.getText().toString());
        String tempo (tempo.getText().toString());
        String resultado;
        resultado = crud.insereDado(nome, tempo);

        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_SHORT).show();

    };
}


