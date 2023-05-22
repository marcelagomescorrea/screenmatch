package br.com.alura.screenmatch.principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Poderoso Chefão", 1970, false, 0.0,
         0, 180, "XX");
        meuFilme.avalia(9);

        Serie lost = new Serie("Lost", 2000, false,
            0, 0, 5, 10, 10, false, 50);
        lost.avalia(8);

        Filme f1 = new Filme("Poderoso Chefão 2", 1980, false, 0.0,
        0, 120, "XX");
        f1.avalia(6);

        Filme f2 = new Filme("Poderoso Chefão 3", 1990, false, 0.0,
        0, 150, "XX");
        f2.avalia(7);

        Filme f3 =  new Filme("Dogville", 2003, false, 0, 0, 200, null);
        f3.avalia(6);

        ArrayList<Titulo> assistidos = new ArrayList<>();
        assistidos.add(f3);
        assistidos.add(f2);
        assistidos.add(f1);
        assistidos.add(meuFilme);
        assistidos.add(lost);

        // for (Titulo item : assistidos) {
        //     System.out.println(item.getNome());

        //     if (item instanceof Filme filme && filme.getClassificacao() > 2) {
        //         System.out.println("Classificação: " + filme.getClassificacao());
        //     }
        //     System.out.println("");
        // }

        List<String> busca = new ArrayList<>();
        busca.add("Ana");
        busca.add("Paulo");
        busca.add("João");

        // System.out.println(busca);
        // Collections.sort(busca);
        // System.out.println("Com ordenação: " + busca);

        Collections.sort(assistidos);
        System.out.println("Lista de assistidos ordenados: ");
        System.out.println(assistidos);

        assistidos.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("\nLista de assistidos ordenados pelo ano de lançamento: ");  
        System.out.println(assistidos);

    }   
}
