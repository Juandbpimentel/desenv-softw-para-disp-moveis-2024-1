package com.example.aplicacaoexercicio1503;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etValorInicialContador = findViewById(R.id.et_valor_inicial_contador);
        Button btnIrParaContador = findViewById(R.id.btn_go_to_contador);
        Button btnIrParaCalculadora = findViewById(R.id.btn_go_to_calculadora);

        btnIrParaContador.setOnClickListener(v->{
            Intent novoIntent = new Intent(this, ContadorActivity.class);
            if(etValorInicialContador.getText().toString().isEmpty())
                novoIntent.putExtra("valor_inicial_contador",0);
            else
                novoIntent.putExtra("valor_inicial_contador",Integer.parseInt(etValorInicialContador.getText().toString()));
            startActivity(novoIntent);
        });
        btnIrParaCalculadora.setOnClickListener(v->{
            Intent novoIntent = new Intent(this, CalculadoraActivity.class);
            startActivity(novoIntent);
        });
    }
}