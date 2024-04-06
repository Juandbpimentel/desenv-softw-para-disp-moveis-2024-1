package com.example.aplicacaoadapter

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val item_title:String = intent.getStringExtra("item_title")?:""
        val item_description:String = intent.getStringExtra("item_description")?:""
        val item_image_id:Int = intent.getIntExtra("item_image_id",0)
        val tv_name = findViewById<TextView>(R.id.item_activity_title)
        val tv_description = findViewById<TextView>(R.id.item_activity_description)
        val iv_image = findViewById<ImageView>(R.id.item_activity_image)
        val btn_voltar = findViewById<TextView>(R.id.btn_voltar_activity_item)

        tv_name.text = item_title
        tv_description.text = item_description
        iv_image.setImageDrawable(getDrawable(item_image_id))

        btn_voltar.setOnClickListener {
            finish()
        }
    }
}