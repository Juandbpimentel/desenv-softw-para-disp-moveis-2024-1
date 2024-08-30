package br.ufc.quixada.aula290824firebase.models;

public class Ativo {
    String nomeAtivo;
    String noticia;
    String data;

    public Ativo(){}

    public Ativo(String noticia, String nomeAtivo, String data) {
        this.noticia = noticia;
        this.nomeAtivo = nomeAtivo;
        this.data = data;
    }

    public String getNomeAtivo() {
        return nomeAtivo;
    }

    public void setNomeAtivo(String nomeAtivo) {
        this.nomeAtivo = nomeAtivo;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Ativo{" +
                "nomeAtivo='" + nomeAtivo + '\'' +
                ", noticia='" + noticia + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
