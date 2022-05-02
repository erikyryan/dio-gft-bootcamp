package br.com.collections.set;


import java.util.*;

public class ExemploOrdenacaoSet {
    public static void main(String[] args) {
        System.out.println("\n - Ordem Aleatória");
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("got","fantasia",60));
            add(new Serie("dark","drama",60));
            add(new Serie("that 70s show","comedia",25));
        }};

        for(Serie serie : minhasSeries){
            System.out.println("\n\tNome: " + serie.getNome() +
                    " Genero: " + serie.getGenero() +
                    " Duracao: "+ serie.getTempoDeEpisodio());
        }

        System.out.println("\n\n - Ordem de inserção");
        Set<Serie> minhasSeries2 = new LinkedHashSet<>(minhasSeries);

        for(Serie serie : minhasSeries2){
            System.out.println("\n\tNome: " + serie.getNome() +
                    " Genero: " + serie.getGenero() +
                    " Duracao: "+ serie.getTempoDeEpisodio());
        }

        System.out.println("\n\n - Ordem Natural(tempoEpisodio)");
        Set<Serie> minhasSeries3 = new TreeSet<>(minhasSeries2);

        for(Serie serie : minhasSeries3){
            System.out.println("\n\tNome: " + serie.getNome() +
                    " Genero: " + serie.getGenero() +
                    " Duracao: "+ serie.getTempoDeEpisodio());
        }

        System.out.println("\n\n - Ordem Nome/Genero/TempoEpisodio");
        Set<Serie> minhasSeries4 = new TreeSet<>(new ComparatorNomeGeneroEpisodio());
        minhasSeries4.addAll(minhasSeries);
        for(Serie serie : minhasSeries4){
            System.out.println("\n\tNome: " + serie.getNome() +
                    " Genero: " + serie.getGenero() +
                    " Duracao: "+ serie.getTempoDeEpisodio());
        }
    }

}

class ComparatorNomeGeneroEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie o1, Serie o2) {

        int nome = o1.getNome().compareTo(o2.getNome());
        if(nome != 0) return nome;

        int genero = o1.getGenero().compareTo( o2.getGenero());
        if(genero != 0) return genero;

        return Integer.compare(o1.getTempoDeEpisodio(),o2.getTempoDeEpisodio());
    }
}

