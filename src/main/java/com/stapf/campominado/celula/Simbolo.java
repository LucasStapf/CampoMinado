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
            pane.setStyle("-fx-background-color: silver;" +
                    "-fx-border-color: gray;");
            pane.getChildren().add(getText("1", Color.BLUE));

            return pane;
        }
    },

    DOIS {
        @Override
        public Pane getSimbolo() {
            Pane pane = new StackPane();
            pane.setStyle("-fx-background-color: silver;" +
                    "-fx-border-color: gray;");
            pane.getChildren().add(getText("2", Color.GREEN));
            return pane;
        }
    },

    TRES {
        @Override
        public Pane getSimbolo() {
            Pane pane = new StackPane();
            pane.setStyle("-fx-background-color: silver;" +
                    "-fx-border-color: gray;");
            pane.getChildren().add(getText("3", Color.RED));
            return pane;
        }
    },

    QUATRO {
        @Override
        public Pane getSimbolo() {
            Pane pane = new StackPane();
            pane.setStyle("-fx-background-color: silver;" +
                    "-fx-border-color: gray;");
            pane.getChildren().add(getText("4", Color.DARKBLUE));
            return pane;
        }
    },

    CINCO {
        @Override
        public Pane getSimbolo() {
            Pane pane = new StackPane();
            pane.setStyle("-fx-background-color: silver;" +
                    "-fx-border-color: gray;");
            pane.getChildren().add(getText("5", Color.DARKRED));
            return pane;
        }
    },

    SEIS {
        @Override
        public Pane getSimbolo() {
            Pane pane = new StackPane();
            pane.setStyle("-fx-background-color: silver;" +
                    "-fx-border-color: gray;");
            pane.getChildren().add(getText("6", Color.DARKGREEN));
            return pane;
        }
    },

    SETE {
        @Override
        public Pane getSimbolo() {
            Pane pane = new StackPane();
            pane.setStyle("-fx-background-color: silver;" +
                    "-fx-border-color: gray;");
            pane.getChildren().add(getText("7", Color.ORANGE));
            return pane;
        }
    },

    OITO {
        @Override
        public Pane getSimbolo() {
            Pane pane = new StackPane();
            pane.setStyle("-fx-background-color: silver;" +
                    "-fx-border-color: gray;");
            pane.getChildren().add(getText("8", Color.PURPLE));
            return pane;
        }
    };

    public abstract Pane getSimbolo();

    private static Text getText(String numero, Color color) {
        Text text = new Text();
        text.setText(numero);
        text.setFont(Font.font("Verdana", FontWeight.BOLD,14));
        text.setFill(color);
        return text;
    }
}
