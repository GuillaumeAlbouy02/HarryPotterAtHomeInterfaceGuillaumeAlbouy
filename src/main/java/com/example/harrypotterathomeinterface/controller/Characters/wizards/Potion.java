package com.example.harrypotterathomeinterface.controller.Characters.wizards;

import com.example.harrypotterathomeinterface.controller.Characters.Character;
import com.example.harrypotterathomeinterface.controller.display.Display;
import lombok.Getter;
import lombok.Setter;


public class Potion {

    //This class could be renamed "Items" since it represents all the items and not only the potions

    private @Getter @Setter String name;
    private @Getter int effect;
    private @Getter @Setter int useNumber;
    public Potion(String name, int effect, int useNumber){
        this.name = name;
        this.effect = effect;
        this.useNumber = useNumber;

    }

    public void use(Character enemy, Wizard player, Display ds){
        if(useNumber>0) {
            switch (effect) {
                case 0: //health potion
                    ds.printText("You drink a healing potion");
                    heal(player, ds);
                    break;
                case 1: //case of the Basilic's fang and Gryffindor's sword
                    enemy.setHp(0);

            }
            setUseNumber(getUseNumber()-1);

        }
        else{
            ds.printText("You don't have any of those left !");
        }

    }
    public void heal(Wizard player, Display ds){
        if(player.getHp()<player.getMaxHealth()){
            if (player.getHouse()== House.HUFFLEPUFF){          //If the player is from Hufflepuff, the potion is more efficient
                if (player.getHp()< player.getMaxHealth()-15){
                    player.setHp(player.getHp()+15);
                }
                else{
                    player.setHp(player.getMaxHealth());
                }
            }
            else {
                if (player.getHp() <= player.getMaxHealth() - 10) {             //The potion replenishes 10 hp, exept if the player has lost less than 10hp, in which case it replenishes all the health
                    player.setHp(player.getHp() + 10);
                } else {
                    player.setHp(player.getMaxHealth());
                }
            }
        }
        else{
            ds.printText("You cannot heal yourself as you are not wounded... yet");
        }
    }
    public String toString(){
        return name;
    }
}
