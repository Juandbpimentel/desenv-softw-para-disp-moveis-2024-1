package com.mastercoding.viewpagerapp.models;



import android.util.Log;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Pokemon {
    private String nome;
    private ArrayList<TipoPokemon> tipos;
    private String descricao;
    private int imagemId;
    private int somId;

    public Pokemon(String nome, ArrayList<TipoPokemon> tipos, String descricao, int imagemId, int somId) {
        this.nome = nome;
        this.tipos = tipos;
        this.descricao = descricao;
        this.imagemId = imagemId;
        this.somId = somId;
    }

    public Pokemon() {
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<TipoPokemon> getTipos() {
        return tipos;
    }
    public void setTipos(ArrayList<TipoPokemon> tipos) {
        this.tipos = tipos;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public int getImagemId() {
        return imagemId;
    }

    public void setImagemId(int imagemId) {
        this.imagemId = imagemId;
    }

    public int getSomId() {
        return somId;
    }

    public void setSomId(int somId) {
        this.somId = somId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return imagemId == pokemon.imagemId && somId == pokemon.somId && Objects.equals(nome, pokemon.nome) && Objects.deepEquals(tipos, pokemon.tipos) && Objects.equals(descricao, pokemon.descricao);
    }

    @Override
    public String toString() {
        return "{" +
                "\"nome\":\"" + nome + '\"' +
                ", \"tipos\":" + tipos +
                ", \"descricao\":\"" + descricao + '\"' +
                ", \"imagemId\":" + imagemId +
                ", \"somId\":" + somId +
                '}';
    }

    public static Pokemon jsonStringToPokemon(String jsonString) {
        try {
            JSONObject json = new JSONObject(jsonString);
            Pokemon pokemon = new Pokemon();
            pokemon.setNome(json.getString("nome"));
            pokemon.setDescricao(json.getString("descricao"));
            pokemon.setImagemId(json.getInt("imagemId"));
            pokemon.setSomId(json.getInt("somId"));
            ArrayList<Pokemon.TipoPokemon> tipos = new ArrayList<>();
            for (int i = 0; i < json.getJSONArray("tipos").length(); i++) {
                JSONObject jsonTipo = json.getJSONArray("tipos").getJSONObject(i);
                tipos.add(Pokemon.TipoPokemon.valueOf(jsonTipo.getString("nome")));
            }
            pokemon.setTipos(tipos);
            return pokemon;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONObject toJSONObject() {
        try {
            JSONObject json1 = new JSONObject();
            JSONArray jsonArray1 = new JSONArray();
            for (Pokemon.TipoPokemon tipo: tipos) {
                if (tipo == null) {
                    continue;
                }
                JSONObject jsonTipo = new JSONObject();
                jsonTipo.put("nome", tipo.getNome());
                jsonArray1.put(jsonTipo);
            }
            json1.put("tipos", jsonArray1);
            json1.put("nome", nome);
            json1.put("descricao", descricao);
            json1.put("imagemId", imagemId);
            json1.put("somId", somId);
            return json1;
        } catch (Exception e) {
            Log.e("ERRO", "Erro ao criar JSON");
            e.printStackTrace();
        }
        return null;
    }

    public enum TipoPokemon {
        FOGO("FOGO"),
        AGUA("AGUA"),
        ELETRICO("ELETRICO"),
        GRAMA("GRAMA"),
        VENENO("VENENO"),
        NORMAL("NORMAL"),
        LUTADOR("LUTADOR"),
        VOADOR("VOADOR"),
        TERRA("TERRA"),
        PEDRA("PEDRA"),
        GELO("GELO"),
        INSETO("INSETO"),
        FANTASMA("FANTASMA"),
        DRAGAO("DRAGAO"),
        METAL("METAL"),
        FADA("FADA"),
        SOMBRA("SOMBRA");

        private final String nome;

        TipoPokemon(String nome) {
            this.nome = nome;
        }

        @Override
        public String toString() {
            return "{" +
                    "\"nome\":\"" + nome + '\"' +
                    '}';
        }

        public String getNome() {
            return nome;
        }

    }

}

