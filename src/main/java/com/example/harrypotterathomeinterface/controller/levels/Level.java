package com.example.harrypotterathomeinterface.controller.levels;

import com.example.harrypotterathomeinterface.controller.Characters.ennemies.AbstractEnemy;
import com.example.harrypotterathomeinterface.controller.Characters.ennemies.Boss;
import com.example.harrypotterathomeinterface.controller.Characters.ennemies.Enemy;
import lombok.Getter;
import lombok.Setter;


import java.util.Scanner;

public class Level {
    private @Getter
    @Setter Enemy[] enemies;
    private @Getter
    @Setter Boss[] bosses;
    private @Getter @Setter String levelName;

    private @Getter boolean won;


    public Level(Enemy[] enemies, Boss[] bosses, String levelName) {
        this.enemies = enemies;
        this.bosses = bosses;
        this.won = false;
        this.levelName=levelName;

    }

    public AbstractEnemy getCurrentEnemy() {
        AbstractEnemy enemy = null;
        if (enemies != null) {
            for (int i = enemies.length - 1; i >= 0; i--) {
                if (enemies[i] != null) {
                    enemy = enemies[i];

                }
            }
        }
        if (bosses != null && enemy == null) {
            for (int i = bosses.length - 1; i >= 0; i--) {
                if (bosses[i] != null) {
                    enemy = bosses[i];

                }
            }
        }
        return enemy;
    }

    public void killCurrentEnemy(AbstractEnemy enemyKilled) {
        // This method is used to set an enemy to null
        if (enemies != null) {
            for (int i = enemies.length - 1; i >= 0; i--) {
                if (enemies[i] == enemyKilled) {
                    enemies[i] = null;

                }
            }

        }
        if (bosses != null) {
            for (int c = bosses.length - 1; c >= 0; c--) {
                if (bosses[c] == enemyKilled) {
                    bosses[c] = null;

                }
            }

        }
    }





}
