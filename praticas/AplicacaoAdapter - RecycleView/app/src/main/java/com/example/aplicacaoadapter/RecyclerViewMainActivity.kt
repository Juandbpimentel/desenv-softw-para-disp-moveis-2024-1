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
        itemList.add(Item("Tô indo praí",getDrawable(R.drawable.joelho)!!,"Preço R$ 3,00"))
        itemList.add(Item("Tô indo praí",getDrawable(R.drawable.pastel_de_feira)!!,"Preço R$ 4,00"))
        itemList.add(Item("Tô indo praí",getDrawable(R.drawable.caldo_de_cana)!!,"Preço R$ 4,00"))
        itemList.add(Item("Tô indo praí",getDrawable(R.drawable.coxinha_de_feira)!!,"Preço R$ 2,50"))
        itemList.add(Item("Tô indo praí",getDrawable(R.drawable.kibe_de_feira)!!,"Preço R$ 4,00"))
        itemList.add(Item("Tô indo praí",getDrawable(R.drawable.empada_de_feira)!!,"Preço R$ 5,00"))
        itemList.add(Item("Tô indo praí",getDrawable(R.drawable.salgado_de_queijo_de_feira)!!,"Preço R$ 3,00"))

    }
}