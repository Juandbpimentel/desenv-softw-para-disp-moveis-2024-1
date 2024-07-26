package com.mastercoding.viewpagerapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mastercoding.viewpagerapp.models.Pokemon;


public class Fragment1 extends Fragment {



    public Fragment1() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        // Inflate the layout for this fragment

        SharedPreferences sharedPref = getActivity().getSharedPreferences("preferencias",Context.MODE_PRIVATE);
        Pokemon pokemon = Pokemon.jsonStringToPokemon(sharedPref.getString("pokemon_1","Pokemon 1 não achado"));

        Button btnFragment1 = view.findViewById(R.id.btnFrag1);
        TextView tvFragment1 = view.findViewById(R.id.tvTituloFrag1);
        ImageView ivFragment1 = view.findViewById(R.id.imageFragment1);
        TextView tvDescricaoFragment1 = view.findViewById(R.id.tvDescricaoFrag1);
        TextView tvTiposFragment1 = view.findViewById(R.id.tvTiposFrag1);
        Context context = getContext();

        view.setBackgroundColor(ContextCompat.getColor(context, R.color.charmander_background));

        tvFragment1.setText(pokemon.getNome());
        ivFragment1.setImageResource(pokemon.getImagemId());
        tvDescricaoFragment1.setText(pokemon.getDescricao());
        btnFragment1.setBackgroundColor(ContextCompat.getColor(context, R.color.charmander_button_background));
        btnFragment1.setTextColor(ContextCompat.getColor(context, R.color.charmander_button_text));

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < pokemon.getTipos().size() ; i++) {
            if (i != 0) stringBuilder.append(", ");
            String nomeCapitalized = pokemon.getTipos().get(i).getNome().substring(0, 1).toUpperCase() + pokemon.getTipos().get(i).getNome().substring(1);
            stringBuilder.append(nomeCapitalized);
        }
        tvTiposFragment1.setText(stringBuilder.toString());

        btnFragment1.setOnClickListener(v->{
            Toast.makeText(getContext(), "Botão do Fragment 1", Toast.LENGTH_SHORT).show();
            MediaPlayer mediaPlayer = MediaPlayer.create(getContext(),pokemon.getSomId());
            mediaPlayer.start();
        });

        return view;
    }
}