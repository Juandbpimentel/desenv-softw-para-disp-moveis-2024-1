package com.example.aplicacaoexercicio1503;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts.GetContent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Estado da activity main", "Estado da main: onCreate()");

        EditText etValorInicialContador = findViewById(R.id.et_valor_inicial_contador);
        Button btnIrParaContador = findViewById(R.id.btn_go_to_contador);
        Button btnIrParaCalculadora = findViewById(R.id.btn_go_to_calculadora);

        btnIrParaContador.setOnClickListener(v->{
            Intent novoIntent = new Intent(this, ContadorActivity.class);
            String textoValorInicialContador = etValorInicialContador.getText().toString();
            int valor_inicial_contador = 0;
            if(!textoValorInicialContador.isEmpty())
                valor_inicial_contador = Integer.parseInt(textoValorInicialContador);

            novoIntent.putExtra("valor_inicial_contador",valor_inicial_contador);
            startActivity(novoIntent);
        });
        btnIrParaCalculadora.setOnClickListener(v->{
            Intent novoIntent = new Intent(this, CalculadoraActivity.class);
            startActivity(novoIntent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Estado da activity main", "Estado da main: onStart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Estado da activity main", "Estado da main: onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Estado da activity main", "Estado da main: onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Estado da activity main", "Estado da main: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Estado da activity main", "Estado da main: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Estado da activity main", "Estado da main: onStop()");
    }
}