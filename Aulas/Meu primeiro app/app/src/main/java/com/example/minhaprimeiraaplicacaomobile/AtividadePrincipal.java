package com.example.minhaprimeiraaplicacaomobile;

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
        setContentView(R.layout.activity_main);

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
        Button btnDeTransicaoParaContador = findViewById(R.id.botaoDeTransicao);
        btnDeTransicaoParaContador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Tudo que eu quero fazer aqui dentro
                Intent novaAtividade = new Intent(MainActivity.this, CounterActivityKt.class);
                startActivity(novaAtividade);
            }
        });
    }
}

/*
* package com.example.minhaaplicaomobilis

* import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnMostrarNotificacao = findViewById<Button>(R.id.butao1)
        btnMostrarNotificacao.setOnClickListener { //Tudo que eu quero fazer aqui dentro
            Toast.makeText(
                applicationContext,
                "Você clicou kkkkkkkkkkkkkkkkkk, mt influenciável",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
*
*
*
*  */