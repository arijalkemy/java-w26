package com.spring.deportistas.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Sport {

    private String name;
    private String level;

    public Sport(String name, String level) {
        this.name = name;
        this.level = level;
    }

}
