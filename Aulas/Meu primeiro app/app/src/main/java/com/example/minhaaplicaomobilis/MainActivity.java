package com.example.minhaaplicaomobilis;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int cliquesFeitos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cliquesFeitos = 0;

        //código de contador
        Button btnContador = findViewById(R.id.butaoDeClick);
        TextView textViewContador = findViewById(R.id.textViewContador);

        btnContador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Tudo que eu quero fazer aqui dentro
                cliquesFeitos++;
                textViewContador.setText(String.valueOf(cliquesFeitos));
            }
        });

        // Código de mensagem
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
    }
}

/*
* package com.example.minhaaplicaomobilis

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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