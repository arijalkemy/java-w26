package org.example.ejerciciodeportistas.dto;

import java.io.Serializable;

public class PersonDto implements Serializable {
    private String name;
    private String lastName;
    private String sportName;

    public PersonDto(String name, String lastName, String sportName) {
        this.name = name;
        this.lastName = lastName;
        this.sportName = sportName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }
}
