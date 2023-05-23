package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.ErroDeConversaoException;

public class Titulo implements Comparable<Titulo> {
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento, boolean incluidoNoPlano, double somaDasAvaliacoes,
            int totalDeAvaliacoes, int duracaoEmMinutos) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.incluidoNoPlano = incluidoNoPlano;
        this.somaDasAvaliacoes = somaDasAvaliacoes;
        this.totalDeAvaliacoes = totalDeAvaliacoes;
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public Titulo(TituloOmdb tituloOmdb) {
        this.nome = tituloOmdb.title();

        // if (tituloOmdb.year().length() > 4) {
        //     throw new ErroDeConversaoException("Não foi possível converter para ano: <" + tituloOmdb.year() + ">");
        // }
        this.anoDeLancamento = Integer.valueOf(tituloOmdb.year().substring(0,4));
        try {
            this.duracaoEmMinutos = Integer.valueOf(tituloOmdb.runtime().substring(0, tituloOmdb.runtime().length() - 4));
        } catch (Exception e) {
            this.duracaoEmMinutos = 0;
        }
    }

    public void exibeFichaTecnica() {
        System.out.println("Nome do título: " + nome);
        System.out.println("Ano do lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double obterMedia() {
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setTotalDeAvaliacoes(int totalDeAvaliacoes) {
        this.totalDeAvaliacoes = totalDeAvaliacoes;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return this.anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public boolean getIncluidoNoPlano() {
        return this.incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return this.duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        if (this.getDuracaoEmMinutos() != 0) {
            return this.getNome() + " (" + this.getAnoDeLancamento() + ") - " + this.getDuracaoEmMinutos() + " min";
        } else {
            return this.getNome() + " (" + this.getAnoDeLancamento() + ")";
        }
    }

}
