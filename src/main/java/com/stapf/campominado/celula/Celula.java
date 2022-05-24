package com.stapf.campominado.celula;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class Celula extends StackPane {

    /**
     * Tamanho do lado da célula.
     */
    private int tamanhoLado = 20;

    private Simbolo simbolo = Simbolo.PADRAO;
    public Celula() {
        setMinSize(tamanhoLado, tamanhoLado);
        setPrefSize(tamanhoLado, tamanhoLado);
        setMaxSize(tamanhoLado, tamanhoLado);
        addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent);
        atualizaSimbolo();
    }

    private void atualizaSimbolo() {
        getChildren().clear();
        getChildren().add(simbolo.getSimbolo());
    }

    private EventHandler<MouseEvent> mouseEvent = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getButton() == MouseButton.PRIMARY) simbolo = Simbolo.PRESSIONADO;
            else if (mouseEvent.getButton() == MouseButton.SECONDARY) simbolo = Simbolo.BANDEIRA;
            atualizaSimbolo();
        }
    };

}
