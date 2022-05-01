package br.com.collections.map;

import java.util.*;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {
        System.out.println("- Ordem aleatória");
        Map<String, Livro> meusLivros = new HashMap<>(){{
            put(" Hwking, Stephen",new Livro("Uma Breve História do Tempo",256));
            put(" Duhigg, Charles", new Livro("O Poder do Hábito",408));
            put(" Harari, Yuval Noah", new Livro("21 Lições Para o Século 21",432));
        }};

        for(  Map.Entry<String,Livro> livro : meusLivros.entrySet()){
            System.out.println(livro.getKey() + " - "+ livro.getValue());
        }

        System.out.println("\n- Ordem Inserçãp");
        Map<String, Livro> meusLivros2 = new LinkedHashMap<>(){{
            put(" Hwking, Stephen",new Livro("Uma Breve História do Tempo",256));
            put(" Duhigg, Charles", new Livro("O Poder do Hábito",408));
            put(" Harari, Yuval Noah", new Livro("21 Lições Para o Século 21",432));
        }};

        for(  Map.Entry<String,Livro> livro : meusLivros2.entrySet()){
            System.out.println(livro.getKey() + " - "+ livro.getValue());
        }

        System.out.println("\n- Ordem alfabética dos autores");
        Map<String, Livro> meusLivros3 = new TreeMap<>(meusLivros2);

        for(  Map.Entry<String,Livro> livro : meusLivros3.entrySet()){
            System.out.println(livro.getKey() + " - "+ livro.getValue());
        }

        System.out.println("\n- Ordem alfabética dos livros");

        Set<Map.Entry<String,Livro>> meusLivros4 = new TreeSet<>(new ComparatorNome());
        meusLivros4.addAll(meusLivros.entrySet());

        for(  Map.Entry<String,Livro> livro : meusLivros4){
            System.out.println(livro.getKey() + " - "+ livro.getValue());
        }
    }
}

class Livro{
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(nome, livro.nome) && Objects.equals(paginas, livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "{" +
                " nome: '" + nome + '\'' +
                ", paginas: " + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String,Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> o1, Map.Entry<String, Livro> o2) {
        return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
    }
}