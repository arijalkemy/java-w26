    package org.responseentity.starwars.characters.entity;

    import lombok.Data;

    @Data
    public class CharacterEntity {
        private String name;
        private int height;
        private int mass;
        private String hair_color;
        private String skin_color;
        private String eye_color;
        private String birth_year;
        private String gender;
        private String homeworld;
        private String species;
    }
