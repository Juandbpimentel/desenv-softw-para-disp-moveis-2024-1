package com.example.aplicacaoadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv_cidades = findViewById(R.id.listViewTeste);

        String[] cidadesDoCeara = {"Paraipaba","Monsenhor Tabosa","Quixadá", "Fortaleza","Crateús"};

        ArrayAdapter adapterCidades = new ArrayAdapter(this,android.R.layout.simple_list_item_1,cidadesDoCeara);
        lv_cidades.setAdapter(adapterCidades);

        lv_cidades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("cidades-item-click", "Voce clicou no item: " + position);
                Toast.makeText(MainActivity.this, "Clicou no item: " + cidadesDoCeara[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}