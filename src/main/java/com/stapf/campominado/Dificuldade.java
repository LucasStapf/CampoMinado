package com.stapf.campominado;

public enum Dificuldade {

    INICIANTE(9,9,10),
    INTERMEDIARIO(16,16,40),
    AVANCADO(20,24,99);

    public final int numeroLinhas;
    public final int numeroColunas;
    public final int numeroMinas;

    Dificuldade(int numeroLinhas, int numeroColunas, int numeroMinas) {
        this.numeroLinhas = numeroLinhas;
        this.numeroColunas = numeroColunas;
        this.numeroMinas = numeroMinas;
    }
}
