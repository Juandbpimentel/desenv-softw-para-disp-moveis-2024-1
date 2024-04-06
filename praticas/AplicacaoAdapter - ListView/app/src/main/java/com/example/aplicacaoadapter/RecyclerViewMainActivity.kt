package com.example.aplicacaoadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacaoadapter.adapters.ItemArrayAdapter
import com.example.aplicacaoadapter.items.Item

class RecyclerViewMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_main)

        val rv_cidades:RecyclerView = findViewById(R.id.rv_cidades)

        val itemList:ArrayList<Item > = ArrayList<Item>()

        val itemArrayAdapter:ItemArrayAdapter = ItemArrayAdapter(R.layout.item_fragment,itemList)
        rv_cidades.layoutManager = LinearLayoutManager(this)
        rv_cidades.adapter = itemArrayAdapter

        for (i in 0..100){
            itemList.add(Item("Item "+i))
        }
    }
}