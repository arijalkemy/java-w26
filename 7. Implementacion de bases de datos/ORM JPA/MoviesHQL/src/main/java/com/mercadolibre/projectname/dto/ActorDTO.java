package com.mercadolibre.projectname.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ActorDTO implements Serializable {
    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private Float rating;
    @JsonProperty("favorite_movie_id")
    private Long favoriteMovie;
}
