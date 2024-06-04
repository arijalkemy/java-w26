package org.responseentity.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.responseentity.movies.model.Genre;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SerieDTO {
    private Integer id;
    private String title;
    private Instant releaseDate;
    private Instant endDate;
    private String genre;
    private Integer numberOfSeasons;
}
