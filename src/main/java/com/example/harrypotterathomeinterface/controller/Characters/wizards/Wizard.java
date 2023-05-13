package com.example.harrypotterathomeinterface.controller.Characters.wizards;

import com.example.harrypotterathomeinterface.controller.Characters.Character;
import com.example.harrypotterathomeinterface.controller.Characters.spells.Spell;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.lang.annotation.Target;

public class Wizard extends Character {

    private @Getter @Setter Pet pet;
    private @Getter @Setter Wand wand;
    private @Getter @Setter House house;
    private @Getter @Setter Spell[] knownSpells;
    private @Getter @Setter Potion[] potions;
    private @Getter @Setter int maxHealth;
    private @Getter @Setter double damageMultiplier;
    private @Getter @Setter int defend = 0;
    private @Getter @Setter float defense = 0.8f;
    private @Getter @Setter float precision = 1f;
    private @Getter @Setter boolean isEvil = false;


    @Builder
    public Wizard(){
        this.setHp(100);
        this.setMaxHealth(100);
        this.setDamageMultiplier(1);


    }



    public void defend(){

    }


}
