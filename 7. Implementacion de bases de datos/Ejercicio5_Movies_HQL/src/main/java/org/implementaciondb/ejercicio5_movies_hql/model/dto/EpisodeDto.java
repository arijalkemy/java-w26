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
public class EpisodeDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("number")
    private Integer number;

    @JsonProperty("release_date")
    private LocalDate releaseDate;

    @JsonProperty("rating")
    private BigDecimal rating;

}
