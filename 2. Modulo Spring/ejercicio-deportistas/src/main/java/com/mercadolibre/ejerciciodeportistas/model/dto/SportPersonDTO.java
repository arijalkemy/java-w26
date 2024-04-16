package com.mercadolibre.ejerciciodeportistas.model.dto;

public class SportPersonDTO {
    private String name;
    private String lastName;
    private String sportName;

    public SportPersonDTO(String name, String lastName, String sportName) {
        this.name = name;
        this.lastName = lastName;
        this.sportName = sportName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSportName() {
        return sportName;
    }
}
