package org.example.starwars.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {
    @JsonProperty("name")
    private String name;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("mass")
    private Integer mass;
    @JsonProperty("hairColor")
    private String hairColor;
    @JsonProperty("skinColor")
    private String skinColor;
    @JsonProperty("eyeColor")
    private String eyeColor;
    @JsonProperty("birthYear")
    private String birthYear;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("homeworld")
    private String homeworld;
    @JsonProperty("species")
    private String species;
}
