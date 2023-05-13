package com.example.harrypotterathomeinterface.controller;

import com.example.harrypotterathomeinterface.controller.Characters.wizards.House;
import com.example.harrypotterathomeinterface.controller.Characters.wizards.Wizard;
import com.example.harrypotterathomeinterface.controller.display.Display;

public class SortingHat {
    public static void chooseHouse(Wizard player, SafeScanner sc, Display ds){
        ds.printText("You are now at the opening banquet of the year at Hogwarts, and the time has come for you to be assigned to one of the four houses.");
        ds.printText("The sorting hat is placed upon your head, and after a brief moment of consideration, it asks you : which house would you prefer ?");
        int choix=-1;
        while(!(choix<5 && choix>0)){
            choix = sc.getInt2("Type 1 for Gryffindor, 2 for Slytherin, 3 for Hufflepuff or 4 for Ravenclaw");
        }
        player.setHouse(House.values()[choix-1]);

        ds.printText("You were assigned to "+ player.getHouse().name());


    }

}
