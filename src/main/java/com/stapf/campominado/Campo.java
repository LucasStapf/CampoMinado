package com.stapf.campominado;

import com.stapf.campominado.celula.Celula;
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

    private void criarMatriz() {

        int totalCelulas = numeroLinhas * numeroColunas;

        List<Integer> listaCelulas = new ArrayList<>();
        for (int i = 0; i < totalCelulas; i++) listaCelulas.add(i + 1);

        Random random = new Random();
        int r = random.nextInt(totalCelulas);
        listaCelulas.set(r, 0); // 0: indica onde o jogador irá clicar inicialmente;

        int minasAlocadas = 0;
        while (minasAlocadas < numeroMinas) {
            r = random.nextInt(totalCelulas);
            if (listaCelulas.get(r) > 0) {
                listaCelulas.set(r, -1);
                minasAlocadas++;
            }
        }

        for (int i = 0, j = 0, k = 1; k < totalCelulas + 1; k++) {
            Celula celula = new Celula();
            add(celula, j, i);
//            Button button = new Button();
//            button.setText(listaCelulas.get(k - 1).toString());
//            add(button, j, i);
            j = k % numeroColunas;
            if (j == 0) i++;
        }

//        setHgap(0.5);
//        setVgap(0.5);

        setStyle("-fx-border-color: gray white white gray; -fx-border-width: 3; -fx-border-radius: 2");
    }

}
