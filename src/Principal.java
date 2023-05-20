import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) throws Exception {
        Filme meuFilme = new Filme("Poderoso Chefão", 1970, false, 0.0,
         0, 180, "XX");

        //meuFilme.exibeFichaTecnica();
        meuFilme.avalia(9);
        meuFilme.avalia(8);
        meuFilme.avalia(7);

        // System.out.println(meuFilme.obterMedia());
        // System.out.println(meuFilme.getTotalDeAvaliacoes());

        Serie lost = new Serie("Lost", 2000, false,
            0, 0, 5, 10, 10, false, 50);
        //lost.exibeFichaTecnica();

        Filme f1 = new Filme("Poderoso Chefão 2", 1980, false, 0.0,
        0, 120, "XX");

        Filme f2 = new Filme("Poderoso Chefão 3", 1990, false, 0.0,
         0, 150, "XX");

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(f1);
        calculadora.inclui(f2);
        calculadora.inclui(lost);

        //System.out.println(calculadora.getTempoTotal());

        Episodio epi = new Episodio(1, "Episódio Piloto", lost, 10);

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(epi);
        
    }
}
