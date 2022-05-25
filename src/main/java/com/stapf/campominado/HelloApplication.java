package com.stapf.campominado;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//
        Campo campo = new Campo(Dificuldade.AVANCADO);
        campo.randomizaMinas(10, 10);
        Scene scene = new Scene(campo);
//        Celula celula = new Celula();
//        Scene scene = new Scene(celula);
        stage.setScene(scene);
        stage.show();

//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
    }

    public static void main(String[] args) {
        launch();

//        int tilesNumber = 100;
//        int bombsNumber = 20;
//
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < tilesNumber; i++) list.add(i+1);
//
//        Random random = new Random();
//        int r = random.nextInt(tilesNumber);
//        list.set(r, 0);
//
//        // 0 - clique inicial
//        // -1 - bomba
//        // > 0 - terreno livre
//
//        int j = 0;
//        while (j != bombsNumber) {
//            r = random.nextInt(tilesNumber);
//            if (list.get(r) > 0) { // terreno livre para colocar bomba
//                list.set(r, -1);
//                j++;
//            }
//        }
//
//        for (int i = 0; i < tilesNumber; i++) {
//            System.out.print(list.get(i) + " ");
//            if (i % 10 == 0) System.out.println();
//        }
    }
}