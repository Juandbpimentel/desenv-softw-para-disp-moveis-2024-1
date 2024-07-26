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

import com.mastercoding.viewpagerapp.models.Pokemon;


public class Fragment3 extends Fragment {

    public Fragment3() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        // Inflate the layout for this fragment

        SharedPreferences sharedPref = getActivity().getSharedPreferences("preferencias",Context.MODE_PRIVATE);
        Pokemon pokemon = Pokemon.jsonStringToPokemon(sharedPref.getString("pokemon_3","Pokemon 3 não achado"));

        Button btnFragment3 = view.findViewById(R.id.btnFrag3);
        TextView tvFragment3 = view.findViewById(R.id.tvTituloFrag3);
        ImageView ivFragment3 = view.findViewById(R.id.imageFragment3);
        TextView tvDescricaoFragment3 = view.findViewById(R.id.tvDescricaoFrag3);
        TextView tvTiposFragment3 = view.findViewById(R.id.tvTiposFrag3);
        Context context = getContext();

        view.setBackgroundColor(ContextCompat.getColor(context, R.color.charizard_background));

        tvFragment3.setText(pokemon.getNome());
        ivFragment3.setImageResource(pokemon.getImagemId());
        tvDescricaoFragment3.setText(pokemon.getDescricao());
        btnFragment3.setBackgroundColor(ContextCompat.getColor(context, R.color.charizard_button_background));
        btnFragment3.setTextColor(ContextCompat.getColor(context, R.color.charizard_button_text));

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < pokemon.getTipos().size() ; i++) {
            if (i != 0) stringBuilder.append(", ");
            String nomeCapitalized = pokemon.getTipos().get(i).getNome().substring(0, 1).toUpperCase() + pokemon.getTipos().get(i).getNome().substring(1);
            stringBuilder.append(nomeCapitalized);
        }
        tvTiposFragment3.setText(stringBuilder.toString());

        btnFragment3.setOnClickListener(v->{
            MediaPlayer mediaPlayer = MediaPlayer.create(getContext(),pokemon.getSomId());
            mediaPlayer.start();
        });

        return view;
    }
}