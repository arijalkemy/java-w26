package org.implementaciondb.ejercicio5_movies_hql.service.interfaces;

import org.implementaciondb.ejercicio5_movies_hql.model.dto.ActorDto;

import java.math.BigDecimal;
import java.util.List;

public interface IActorService {
    List<ActorDto> findActorsWithFavoriteMovie();

    List<ActorDto> findActorsWithRatingGreaterThan(BigDecimal rating);

    List<ActorDto> findActorsWorkingOnTheMovie(Long movieId);

    List<ActorDto> findActorsWithMultipleSeriesAndRatingGreaterThan(BigDecimal rating);
}
