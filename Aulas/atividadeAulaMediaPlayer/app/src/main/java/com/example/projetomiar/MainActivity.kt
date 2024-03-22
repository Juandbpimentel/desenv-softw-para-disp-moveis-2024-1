package com.example.projetomiar

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var btn_zelda:ImageButton? = null;
    var btn_saria:ImageButton? = null;
    var btn_epona:ImageButton? = null;
    var btn_storm:ImageButton? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_zelda = findViewById(R.id.btn_saria)
        btn_epona = findViewById(R.id.btn_epona)
        btn_saria = findViewById(R.id.btn_saria)
        btn_storm = findViewById(R.id.btn_storms)

        btn_zelda?.setOnClickListener(this)
        btn_epona?.setOnClickListener(this)
        btn_saria?.setOnClickListener(this)
        btn_storm?.setOnClickListener(this)

    }
    override fun onClick(v:View?){
        when(v){
            btn_zelda ->{
                Log.d("debud-mediaplayer","Botão da zelda foi clickado")
                Toast.makeText(this,"Botão zelda foi clickado!",Toast.LENGTH_SHORT).show()

                val mediaPlayer:MediaPlayer = MediaPlayer.create(this,R.raw.zeldastheme)
                mediaPlayer.start()
            }
            btn_epona ->{
                Log.d("debud-mediaplayer","Botão da Epona foi clickado")
                Toast.makeText(this,"Botão da Epona foi clickado!",Toast.LENGTH_SHORT).show()

                val mediaPlayer:MediaPlayer = MediaPlayer.create(this,R.raw.eponasong)
                mediaPlayer.start()
            }
            btn_saria-> {
                Log.d("debud-mediaplayer","Botão da Saria foi clickado")
                Toast.makeText(this,"Botão da Saria foi clickado!",Toast.LENGTH_SHORT).show()

                val mediaPlayer:MediaPlayer = MediaPlayer.create(this,R.raw.lostwoods)
                mediaPlayer.start()
            }
            btn_storm-> {
                Log.d("debud-mediaplayer","Botão Storms foi clickado")
                Toast.makeText(this,"Botão Storms foi clickado!",Toast.LENGTH_SHORT).show()

                val mediaPlayer:MediaPlayer = MediaPlayer.create(this,R.raw.songofstorms)
                mediaPlayer.start()
            }
        }
    }

}