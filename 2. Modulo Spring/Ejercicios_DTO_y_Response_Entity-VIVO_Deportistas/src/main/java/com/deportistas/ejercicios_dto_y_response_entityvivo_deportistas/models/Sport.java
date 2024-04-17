package com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.models;

public class Sport {
    private String name;
    private Integer level;

    public Sport(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
