package org.responseentity.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActorWithFavoriteMovieDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private MovieDTO movieDTO;
}
