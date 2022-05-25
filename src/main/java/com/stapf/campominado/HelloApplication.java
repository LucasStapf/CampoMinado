package com.stapf.campominado;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setScene(new Scene(Gerenciador.campo));
        stage.show();
    }

    public static void main(String[] args) {
        Gerenciador.iniciar();
        launch();
    }
}