package com.example.projetointegracaofrontend;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.application.Application;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Image icon = new javafx.scene.image.Image(getClass().getResourceAsStream("/icon/Projeto-Integracao-Frontend-1.0-SNAPSHOT.png"));
        stage.getIcons().add(icon);
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Projeto Integração");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}