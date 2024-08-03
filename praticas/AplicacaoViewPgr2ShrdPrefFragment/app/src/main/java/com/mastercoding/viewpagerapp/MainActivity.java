package com.mastercoding.viewpagerapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonWriter;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mastercoding.viewpagerapp.models.Pokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ViewPager2 viewpager;
    MyViewPagerAdapter myAdapter;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPref = getSharedPreferences();
        tabLayout = findViewById(R.id.tablayout);
        TextView tvTituloMain = this.findViewById(R.id.tvTituloMain);
        tvTituloMain.setText(sharedPref.getString("titulo_main_activity", "Título não achado"));

        myAdapter = new MyViewPagerAdapter(
                getSupportFragmentManager(),
                getLifecycle()
        );


        // Adding Fragments to the list in the Adapter Class
        myAdapter.addFragment(new Fragment1());
        myAdapter.addFragment(new Fragment2());
        myAdapter.addFragment(new Fragment3());

        // Set the orientation in ViewPager2
        viewpager = findViewById(R.id.viewPager2);
        viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        // Connecting the Adapter with ViewPager2
        viewpager.setAdapter(myAdapter);

        // Connecting TabLayout with ViewPager
        new TabLayoutMediator(
                tabLayout,
                viewpager,
                (tab, position) -> {
                    switch(position){
                        case 0:
                            Pokemon pokemon1 = Pokemon.jsonStringToPokemon(sharedPref.getString("pokemon_1","Pokemon 1 não achado"));
                            tab.setText(pokemon1.getNome() != null ? pokemon1.getNome() : "Tela 1");
                            break;
                        case 1:
                            Pokemon pokemon2 = Pokemon.jsonStringToPokemon(sharedPref.getString("pokemon_2","Pokemon 2 não achado"));
                            tab.setText(pokemon2.getNome() != null ? pokemon2.getNome() : "Tela 2");
                            break;
                        case 2:
                            Pokemon pokemon3 = Pokemon.jsonStringToPokemon(sharedPref.getString("pokemon_3","Pokemon 3 não achado"));
                            tab.setText(pokemon3.getNome() != null ? pokemon3.getNome() : "Tela 3");
                            break;
                    }
                }
        ).attach();



    }

    @SuppressLint("DiscouragedApi")
    private void fillSharedPreferences(SharedPreferences sharedPref, SharedPreferences.Editor editor, String[] keys) {
        for (String key : keys) {
            if (!sharedPref.contains(key)) {
                switch (key) {
                    case "pokemon_1":
                        ArrayList<Pokemon.TipoPokemon> tipos1 = new ArrayList<>();
                        tipos1.add(Pokemon.TipoPokemon.FOGO);
                        Pokemon pokemon1 = new Pokemon(
                                "Charmander",
                                tipos1,
                                "A chama em sua cauda mostra a força de sua força vital. Se Charmander for fraco, a chama também queima fracamente.",
                                getResources().getIdentifier("charmander", "drawable", getPackageName()),
                                getResources().getIdentifier("charmander", "raw", getPackageName()));
                        editor.putString(key, pokemon1.toJSONObject().toString());
                        break;
                    case "pokemon_2":
                        ArrayList<Pokemon.TipoPokemon> tipos2 = new ArrayList<>();
                        tipos2.add(Pokemon.TipoPokemon.FOGO);
                        Pokemon pokemon2 = new Pokemon(
                                "Charmeleon",
                                tipos2,
                                "Quando ele balança sua cauda em chamas, a temperatura ao redor dele sobe cada vez mais, atormentando seus oponentes.",
                                getResources().getIdentifier("charmeleon", "drawable", getPackageName()),
                                getResources().getIdentifier("charmeleon", "raw", getPackageName()));
                        editor.putString(key, pokemon2.toJSONObject().toString());
                        break;
                    case "pokemon_3":
                        ArrayList<Pokemon.TipoPokemon> tipos3 = new ArrayList<>();
                        tipos3.add(Pokemon.TipoPokemon.FOGO);
                        tipos3.add(Pokemon.TipoPokemon.VOADOR);
                        Pokemon pokemon3 = new Pokemon(
                                "Charizard",
                                tipos3,
                                "Se Charizard ficar realmente irritado, a chama na ponta de sua cauda queima em um tom azul claro.",
                                getResources().getIdentifier("charizard", "drawable", getPackageName()),
                                getResources().getIdentifier("charizard", "raw", getPackageName()));
                        editor.putString(key, pokemon3.toJSONObject().toString());
                        break;
                    case "titulo_main_activity":
                        editor.putString(key, "Evoluções do Charmander");
                        break;
                }
                editor.apply();
            }
        }
    }

    private @NonNull SharedPreferences getSharedPreferences() {
        Context context = this;
        SharedPreferences sharedPref = context.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        String[] keys = {"pokemon_1","pokemon_2","pokemon_3","titulo_main_activity"};
        fillSharedPreferences(sharedPref, editor, keys);

        return sharedPref;
    }
}