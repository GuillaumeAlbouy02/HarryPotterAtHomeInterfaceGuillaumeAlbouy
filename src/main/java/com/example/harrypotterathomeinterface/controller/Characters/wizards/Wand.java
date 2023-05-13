package com.example.harrypotterathomeinterface.controller.Characters.wizards;

import lombok.Getter;
import lombok.Setter;

public class Wand {
    private @Getter @Setter Core core;
    private @Getter @Setter int size;

    public Wand(Core core, int size){
        this.core = core;
        this.size = size;
    }
}
