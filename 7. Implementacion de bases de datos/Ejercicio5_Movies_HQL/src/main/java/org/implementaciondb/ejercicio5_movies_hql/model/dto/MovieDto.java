package org.implementaciondb.ejercicio5_movies_hql.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("rating")
    private BigDecimal rating;

    @JsonProperty("awards")
    private Integer awards;

    @JsonProperty("releaseDate")
    private LocalDate releaseDate;

    @JsonProperty("length")
    private Integer length;

    @JsonProperty("genre")
    private GenreDto genre;

}
