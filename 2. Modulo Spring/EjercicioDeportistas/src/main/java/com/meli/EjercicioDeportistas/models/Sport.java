package com.meli.EjercicioDeportistas.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sport {
    private String name;
    private int level;

    public Sport(String name, int level) {
        this.name = name;
        this.level = level;
    }
}
