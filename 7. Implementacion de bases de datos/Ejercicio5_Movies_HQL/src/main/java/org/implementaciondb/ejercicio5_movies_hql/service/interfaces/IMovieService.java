package org.implementaciondb.ejercicio5_movies_hql.service.interfaces;

import org.implementaciondb.ejercicio5_movies_hql.model.dto.MovieDto;

import java.math.BigDecimal;
import java.util.List;

public interface IMovieService {

    List<MovieDto> findMoviesWithActorsWithRatingGreaterThan(BigDecimal actorRating);

    List<MovieDto> findMoviesWithGenre(Long genreId);
}
