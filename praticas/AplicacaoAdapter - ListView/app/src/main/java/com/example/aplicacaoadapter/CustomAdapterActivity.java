package com.example.aplicacaoadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.aplicacaoadapter.adapters.ListViewCustomAdapter;

import java.util.ArrayList;

public class CustomAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);

        ListView lv_items = findViewById(R.id.listViewItems);
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item ("Pokemon","Jogo de batalha de monstros de bolso",getDrawable(R.drawable.pokemon),R.drawable.pokemon));
        items.add(new Item ("Zelda","Jogo de aventura com um elfo",getDrawable(R.drawable.zelda),R.drawable.zelda));
        items.add(new Item ("Skyrim","Jogo de aventura com dragões",getDrawable(R.drawable.skyrim),R.drawable.skyrim));
        items.add(new Item ("Stardew Valley","Jogo de fazenda",getDrawable(R.drawable.stardew),R.drawable.stardew));
        items.add(new Item ("Terraria","Jogo de aventura com construção",getDrawable(R.drawable.terraria),R.drawable.terraria));
        items.add(new Item ("Minecraft","Jogo de aventura com construção",getDrawable(R.drawable.minecraft),R.drawable.minecraft));
        items.add(new Item ("League of Legends","Jogo de batalha",getDrawable(R.drawable.lol),R.drawable.lol));


        ListViewCustomAdapter lv_custom_adapter = new ListViewCustomAdapter(items,this);
        lv_items.setAdapter(lv_custom_adapter);


    }
}