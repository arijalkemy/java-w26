package com.ejercicio.deportistas.models;

public class Sport {
    private String name;
    private String level;

    public Sport(String nombre, String nivel) {
        this.name = nombre;
        this.level = nivel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
