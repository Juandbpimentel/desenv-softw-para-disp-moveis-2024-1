package com.example.appcomduasactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora2)
        val ultimo_valor_contador:String? = intent.getStringExtra("ultimo_valor_contador");
        val tv_ultimo_valor_contador:TextView = findViewById(R.id.tv_ultimo_valor_contador)

        if (ultimo_valor_contador != null)
            Log.d("log-sid-valor-compartilhado", ultimo_valor_contador)

        tv_ultimo_valor_contador.text = ultimo_valor_contador
    }
}