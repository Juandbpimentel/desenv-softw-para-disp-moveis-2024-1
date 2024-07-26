package com.mastercoding.viewpagerapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Fragment3 extends Fragment {

    public Fragment3() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        SharedPreferences sharedPref = getActivity().getSharedPreferences("preferencias", Context.MODE_PRIVATE);

        TextView tvFragment2 = view.findViewById(R.id.tvFragment3);
        tvFragment2.setText(sharedPref.getString("nome_pokemon_3","Nome não achado"));

        return view;
    }
}