package bootcamp.bendezujonathan.hql.service.interfaces;

import java.util.List;

import bootcamp.bendezujonathan.hql.dto.response.ActorMovieResponse;
import bootcamp.bendezujonathan.hql.dto.response.ActorResponse;

public interface ActorService {

    List<ActorResponse> findAllWithFavMovie();
    List<ActorResponse> findAllOverRating(double rating);
    List<ActorMovieResponse> findActorByMovie(String movie);
}
