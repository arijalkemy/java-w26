package org.responseentity.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EpisodeDTO {
    private Integer id;
    private String title;
    private Integer number;
    private Instant releaseDate;
    private BigDecimal rating;
    private String season;
    private String serie;
}
