package com.example.harrypotterathomeinterface.controller.display;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Optional;
import java.util.Scanner;

public class Display {
    private Stage stage;
    public Display(Stage stage){
        this.stage=stage;
        Button next =new Button("START");
        VBox layout = new VBox();
        layout.getChildren().add(next);
        Scene scene = new Scene(layout, 1000,1000);
        stage.setScene(scene);
        stage.show();


    }
    public void printText(String text) {
        System.out.println(text);
    }

    public void displayLevel(int level, String state, boolean isEvil) {
        String fileName = "/" + String.valueOf(level) + state + "Text.txt";
        if(isEvil) {
            fileName = "/" + String.valueOf(level) + state + "TextEvil.txt";
        }

        Scanner fileSc = new Scanner(getClass().getResourceAsStream(fileName));
        while (fileSc.hasNextLine()) {
            System.out.println(fileSc.nextLine());
        }


    }
    public void displayParagraph(String paragraph){
        Text text = new Text();
        text.setText(paragraph);
        HBox layout = new HBox();
        Button next = new Button("Next");
        layout.getChildren().add(text);
        layout.getChildren().add(next);
        Scene scene = new Scene(layout);
        stage.setScene(scene);




    }
    public void displayLevelImage(int level,String state,boolean isEvil){
        String fileName = "/" + state+String.valueOf(level) + ".jpg";
        if(isEvil) {
            fileName = "/" + state+String.valueOf(level) + "Evil.jpg";
        }
        Image image = new Image(fileName);
        ImageView imageView = new ImageView(image);
        GridPane imageLayout = new GridPane();
        imageLayout.getChildren().add(imageView);
        Scene newScene = new Scene(imageLayout,320,240);
        stage.setScene(newScene);

    }

    public String getString(String message){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(message);
        dialog.setHeaderText(message);
        Optional<String>result = dialog.showAndWait();
        while(true) {
            if (result.isPresent() && !result.isEmpty()) {
                return result.get();
            }
        }

    }

    public int makeChoice(String message, int numberOfChoices){
        Dialog dialog = new Dialog<>();
        dialog.setTitle(message);

        VBox buttons = new VBox();
        for(int i = 0;i<numberOfChoices;i++){
            Button b = new Button(Integer.toString(i+1));
            int finalI = i;
            b.setOnMouseClicked((e)->{dialog.setResult(finalI);});
            buttons.getChildren().add(b);
        }
        dialog.getDialogPane().getChildren().add(buttons);
        Optional<Integer>result = dialog.showAndWait();
        while(true) {
            if (result.isPresent() && !result.isEmpty()) {
                dialog.close();
                return result.get();
            }
        }

    }
}

