package com.stapf.campominado.celula;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class Celula extends StackPane {

    /**
     * Tamanho do lado da célula. Por padrão, o tamanho inicial é 20.
     */
    private int tamanhoLado = 20;

    /**
     * Número de minas ao redor da célula.
     */
    private int minasVizinhas = 0;

    /**
     * Indica qual simbolo será representado na célula.
     */
    private Simbolo simbolo = Simbolo.PADRAO;

    private Status status = Status.AGUARDANDO;

    public Celula() {
        setMinSize(tamanhoLado, tamanhoLado);
        setPrefSize(tamanhoLado, tamanhoLado);
        setMaxSize(tamanhoLado, tamanhoLado);
        addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent);
        atualizaSimbolo();
    }

    public Simbolo getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(Simbolo simbolo) {
        this.simbolo = simbolo;
        atualizaSimbolo();
    }

    private void atualizaSimbolo() {

        getChildren().clear();

        if (status == Status.AGUARDANDO) {
            getChildren().add(Simbolo.PADRAO.getSimbolo());
        } else if (status == Status.BLOQUEADA) {
            getChildren().add(Simbolo.BANDEIRA.getSimbolo());
        } else if (status == Status.ATIVADA) {
            if (!minado) {
                switch (minasVizinhas) {
                    case 1 -> getChildren().add(Simbolo.UM.getSimbolo());
                    case 2 -> getChildren().add(Simbolo.DOIS.getSimbolo());
                    case 3 -> getChildren().add(Simbolo.TRES.getSimbolo());
                    case 4 -> getChildren().add(Simbolo.QUATRO.getSimbolo());
                    case 5 -> getChildren().add(Simbolo.CINCO.getSimbolo());
                    case 6 -> getChildren().add(Simbolo.SEIS.getSimbolo());
                    case 7 -> getChildren().add(Simbolo.SETE.getSimbolo());
                    case 8 -> getChildren().add(Simbolo.OITO.getSimbolo());
                    default -> getChildren().add(Simbolo.PRESSIONADO.getSimbolo());
                }
            } else getChildren().add(Simbolo.BOMBA.getSimbolo());
        }
    }

    private EventHandler<MouseEvent> mouseEvent = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {

            if (mouseEvent.getButton() == MouseButton.PRIMARY) {

                if (status != Status.AGUARDANDO) return;
                else status = Status.ATIVADA;

                atualizaSimbolo();

            } else if (mouseEvent.getButton() == MouseButton.SECONDARY) {

                if (status == Status.AGUARDANDO) {

                    status = Status.BLOQUEADA;
                    simbolo = Simbolo.BANDEIRA;
                    atualizaSimbolo();

                } else if (status == Status.BLOQUEADA) {

                    status = Status.AGUARDANDO;
                    simbolo = Simbolo.PADRAO;
                    atualizaSimbolo();

                }
            }
        }
    };

    /**
     * Resposável por guardar a informação se existe uma mina ou não na célula.
     */
    private boolean minado = false;

    /**
     * Retorna verdadeiro se a célula possui mina, falso caso contrário.
     * @return verdadeiro se a célula possui mina, falso caso contrário.
     */
    public boolean isMinado() {
        return minado;
    }

    /**
     * Altera a existência ou não de mina na célula.
     * @param minado
     */
    public void setMinado(boolean minado) {
        this.minado = minado;
    }


}
