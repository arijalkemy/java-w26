package org.example.integradordeportistas.model;

public class Sport {
    private String name;
    private String level;

    public Sport(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public Sport(){

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
