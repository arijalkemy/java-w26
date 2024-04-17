package com.starwars.starwars.dto;

import lombok.Data;

@Data
public class CharacterResponseDto {
        private String name;
        private int height;
        private int mass;
        private String gender;
        private String homeworld;
        private String species;
}
