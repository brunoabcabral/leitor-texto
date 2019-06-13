package com.brcabral.confteste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void tlcadastro (View view){
            Intent intent = new Intent(this, cadastro.class);
            startActivity(intent);
        }

        public void retorno (View view){
        Intent intent = new Intent(this, consulta.class);

    }


}

