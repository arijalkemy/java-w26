package org.meli.ejercicio6_p4_d1_seriesparte2_mysql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.dto.ActorFavoriteMovieDto;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.dto.ActorDto;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.dto.MovieDto;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.repository.IActorRepository;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.service.Iservice.IActorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Target;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ActorService implements IActorService {
    private IActorRepository actorRepository;
    private ObjectMapper objectMapper;


    @Override
    @Transactional
    public List<ActorFavoriteMovieDto> findAllActorFavoriteMovie() {
        List<ActorFavoriteMovieDto> actors =
                actorRepository.selectactorFavoriteMovie()
                        .stream()
                        .map(v -> objectMapper.convertValue(v, ActorFavoriteMovieDto.class))
                        .collect(Collectors.toList());
        return actors;
    }

    @Override
    @Transactional
    public List<ActorDto> allActorsRanking(Double num) {
        List<ActorDto> actors =
        actorRepository.selectActorsByRating(num)
                .stream()
                .map(v -> objectMapper.convertValue(v, ActorDto.class))
                .collect(Collectors.toList());
        return actors;
    }

    @Override
    @Transactional
    public List<ActorDto> getAllActorsByMovie(String movies) {
        return actorRepository.selectActorsByTitle(movies)
                .stream()
                .map(v -> objectMapper.convertValue(v, ActorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<MovieDto> getAllMoviesActorsByRating(Double num) {
        return actorRepository.selectMovieByRating(num)
                .stream()
                .map(v -> objectMapper.convertValue(v, MovieDto.class))
                .collect(Collectors.toList());
    }
}
