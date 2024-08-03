package br.dev.juanpimentel.appaula01_08_24.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName="program_boy")

public class ProgramBoy {
    @PrimaryKey
    @NonNull
    private String id;
    @ColumnInfo(name="nome")
    private  String nome;
    @ColumnInfo(name="area_de_programacao")
    private  String AreaDeProgramacao;
    @ColumnInfo(name="idade")
    private int idade;

    public ProgramBoy(){
        this.id = UUID.randomUUID().toString();
    }

    public ProgramBoy(String nome, String AreaDeProgramacao, int idade){
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.AreaDeProgramacao = AreaDeProgramacao;
        this.idade = idade;
    }

    public String toString(){
        return "Id: "+id+"Nome: "+ "\n" + nome + "\n" + "Área de programação: " + AreaDeProgramacao + "\n" + "Idade: " + idade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAreaDeProgramacao() {
        return AreaDeProgramacao;
    }

    public void setAreaDeProgramacao(String areaDeProgramacao) {
        AreaDeProgramacao = areaDeProgramacao;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
