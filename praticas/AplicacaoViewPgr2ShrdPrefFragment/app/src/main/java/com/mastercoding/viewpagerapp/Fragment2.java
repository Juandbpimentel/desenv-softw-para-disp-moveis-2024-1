package com.mastercoding.viewpagerapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Fragment2 extends Fragment {


    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        SharedPreferences sharedPref = getActivity().getSharedPreferences("preferencias", Context.MODE_PRIVATE);

        TextView tvFragment2 = view.findViewById(R.id.tvFragment2);
        tvFragment2.setText(sharedPref.getString("nome_pokemon_2","Nome não achado"));

        return view;
    }
}