package com.example.harrypotterathomeinterface.controller.Characters.ennemies;

public class Enemy extends AbstractEnemy{
    public Enemy(String name, int hp, int damage, int precision){
        this.setName(name);
        this.setHp(hp);
        this.setDamage(damage);
        this.setPrecision(precision);

    }
}
