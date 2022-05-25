package com.stapf.campominado;

import com.stapf.campominado.celula.Celula;
import com.stapf.campominado.celula.Simbolo;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Campo extends GridPane {

    /**
     * Número de linhas no jogo.
     */
    private int numeroLinhas;

    /**
     * Número de colunas no jogo.
     */
    private int numeroColunas;

    /**
     * Número de minas no jogo.
     */
    private int numeroMinas;

    private ArrayList<Celula> celulas = new ArrayList<>();

    private ArrayList<Celula> minas = new ArrayList<>();

    /**
     * Construtor padrão do Campo.
     */
    public Campo() {
        this.numeroLinhas = Dificuldade.INICIANTE.numeroMinas;
        this.numeroColunas = Dificuldade.INICIANTE.numeroColunas;
        this.numeroMinas = Dificuldade.INICIANTE.numeroMinas;
        criarMatriz();
    }

    public Campo(Dificuldade dificuldade) {
        this.numeroLinhas = dificuldade.numeroLinhas;
        this.numeroColunas = dificuldade.numeroColunas;
        this.numeroMinas = dificuldade.numeroMinas;
        criarMatriz();
    }

    /**
     * Randomiza a posição das minas dentro do campo, excluindo a posição (l,c) da matriz.
     * @param l linha da posição onde não terá bomba.
     * @param c coluna da posição onde não terá bomba.
     */
    public void randomizaMinas(int l, int c) {

        int totalCelulas = numeroLinhas * numeroColunas;

        List<Integer> listaCelulas = new ArrayList<>();
        for (int i = 0; i < totalCelulas; i++) listaCelulas.add(i + 1);
        listaCelulas.set((l * numeroColunas + c), 0);

        Random random = new Random();

        int minasAlocadas = 0;
        while (minasAlocadas < numeroMinas) {
            int r = random.nextInt(totalCelulas);
            if (listaCelulas.get(r) > 0) {
                listaCelulas.set(r, -1);
                minasAlocadas++;
            }
        }

        for (int i = 0; i < totalCelulas; i++) {
            switch (listaCelulas.get(i)) {
                case -1 -> celulas.get(i).setMinado(true);
                case 0 -> celulas.get(i).setSimbolo(Simbolo.PRESSIONADO);
                default -> celulas.get(i).setSimbolo(Simbolo.PADRAO);
            }
        }
    }

    private void criarMatriz() {

        int totalCelulas = numeroLinhas * numeroColunas;

        for (int i = 0, j = 0, k = 1; k < totalCelulas + 1; k++) {
            Celula celula = new Celula();
            celulas.add(celula);
            add(celula, j, i);
            j = k % numeroColunas;
            if (j == 0) i++;
        }

        setStyle("-fx-border-color: gray white white gray; -fx-border-width: 3; -fx-border-radius: 2");
    }

    private int minasVizinhasDaCelula(int indiceCelula) {

        /*
        | c_0 | c_1 | c_2 |
        | c_3 | c_X | c_4 |
        | c_5 | c_6 | c_7 |
         */

        int minasVizinhas = 0;

        int c0, c1, c2, c3, c4, c5, c6, c7;

        c0 = indiceCelula - numeroColunas - 1;
        c1 = indiceCelula - numeroColunas;
        c2 = indiceCelula - numeroColunas + 1;
        c3 = indiceCelula - 1;
        c4 = indiceCelula + 1;
        c5 = indiceCelula + numeroColunas - 1;
        c6 = indiceCelula + numeroColunas;
        c7 = indiceCelula + numeroColunas + 1;

        if (c0 >= 0 && celulas.get(c0).isMinado()) minasVizinhas++;
        if (c1 >= 0 && celulas.get(c1).isMinado()) minasVizinhas++;
        if (c2 >= 0 && celulas.get(c2).isMinado()) minasVizinhas++;
        if (c3 >= 0 && celulas.get(c3).isMinado()) minasVizinhas++;
        if (c4 >= 0 && celulas.get(c4).isMinado()) minasVizinhas++;
        if (c5 >= 0 && celulas.get(c5).isMinado()) minasVizinhas++;
        if (c6 >= 0 && celulas.get(c6).isMinado()) minasVizinhas++;
        if (c7 >= 0 && celulas.get(c7).isMinado()) minasVizinhas++;

        return minasVizinhas;
    }

}
