package com.stapf.campominado;

public class Gerenciador {

    public static Campo campo;

    public static void iniciar() {
        campo = new Campo(Dificuldade.AVANCADO);
        campo.randomizaMinas(0,0);
    }

}
