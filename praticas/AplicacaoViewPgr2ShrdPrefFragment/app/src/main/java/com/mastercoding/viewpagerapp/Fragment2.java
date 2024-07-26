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


public class Fragment2 extends Fragment {


    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        // Inflate the layout for this fragment

        SharedPreferences sharedPref = getActivity().getSharedPreferences("preferencias",Context.MODE_PRIVATE);
        Pokemon pokemon = Pokemon.jsonStringToPokemon(sharedPref.getString("pokemon_2","Pokemon 2 não achado"));

        Button btnFragment2 = view.findViewById(R.id.btnFrag2);
        TextView tvFragment2 = view.findViewById(R.id.tvTituloFrag2);
        ImageView ivFragment2 = view.findViewById(R.id.imageFragment2);
        TextView tvDescricaoFragment2 = view.findViewById(R.id.tvDescricaoFrag2);
        TextView tvTiposFragment2 = view.findViewById(R.id.tvTiposFrag2);
        Context context = getContext();

        view.setBackgroundColor(ContextCompat.getColor(context, R.color.charmeleon_background));

        tvFragment2.setText(pokemon.getNome());
        ivFragment2.setImageResource(pokemon.getImagemId());
        tvDescricaoFragment2.setText(pokemon.getDescricao());
        btnFragment2.setBackgroundColor(ContextCompat.getColor(context, R.color.charmeleon_button_background));
        btnFragment2.setTextColor(ContextCompat.getColor(context, R.color.charmeleon_button_text));

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < pokemon.getTipos().size() ; i++) {
            if (i != 0) stringBuilder.append(", ");
            String nomeCapitalized = pokemon.getTipos().get(i).getNome().substring(0, 1).toUpperCase() + pokemon.getTipos().get(i).getNome().substring(1);
            stringBuilder.append(nomeCapitalized);
        }
        tvTiposFragment2.setText(stringBuilder.toString());

        btnFragment2.setOnClickListener(v->{
            MediaPlayer mediaPlayer = MediaPlayer.create(getContext(),pokemon.getSomId());
            mediaPlayer.start();
        });

        return view;
    }
}