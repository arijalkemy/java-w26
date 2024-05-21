package bootcamp.bendezujonathan.hql.service.interfaces;

import java.util.List;

import bootcamp.bendezujonathan.hql.dto.response.MovieResponse;

public interface MoviesService {
    
    List<MovieResponse> findAllByActorsRating(double rating);
}
