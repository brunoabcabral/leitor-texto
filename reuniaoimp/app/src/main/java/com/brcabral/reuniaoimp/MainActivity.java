package com.brcabral.reuniaoimp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TextView arquivo, leitura;
    private Spinner listar;
    private ArrayList<String> Arquivos = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.activity_main);
            arquivo = (TextView)findViewById(R.id.txtdiretorio);
            leitura = (TextView)findViewById(R.id.txtleitura);
            listar = (Spinner) findViewById(R.id.spnlista);
            Listar();
        } catch (Exception e) {
            Mensagem("Erro : " + e.getMessage());
        }
    }

    private void Mensagem (String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
    private String ObterDiretorio(){
        File arquivo  = android.os.Environment.getExternalStorageDirectory();
        return arquivo .toString();
    }

    public void Listar(){
        File diretorio = new File (ObterDiretorio());
        File[] arquivos = diretorio.listFiles();
        if(arquivos != null){
            int length = arquivos.length;
            for(int i = 0; i < length; ++i){
                File f = arquivos[i];
                if (f.isFile()){
                    Arquivos.add(f.getName());
                }
            }
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                    (this,android.R.layout.simple_dropdown_item_1line, Arquivos);
            listar.setAdapter(arrayAdapter);
        }
    }

    public void Salvar (View view){
        String lstrNomeArq;
        File arq;
        byte[] dados;
        try{
            lstrNomeArq = arquivo.getText().toString();
            arq = new File(Environment.getExternalStorageDirectory(), lstrNomeArq);
            FileOutputStream fos;
            dados = arquivo.getText().toString().getBytes();
            fos = new FileOutputStream(arq);
            fos.write(dados);
            fos.flush();
            fos.close();
            Mensagem("Sucesso");
            Listar();
        }
        catch (Exception e){
            Mensagem("Erro" + e.getMessage());
        }
    }
    public void diretorio (View view){
        String lstrNomeArq;
        File arq;
        String lstrlinha;
        try {
            lstrNomeArq = listar.getSelectedItem().toString();
            leitura.setText("");
            arq = new File(Environment.getExternalStorageDirectory(), lstrNomeArq);
            BufferedReader br = new BufferedReader(new FileReader(arq));

            while ((lstrlinha = br.readLine()) != null) {
                if (!leitura.getText().toString().equals("")) {
                    leitura.append("\n");
                }
                leitura.append(lstrlinha);
            }
            Mensagem("Carregado");

        }
        catch (Exception e) {
            Mensagem("Erro" + e.getMessage());
        }

    }

}
