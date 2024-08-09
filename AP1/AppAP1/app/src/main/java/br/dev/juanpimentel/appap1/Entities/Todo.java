package br.dev.juanpimentel.appap1.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName="todo")

public class Todo {
    @PrimaryKey
    @NonNull
    private String id;

    @ColumnInfo(name="titulo")
    private  String titulo;

    @ColumnInfo(name="descricao")
    private  String descricao;

    public Todo(){
        this.id = UUID.randomUUID().toString();
    }

    public Todo(String titulo, String descricao){
        this.id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.descricao = descricao;
    }

    @NonNull
    public String toString(){
        return "Id: "+id+"Titulo: "+ "\n" + titulo + "\n" + "Descrição: " + descricao + "\n";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
