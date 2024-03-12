package com.example.minhaprimeiraaplicacaodemobile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CounterActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.counter_activity)

        var cliquesFeitos = 0


        // contador de cliques
        val botao: Button = findViewById(R.id.buttonContador)
        val botaoDeVoltar: Button = findViewById(R.id.buttonVoltarTelaPrincipal)
        val textView : TextView = findViewById(R.id.textViewContador)
        botao.setOnClickListener {
            cliquesFeitos++
            textView.setText("Você clicou $cliquesFeitos vezes")
        }
        botaoDeVoltar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }


    }
}