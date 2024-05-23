package org.example.movieshql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.movieshql.model.Genre;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class SerieDTO {
    private String title;
    private GenreDTO genre;
    @JsonProperty("release_date")
    private Date releaseDate;
}
