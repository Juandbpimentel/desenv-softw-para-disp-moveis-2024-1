package com.example.aplicacaoexercicio1503

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ContadorActivity : AppCompatActivity() {
    private var valorContador:Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contador)
        val btnVoltar:Button = findViewById(R.id.btn_voltar)
        val btnContador:Button = findViewById(R.id.btn_aumenta_contador)
        val tvContador:TextView = findViewById(R.id.tv_valor_contador)
        valorContador = intent.getIntExtra("valor_inicial_contador",0)
        tvContador.text = valorContador.toString()

        btnContador.setOnClickListener {
            valorContador++;
            tvContador.text = valorContador.toString()
        }


        btnVoltar.setOnClickListener {
            finish()
        }
    }
}