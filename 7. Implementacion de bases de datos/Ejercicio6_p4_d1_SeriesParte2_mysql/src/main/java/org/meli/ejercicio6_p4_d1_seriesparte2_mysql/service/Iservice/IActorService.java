package org.meli.ejercicio6_p4_d1_seriesparte2_mysql.service.Iservice;

import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.dto.ActorFavoriteMovieDto;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.dto.ActorDto;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.dto.MovieDto;

import java.util.List;

public interface IActorService {
    public List<ActorFavoriteMovieDto> findAllActorFavoriteMovie();
    public List<ActorDto> allActorsRanking(Double num);
    public List<ActorDto> getAllActorsByMovie(String movies);
    public List<MovieDto> getAllMoviesActorsByRating(Double num);
}
