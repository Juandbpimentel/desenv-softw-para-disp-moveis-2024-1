package com.example.aplicacaoexercicio1503

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)
        val nomeUsuario = intent.getStringExtra("nome_usuario");
        val senhaUsuario = intent.getStringExtra("senha_usuario");
        val tv_dados_usuario:TextView = findViewById(R.id.tv_dados_usuario)

        Log.d("tag-juan","Nome do usuário: ${nomeUsuario} | Senha do usuário: ${senhaUsuario}")

        tv_dados_usuario.text = "Nome do usuário: ${nomeUsuario} | Senha do usuário: ${senhaUsuario}"

    }
}