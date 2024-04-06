package com.example.aplicacaoadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aplicacaoadapter.adapters.ListViewCustomAdapter;

public class CustomAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);

        ListView lv_comidas = findViewById(R.id.listViewTeste2);

        String[] comidas = {"Feijoada","Franguinho assado com arroz e farofa","Joelho", "Filé de frango à permegiana"};

        ListViewCustomAdapter lv_custom_adapter = new ListViewCustomAdapter(comidas,this);
        lv_comidas.setAdapter(lv_custom_adapter);


    }
}