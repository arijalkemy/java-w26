package com.example.hqlmoviesdb.service;

import com.example.hqlmoviesdb.model.Actor;
import com.example.hqlmoviesdb.repository.IMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ActorService {
    @Autowired
    private IMoviesRepository moviesRepository;

    public List<String> findAllActorsWithFavorite(){
        return moviesRepository.findAllActorsWithFavoriteMovie();
    }
    public List<String> findActorsByRating(Double rating){
        return moviesRepository.findActorByRatingGreaterThan(rating);
    }
    public List<String> findActorsByWorkMovie(String movie){
        return moviesRepository.findActorsByMovieTitle(movie);
    }
    public List<String> findMoviesByActorsRating(Double rating){
        return moviesRepository.findMoviesByActorRating(rating);
    }
    public List<String> findMoviesByGenre(@RequestParam String genreName){
        return moviesRepository.findMoviesByGenreName(genreName);
    }
    public List<String> findSeriesBySeasons(int numberOfSeasons){
        return moviesRepository.findSeriesBySeasonsNumber(numberOfSeasons);
    }
    public List<String> findEpisodesByActor(String name, String lastname){
        return moviesRepository.findEpisodesByActorName(name, lastname);
    }

}
