package com.mastercoding.viewpagerapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;

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
        Pokemon pokemon1 = Pokemon.jsonStringToPokemon(sharedPref.getString("pokemon_1","Pokemon 1 não achado"));

        Button btnTeste = view.findViewById(R.id.btnFrag1);
        TextView tvFragment1 = view.findViewById(R.id.tvTituloFrag1);
        ImageView ivFragment1 = view.findViewById(R.id.imageFragment1);
        TextView tvDescricaoFragment1 = view.findViewById(R.id.tvDescricaoFrag1);

        tvFragment1.setText(pokemon1.getNome());
        ivFragment1.setImageResource(pokemon1.getImagemId());
        tvDescricaoFragment1.setText(pokemon1.getDescricao());

        btnTeste.setOnClickListener(v->{
            MediaPlayer mediaPlayer = MediaPlayer.create(getContext(),pokemon1.getSomId());
            mediaPlayer.start();
        });

        return view;
    }
}