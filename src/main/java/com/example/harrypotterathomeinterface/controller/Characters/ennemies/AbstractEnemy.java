package com.example.harrypotterathomeinterface.controller.Characters.ennemies;


import com.example.harrypotterathomeinterface.controller.Characters.Character;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractEnemy extends Character {
    private @Getter @Setter int damage;
    private @Getter @Setter int precision;


}
