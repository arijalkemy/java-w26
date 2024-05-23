package org.example.movieshql.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MovieDTO {
    private String title;
    private Double rating;
    private Integer awards;
    private GenreDTO genre;
}
