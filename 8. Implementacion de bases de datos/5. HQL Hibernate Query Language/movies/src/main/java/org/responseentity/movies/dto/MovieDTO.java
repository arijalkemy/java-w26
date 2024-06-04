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
public class MovieDTO {
    private Integer id;
    private String title;
    private BigDecimal rating;
    private Integer awards;
    private Instant releaseDate;
    private Long length;
    private String genre;
}
