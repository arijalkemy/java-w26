package org.implementaciondb.ejercicio5_movies_hql.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActorDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("updated_at")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("rating")
    private BigDecimal rating;

    @JsonProperty("favorite_movie")
    private FavoriteMovieActorDto favoriteMovie;

}
