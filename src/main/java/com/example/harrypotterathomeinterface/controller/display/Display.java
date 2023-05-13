package com.example.harrypotterathomeinterface.controller.display;

import com.example.harrypotterathomeinterface.controller.Characters.ennemies.AbstractEnemy;
import com.example.harrypotterathomeinterface.controller.Characters.spells.Spell;
import com.example.harrypotterathomeinterface.controller.Characters.wizards.House;
import com.example.harrypotterathomeinterface.controller.Characters.wizards.Pet;
import com.example.harrypotterathomeinterface.controller.Characters.wizards.Potion;
import com.example.harrypotterathomeinterface.controller.Characters.wizards.Wizard;
import com.example.harrypotterathomeinterface.controller.Game;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Optional;

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

    public void playerTurn(){
        GridPane gridPane = new GridPane();



        //Enemy stats
        AbstractEnemy enemy = game.getCurrentLevel().getCurrentEnemy();
        Label levelLabel = new Label("Level : "+game.getLevel());
        Label turnLabel = new Label("Turn : "+game.getTurn());
        Label enemyName = new Label("Enemy :"+enemy.getName());
        Label enemyHealth = new Label("Health : "+enemy.getHp());
        int nbBosses = 0;
        int nbEnemies = 0;
        if (game.getCurrentLevel().getBosses()!=null){
            nbBosses = game.getCurrentLevel().getBosses().length;
        }
        if (game.getCurrentLevel().getEnemies()!=null){
            nbEnemies = game.getCurrentLevel().getEnemies().length;
        }
        Label enemiesNumber = new Label("Number of enemy left : "+(nbBosses+nbEnemies));

        VBox enemyBox = new VBox(levelLabel,turnLabel,enemyName,enemyHealth, enemiesNumber);


        Label label4 = new Label("text");

        //Your stats
        Wizard player = game.getPlayer();
        Label playerHealth = new Label("Your health : "+player.getHp());
        Label playerDamage = new Label("You deal x"+player.getDamageMultiplier()+" damages");
        Label playerPrecision = new Label("Your precision multiplier : "+player.getPrecision());
        VBox playerBox = new VBox(playerHealth, playerDamage,playerPrecision);



        GridPane buttons = new GridPane();
        Button spellButton = new Button("Spells");
        Button itemButton = new Button("Items");
        Button defendButton = new Button("Defend");

        buttons.add(spellButton,0,0);
        buttons.add(itemButton,1,0);
        buttons.add(defendButton,0,1);

        gridPane.setGridLinesVisible(true);
        //gridPane.add(label2, 0,0,4,1);
        for(int c=0;c<3;c++){
            ColumnConstraints column = new ColumnConstraints(250);
            gridPane.getColumnConstraints().add(column);
        }
        for(int i=0;i<2;i++){
            RowConstraints row = new RowConstraints(100);
            gridPane.getRowConstraints().add(row);
        }
        gridPane.add(enemyBox,0,1,1,2);
        gridPane.add(label4, 1,0,2,1);
        gridPane.add(buttons,1,1,2,1);
        gridPane.add(playerBox, 2,1,1,2);
        Scene scene = new Scene(gridPane,750,750);
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();



        spellButton.setOnMouseClicked((e)->{
            buttons.getChildren().clear();
            VBox spellsBox =new VBox();
            for (int i=0;i<player.getKnownSpells().length;i++){
                Spell currentSpell = player.getKnownSpells()[i];
                Button newButton = new Button(currentSpell.toString());
                newButton.setOnAction(a->{
                    currentSpell.use(enemy, game.getCurrentLevel(),player,this);
                    game.setTurn(game.getTurn()+1);
                    game.endTurn();
                });
                buttons.add(newButton,i%3,i%2);
            }

        });

        itemButton.setOnAction((e)->{
            buttons.getChildren().clear();
            for (int i=0;i<player.getPotions().length;i++){
                Potion currentItem = player.getPotions()[i];
                Button newButton = new Button(currentItem.getName());
                newButton.setOnAction(a->{
                    currentItem.use(enemy,player,this);
                    game.setTurn(game.getTurn()+1);
                    game.endTurn();
                });
                buttons.getChildren().add(newButton);
            }

        });

        defendButton.setOnAction(e->{
            player.setDefend(1);
            game.setTurn(game.getTurn()+1);
            game.endTurn();
        });


    }

    public void alert(String message){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public int endLevelChoice(){
        Alert choiceBox = new Alert(Alert.AlertType.CONFIRMATION);
        choiceBox.setContentText("You cleared the level !\n You can choose to increase your health or your damages");
        ButtonType health = new ButtonType("Health");
        ButtonType damages = new ButtonType("Damages");
        choiceBox.getButtonTypes().setAll(health,damages);
        Optional<ButtonType> result = choiceBox.showAndWait();
        if (result.get()==health){
            return 1;
        }
        else{
            return 2;
        }
    }

    public void close(){
        stage.close();
    }

    public int loyaltyChoice(){
        Alert choiceBox = new Alert(Alert.AlertType.CONFIRMATION);
        choiceBox.setContentText("As a slytherin, you must choose : will you betray your friends or stay loyal to them ?");
        ButtonType loyal = new ButtonType("Stay loyal");
        ButtonType betray = new ButtonType("Betray");
        choiceBox.getButtonTypes().setAll(loyal,betray);
        Optional<ButtonType> result = choiceBox.showAndWait();
        if (result.get()==loyal){
            return 1;
        }
        else{
            return 2;
        }
    }
}

