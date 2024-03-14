package com.example.appcomduasactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_aumenta_contador, btn_chama_calculadora;
    int contador;
    TextView tv_contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_aumenta_contador = findViewById(R.id.btn_aumenta_contador);
        btn_chama_calculadora = findViewById(R.id.btn_chama_calculadora);
        tv_contador = findViewById(R.id.tv_contador);
        contador = 0;
        btn_aumenta_contador.setOnClickListener(v ->{
                contador++;
                tv_contador.setText(String.valueOf(contador));
        });
        btn_chama_calculadora.setOnClickListener(v->{
            Intent novaAtividade = new Intent(this, CalculadoraActivity.class);
            novaAtividade.putExtra("ultimo_valor_contador",String.valueOf(contador));
            startActivity(novaAtividade);
        });

    }
}