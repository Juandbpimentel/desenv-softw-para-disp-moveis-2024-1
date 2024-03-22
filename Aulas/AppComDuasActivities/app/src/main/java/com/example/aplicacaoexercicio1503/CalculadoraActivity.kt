package com.example.aplicacaoexercicio1503

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.math.RoundingMode

class CalculadoraActivity : AppCompatActivity() {
    private var etPrimeiroNumero:EditText? = null;
    private var etSegundoNumero:EditText? = null;

    private var tvResultado:TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)
        etPrimeiroNumero = findViewById(R.id.et_primeiro_numero)
        etSegundoNumero = findViewById(R.id.et_segundo_numero)

        tvResultado = findViewById(R.id.tv_resultado)
        val arrayOfButtons = mapOf<Button,Char>(
            findViewById<Button>(R.id.btn_sum) to '+',
            findViewById<Button>(R.id.btn_sub) to '-',
            findViewById<Button>(R.id.btn_mult) to '*',
            findViewById<Button>(R.id.btn_div) to '/',
            findViewById<Button>(R.id.btn_return_to_main) to ' '
        )

        arrayOfButtons.forEach{ button,operator ->
            when (operator) {
                '+', '-', '*', '/' -> button.setOnClickListener { makeOperation(operator) }
                ' ' -> button.setOnClickListener { finish() }
            }
        }

        /*
        Código não otimizado em reuso para a criação dos botões
        btnSum = findViewById(R.id.btn_sum)
        btnSub = findViewById(R.id.btn_sub)
        btnMult = findViewById(R.id.btn_mult)
        btnDiv = findViewById(R.id.btn_div)
        btnVoltar = findViewById(R.id.btn_return_to_main)

        etPrimeiroNumero = findViewById(R.id.et_primeiro_numero)
        etSegundoNumero = findViewById(R.id.et_segundo_numero)

        tvResultado = findViewById(R.id.tv_resultado)

        btnSum?.setOnClickListener {
            makeOperation('+')
        }
        btnDiv?.setOnClickListener {
            makeOperation('/')
        }
        btnSub?.setOnClickListener {
            makeOperation('-')
        }
        btnMult?.setOnClickListener {
            makeOperation('*')
        }
        btnVoltar?.setOnClickListener {
            finish()
        }

         */


    }

    private fun makeOperation(operator:Char){
        printInLog()
        if (!inputsVerification(operator))
            return

        val primeiroNumero = etPrimeiroNumero?.text.toString().toDouble()
        val segundoNumero = etSegundoNumero?.text.toString().toDouble()

        val result = when(operator){
            '+' -> (primeiroNumero + segundoNumero).toBigDecimal().setScale(4,RoundingMode.HALF_DOWN).toDouble()
            '-' -> (primeiroNumero - segundoNumero).toBigDecimal().setScale(4,RoundingMode.HALF_DOWN).toDouble()
            '*' -> (primeiroNumero * segundoNumero).toBigDecimal().setScale(4,RoundingMode.HALF_DOWN).toDouble()
            '/' -> (primeiroNumero / segundoNumero).toBigDecimal().setScale(4,RoundingMode.HALF_DOWN).toDouble()
            else -> return
        }
        tvResultado?.text = result.toString()
    }

    private fun inputsVerification(operator: Char):Boolean{
        if (etPrimeiroNumero!!.text.isEmpty() || etSegundoNumero!!.text.isEmpty() ) {
            val toast = Toast.makeText(this,"Os campos precisam estar preenchidos",Toast.LENGTH_SHORT)
            toast.show()
            return false
        }
        if (etSegundoNumero!!.text.toString()[0] == '0'  && operator == '/') {
            val toast = Toast.makeText(this,"Não é possível fazer divisão por 0",Toast.LENGTH_SHORT)
            toast.show()
            return false
        }
        return true
    }

    private fun printInLog(){
        if (etPrimeiroNumero!=null || etSegundoNumero!=null ){
            Log.d("Teste valores campos","Campo1 : ${etPrimeiroNumero!!.text.length} Campo2: ${etSegundoNumero!!.text.length}")
            Log.d("Teste nulo campo1","Campo1 está vazio \"\"? : ${ if (etPrimeiroNumero!!.text.isEmpty()) "sim" else "não"}")
            Log.d("Teste nulo campo2","Campo2 está vazio \"\"? : ${ if (etSegundoNumero!!.text.isEmpty()) "sim" else "não"}")
        }
    }
}