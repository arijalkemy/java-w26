package org.example.starwars.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Data
@AllArgsConstructor
public class CharacterDTO implements Serializable {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeWorld;
    private String species;


    public CharacterDTO(Builder builder)
    {
        this.name = builder.name;
        this.height = builder.height;
        this.mass = builder.mass;
        this.gender = builder.gender;
        this.homeWorld = builder.homeWorld;
        this.species = builder.species;
    }

    public static class Builder
    {
        private String name;
        private int height;
        private int mass;
        private String gender;
        private String homeWorld;
        private String species;

        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder height(int height) {
            this.height = height;
            return this;
        }
        public Builder mass(int mass) {
            this.mass = mass;
            return this;
        }
        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }
        public Builder homeWorld(String homeWorld) {
            this.homeWorld = homeWorld;
            return this;
        }
        public Builder species(String species) {
            this.species = species;
            return this;
        }
        public CharacterDTO build() {
            return new CharacterDTO(this);
        }
    }
}
