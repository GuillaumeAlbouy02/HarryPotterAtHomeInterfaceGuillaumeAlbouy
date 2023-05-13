package com.example.harrypotterathomeinterface.controller.Characters.ennemies;

import com.example.harrypotterathomeinterface.controller.Characters.ennemies.AbstractEnemy;

public class Boss extends AbstractEnemy {

    //This class is identical to Enemy, and could be replaced by it.

    public Boss(String name, int hp, int damage, int precision){
        this.setName(name);
        this.setHp(hp);
        this.setDamage(damage);
        this.setPrecision(precision);

    }



}
