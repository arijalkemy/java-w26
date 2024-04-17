package org.example.starwars.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StarWarCharacter {
    private String name;
    private int height;
    private int mass;
    private String hair_color;
    private String eye_color;
    private String skin_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;

    public StarWarCharacter() {}

    public StarWarCharacter(String name, int height, int mass, String hair_color, String eye_color, String skin_color, String birth_year, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hair_color = hair_color;
        this.eye_color = eye_color;
        this.skin_color = skin_color;
        this.birth_year = birth_year;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }

    @JsonSetter("mass")
    public void setMass(String mass) {
        if ("NA".equals(mass)) {
            this.mass = 0;
        } else {
            // Tratar de convertir la cadena a un número decimal (double)
            try {
                double parsedMass = Double.parseDouble(mass.replace(",", ""));
                this.mass = (int) Math.floor(parsedMass);
            } catch (NumberFormatException e) {
                // Manejar el caso en el que no se puede convertir a un número decimal
                this.mass = 0; // O cualquier otro valor predeterminado que desees
            }
        }
    }

    @JsonSetter("height")
    public void setHeight(String height) {
        if ("NA".equals(height)) {
            this.height = 0;
        } else {
            // Tratar de convertir la cadena a un número entero
            try {
                this.height = Integer.parseInt(height);
            } catch (NumberFormatException e) {
                // Manejar el caso en el que no se puede convertir a un número entero
                this.height = 0; // O cualquier otro valor predeterminado que desees
            }
        }
    }

}
