package com.example.harrypotterathomeinterface;

import com.example.harrypotterathomeinterface.controller.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    Stage window;
    @Override
    public void start(Stage stage) throws IOException {
        Game game = new Game(stage);
        game.createPlayer();
    }

    public static void main(String[] args) {
        launch();
    }
}