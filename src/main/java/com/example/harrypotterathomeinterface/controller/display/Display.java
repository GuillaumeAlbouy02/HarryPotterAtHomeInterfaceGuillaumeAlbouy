package com.example.harrypotterathomeinterface.controller.display;

import com.example.harrypotterathomeinterface.controller.Characters.wizards.House;
import com.example.harrypotterathomeinterface.controller.Characters.wizards.Pet;
import com.example.harrypotterathomeinterface.controller.Game;
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
    private Game game;
    public Display(Stage stage, Game game){
        this.stage=stage;
        this.game = game;




    }
    public void printText(String text) {
        System.out.println(text);
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







    public void dsCreatePlayer(){
        VBox layout = new VBox();

        //Name
        Label nameLabel = new Label("Name :");
        TextArea nameArea = new TextArea();
        HBox nameBox = new HBox(nameLabel,nameArea);

        //Pet
        RadioButton owl = new RadioButton("Owl");
        owl.setSelected(true);
        RadioButton rat = new RadioButton("Rat");
        RadioButton cat = new RadioButton("Cat");
        RadioButton toad = new RadioButton("Toad");
        ToggleGroup petGroup = new ToggleGroup();
        owl.setToggleGroup(petGroup);
        rat.setToggleGroup(petGroup);
        cat.setToggleGroup(petGroup);
        toad.setToggleGroup(petGroup);
        HBox petBox = new HBox(owl,rat,cat,toad);

        //Wand
        Label wand = new Label("You were chosen by a "+game.getPlayer().getWand().getSize() + " inches wand, with a " + game.getPlayer().getWand().getCore().name() + " core");

        //House
        RadioButton gryffindor = new RadioButton("Gryffindor");
        gryffindor.setSelected(true);
        RadioButton ravenclaw = new RadioButton("RavenClaw");
        RadioButton hufflepuff = new RadioButton("Hufflepuff");
        RadioButton slytherin = new RadioButton("Slytherin");
        ToggleGroup houseGroup = new ToggleGroup();
        gryffindor.setToggleGroup(houseGroup);
        ravenclaw.setToggleGroup(houseGroup);
        hufflepuff.setToggleGroup(houseGroup);
        slytherin.setToggleGroup(houseGroup);
        HBox houseBox = new HBox(gryffindor,ravenclaw,hufflepuff,slytherin);

        Button okButton = new Button("Create");
        okButton.setOnAction(e->{
            game.getPlayer().setName(nameArea.getText());
            if (petGroup.getSelectedToggle()==owl){
                game.getPlayer().setPet(Pet.OWL);
            }
            else if(petGroup.getSelectedToggle()==rat){
                game.getPlayer().setPet(Pet.RAT);
            }
            else if(petGroup.getSelectedToggle()==cat){
                game.getPlayer().setPet(Pet.CAT);
            }
            else{
                game.getPlayer().setPet(Pet.TOAD);
            }


            if (houseGroup.getSelectedToggle()==gryffindor){
                game.getPlayer().setHouse(House.GRYFFINDOR);
                game.getPlayer().setDefense(0.5f);
            }
            else if(houseGroup.getSelectedToggle()==hufflepuff){
                game.getPlayer().setHouse(House.HUFFLEPUFF);
            }
            else if(houseGroup.getSelectedToggle()==ravenclaw){
                game.getPlayer().setHouse(House.RAVENCLAW);
                game.getPlayer().setPrecision(1.3f);
            }
            else{
                game.getPlayer().setHouse(House.SLYTHERIN);
                game.getPlayer().setDamageMultiplier(1.5);
            }

            game.play();
        });

        layout.getChildren().addAll(nameBox,petBox,wand,houseBox, okButton);
        Scene scene = new Scene(layout,700,700);
        stage.setScene(scene);
        stage.show();


    }
}

