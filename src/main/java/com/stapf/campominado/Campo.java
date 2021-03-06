package com.stapf.campominado;

import com.stapf.campominado.celula.Celula;
import com.stapf.campominado.celula.Simbolo;
import com.stapf.campominado.celula.Status;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Iterator;
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

        setStyle("-fx-border-color: gray white white gray; -fx-border-width: 3; -fx-border-radius: 2");

        this.numeroLinhas = Dificuldade.INICIANTE.numeroMinas;
        this.numeroColunas = Dificuldade.INICIANTE.numeroColunas;
        this.numeroMinas = Dificuldade.INICIANTE.numeroMinas;
        criarMatriz();
    }

    public Campo(Dificuldade dificuldade) {

        setStyle("-fx-border-color: gray white white gray; -fx-border-width: 3; -fx-border-radius: 2");

        this.numeroLinhas = dificuldade.numeroLinhas;
        this.numeroColunas = dificuldade.numeroColunas;
        this.numeroMinas = dificuldade.numeroMinas;
        criarMatriz();
    }

    /**
     * Randomiza a posição das minas dentro do campo, excluindo a posição (l,c) da matriz.
     *
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
            if (listaCelulas.get(i) == -1) celulas.get(i).setMinado(true);
        }

        for (int i = 0; i < numeroLinhas; i++) {
            for (int j = 0; j < numeroColunas; j++) {
                celulas.get(indiceCelula(i,j)).setMinasVizinhas(minasVizinhasDaCelula(i,j));
            }
        }
    }

    /**
     * Cria todas as células e constrói a matriz base para o campo.
     */
    private void criarMatriz() {

        int totalCelulas = numeroLinhas * numeroColunas;

        for (int i = 0, j = 0, k = 1; k < totalCelulas + 1; k++) {
            Celula celula = new Celula();
            celulas.add(celula);
            add(celula, j, i);
            j = k % numeroColunas;
            if (j == 0) i++;
        }
    }

    /**
     * Contabiliza o número de minas ao redor de uma determinada célula (linha, coluna) e retorna esse valor.
     * @param linha linha onde se encontra a célula.
     * @param coluna coluna onde se encontra a célula.
     * @return o número de minas vizinhas à célula.
     */
    private int minasVizinhasDaCelula(int linha, int coluna) {

        /*
        | c_0 | c_1 | c_2 |
        | c_3 | c_X | c_4 |
        | c_5 | c_6 | c_7 |
         */

        int minasVizinhas = 0;

        int c0, c1, c2, c3, c4, c5, c6, c7;

        if (linha - 1 >= 0) {
            if (coluna - 1 >= 0) {
                c0 = indiceCelula(linha - 1, coluna - 1);
                if (celulas.get(c0).isMinado()) minasVizinhas++;
            }

            c1 = indiceCelula(linha - 1, coluna);
            if (celulas.get(c1).isMinado()) minasVizinhas++;

            if (coluna + 1 < numeroColunas) {
                c2 = indiceCelula(linha - 1, coluna + 1);
                if (celulas.get(c2).isMinado()) minasVizinhas++;
            }
        }

        if (coluna - 1 >= 0) {
            c3 = indiceCelula(linha, coluna - 1);
            if (celulas.get(c3).isMinado()) minasVizinhas++;
        }

        if (coluna + 1 < numeroColunas) {
            c4 = indiceCelula(linha, coluna + 1);
            if (celulas.get(c4).isMinado()) minasVizinhas++;
        }

        if (linha + 1 < numeroLinhas) {

            if (coluna - 1 >= 0) {
                c5 = indiceCelula(linha + 1, coluna - 1);
                if (celulas.get(c5).isMinado()) minasVizinhas++;
            }

            c6 = indiceCelula(linha + 1, coluna);
            if (celulas.get(c6).isMinado()) minasVizinhas++;

            if (coluna + 1 < numeroColunas) {
                c7 = indiceCelula(linha + 1, coluna + 1);
                if (celulas.get(c7).isMinado()) minasVizinhas++;
            }
        }

        return minasVizinhas;
    }

    /**
     * Retorna o índice da célula no vetor de células baseando-se na sua posição na matriz do campo.
     * @param linha linha da célula.
     * @param coluna coluna da célula.
     * @return o índice da célula no vetor de células.
     */
    private int indiceCelula(int linha, int coluna) {
        return linha * numeroColunas + coluna;
    }

    public void ativarCelulasVizinhasSemBombas(Celula celula) {

        for (int i = 0; i < numeroLinhas; i++) {
            for (int j = 0; j < numeroColunas; j++) {
                if (celulas.get(indiceCelula(i,j)).equals(celula)) {
                    ativarCelulasVizinhasSemBombas(i, j);
                    return;
                }
            }
        }
    }

    public void ativarCelulasVizinhasSemBombas(int linha, int coluna) {

        if (celulas.get(indiceCelula(linha, coluna)).getStatus() == Status.ATIVADA) return;

        // padrão: cima, direita, baixo, esquerda
        celulas.get(indiceCelula(linha, coluna)).setStatus(Status.ATIVADA);

        if (celulas.get(indiceCelula(linha, coluna)).getMinasVizinhas() > 0
                && !celulas.get(indiceCelula(linha, coluna)).isMinado()) return;

        if (linha - 1 >= 0) {
            if (!celulas.get(indiceCelula(linha - 1, coluna)).isMinado())
                ativarCelulasVizinhasSemBombas(linha - 1, coluna);
        }

        if (coluna + 1 < numeroColunas) {
            if (!celulas.get(indiceCelula(linha, coluna + 1)).isMinado())
                ativarCelulasVizinhasSemBombas(linha, coluna + 1);
        }

        if (linha + 1 < numeroLinhas) {
            if (!celulas.get(indiceCelula(linha + 1, coluna)).isMinado())
                ativarCelulasVizinhasSemBombas(linha + 1, coluna);
        }

        if (coluna - 1 >= 0) {
            if (!celulas.get(indiceCelula(linha, coluna - 1)).isMinado())
                ativarCelulasVizinhasSemBombas(linha, coluna - 1);
        }
    }
}
