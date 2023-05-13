package com.example.harrypotterathomeinterface.controller.Characters.spells;


import com.example.harrypotterathomeinterface.controller.Characters.Character;
import com.example.harrypotterathomeinterface.controller.Characters.ennemies.Boss;
import com.example.harrypotterathomeinterface.controller.Characters.ennemies.Enemy;
import com.example.harrypotterathomeinterface.controller.Characters.wizards.Wizard;
import com.example.harrypotterathomeinterface.controller.display.Display;
import com.example.harrypotterathomeinterface.controller.levels.Level;

import java.util.concurrent.ThreadLocalRandom;

public class Spell extends AbstractSpell{

    private String name;
    private int effect;
    private int probability;


    public Spell(String name, int probability, int effect){
        this.name=name;
        this.probability = probability;
        this.effect = effect;
    }

    public void use(Character target, Level level, Wizard player, Display ds){
        if (ThreadLocalRandom.current().nextInt(0,101)<=probability*player.getPrecision()) {
            switch (effect) {
                case 0:
                    ds.printText("You stand defenseless as your spell deals little to no damage to your foe");
                    break;
                case 1:
                    leviosa(target, ds);
                    break;
                case 2:
                    target.setHp(target.getHp()-(int)(30*player.getDamageMultiplier()));
                    break;
                case 3:
                    level.setEnemies(new Enemy[]{null});
                    level.setBosses(new Boss[]{null});
                    break;
                case 4:
                    target.setHp(target.getHp()-(int)(50* player.getDamageMultiplier()));
            }

        }
        else{
            ds.printText("You fail to cast the spell !");
        }
    }

    public static void leviosa(Character enemy, Display ds){

        enemy.setHp(0);

    }
    @Override
    public String toString() {
        return name;
    }
}
