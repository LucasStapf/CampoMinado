package com.stapf.campominado.celula;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/*
1 - azul
2 - verde
3 - vermelho
4 - azul escuro
5 - vermelho escuro
6 -
7 -
8 -
 */
public enum Simbolo {

    PADRAO {
        @Override
        public Pane getSimbolo() {
            Pane pane = new AnchorPane();
            pane.setStyle("-fx-background-color: lightgray;" +
                    "-fx-border-color: white gray gray white;" +
                    "-fx-border-width: 2;" +
                    "-fx-border-radius: 1;");
            return pane;
        }
    },

    PRESSIONADO {
        @Override
        public Pane getSimbolo() {
            Pane pane = new AnchorPane();
            pane.setStyle("-fx-background-color: silver;" +
                    "-fx-border-color: gray;");
            return pane;
        }
    },

    UM {
        @Override
        public Pane getSimbolo() {

            Pane pane = new StackPane();
            pane.setStyle("-fx-background-color: darkgray; -fx-border-color: gray");
            pane.getChildren().add(getText("1", Color.BLUE));

            return pane;
        }
    },

    DOIS {
        @Override
        public Pane getSimbolo() {
            Pane pane = new StackPane();
            pane.setStyle("-fx-background-color: darkgray; -fx-border-color: gray");
            pane.getChildren().add(getText("2", Color.GREEN));
            return pane;
        }
    };

    public abstract Pane getSimbolo();

    private static Text getText(String numero, Color color) {
        Text text = new Text();
        text.setText(numero);
        text.setFont(Font.font("Verdana", FontWeight.BOLD,16));
        text.setFill(color);
        return text;
    }
}
