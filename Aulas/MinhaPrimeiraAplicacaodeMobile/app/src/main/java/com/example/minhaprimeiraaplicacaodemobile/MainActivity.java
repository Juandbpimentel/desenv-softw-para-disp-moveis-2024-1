package com.example.minhaprimeiraaplicacaodemobile;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public int cliquesFeitos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity_layout);
        /*

        Button btnDeTransicaoParaContador = findViewById(R.id.botaoDeTransicao);
        btnDeTransicaoParaContador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Tudo que eu quero fazer aqui dentro
                Intent novaAtividade = new Intent(MainActivity.this, CounterActivity.class);
                startActivity(novaAtividade);
            }
        });
        */

    }
}


/*
        // Código para mostrar mensagem toast
        Button btnDeMensagem = findViewById(R.id.butaoDeMensagem);

        EditText textInputNome = findViewById(R.id.editTextName);
        EditText textInputEmail = findViewById(R.id.editTextEmail);

        btnDeMensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Tudo que eu quero fazer aqui dentro
                Toast.makeText(getApplicationContext(), "( Nome:"+textInputNome.getText()+" Email: "+textInputEmail.getText()+" )", Toast.LENGTH_LONG).show();
            }
        });
    */