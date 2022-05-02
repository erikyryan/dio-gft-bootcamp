package br.com.collections.set;

import java.util.Objects;

public class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer tempoDeEpisodio;

    public Serie(String nome, String genero, Integer tempoDeEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoDeEpisodio = tempoDeEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getTempoDeEpisodio() {
        return tempoDeEpisodio;
    }

    public void setTempoDeEpisodio(Integer tempoDeEpisodio) {
        this.tempoDeEpisodio = tempoDeEpisodio;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoDeEpisodio=" + tempoDeEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie series = (Serie) o;
        return Objects.equals(nome, series.nome) && Objects.equals(genero, series.genero)
                && Objects.equals(tempoDeEpisodio, series.tempoDeEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoDeEpisodio);
    }

    @Override
    public int compareTo(Serie o) {
        int tempoEpisodio = Integer.compare(this.getTempoDeEpisodio(), o.getTempoDeEpisodio());
        if(tempoEpisodio != 0) return tempoEpisodio;

        return this.getGenero().compareTo(o.getGenero());
    }
}
