package org.implementaciondb.ejercicio5_movies_hql.service;

import org.implementaciondb.ejercicio5_movies_hql.exception.NoFoundException;
import org.implementaciondb.ejercicio5_movies_hql.mapper.ActorMapper;
import org.implementaciondb.ejercicio5_movies_hql.model.dto.ActorDto;
import org.implementaciondb.ejercicio5_movies_hql.model.entity.Actor;
import org.implementaciondb.ejercicio5_movies_hql.repository.IActorRepository;
import org.implementaciondb.ejercicio5_movies_hql.service.interfaces.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ActorServiceImpl implements IActorService {

    @Autowired
    private IActorRepository actorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ActorDto> findActorsWithFavoriteMovie() {
        List<Actor> actors = actorRepository.findByFavoriteMovieExist();
        return createListResponse(actors, "No hay actores registrados con películas favoritas");
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActorDto> findActorsWithRatingGreaterThan(BigDecimal rating) {
        List<Actor> actors = actorRepository.findByRatingGreaterThan(rating);
        return createListResponse(actors, "No hay actores con rating mayor que: " + rating);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActorDto> findActorsWorkingOnTheMovie(Long movieId) {
        List<Actor> actors = actorRepository.findByWorkingOnTheMovie(movieId);
        return createListResponse(
                actors, "No hay actores registrados que trabajen en la película con id: " + movieId
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActorDto> findActorsWithMultipleSeriesAndRatingGreaterThan(BigDecimal rating) {
        List<Actor> actors = actorRepository.findByMultipleSeriesAndRatingGreaterThan(rating);
        return createListResponse(
                actors, "No hay actores registrados con más de una serie y que su rating sea mayor a "
                        + rating
        );
    }

    private List<ActorDto> createListResponse(List<Actor> actors, String errorMessage) {
        if (actors.isEmpty()) {
            throw new NoFoundException(errorMessage);
        }
        return actors
                .stream()
                .map(ActorMapper::convertToDto)
                .toList();
    }
}
