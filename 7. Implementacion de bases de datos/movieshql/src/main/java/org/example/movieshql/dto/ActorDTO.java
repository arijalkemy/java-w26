package org.example.movieshql.dto;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.movieshql.model.Movie;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({"firstName","lastName","rating","movie"})
public class ActorDTO {

    @JsonProperty( "first_name")
    private String firstName;

    @JsonProperty( "last_name")
    private String lastName;

    private Double rating;

    @JsonProperty("favorite_movie")
    private MovieDTO movie;
}
