package bootcamp.bendezujonathan.hql.controller.implementations;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.bendezujonathan.hql.controller.interfaces.ActorController;
import bootcamp.bendezujonathan.hql.dto.response.ActorMovieResponse;
import bootcamp.bendezujonathan.hql.dto.response.ActorResponse;
import bootcamp.bendezujonathan.hql.service.interfaces.ActorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ActorControllerImpl implements ActorController {

    private final ActorService service;

    @Override
    public ResponseEntity<List<ActorResponse>> getAllWithFavMovie() {
       List<ActorResponse> res = service.findAllWithFavMovie();
        return ResponseEntity.ok(res);
    }

    @Override
    public ResponseEntity<List<ActorResponse>> getAllOverRating(double rating) {
        List<ActorResponse> res = service.findAllOverRating(rating);
        return ResponseEntity.ok(res);
    }

    @Override
    public ResponseEntity<List<ActorMovieResponse>> getAllByMovie(String movie) {
       List<ActorMovieResponse> res = service.findActorByMovie(movie);
       return ResponseEntity.ok(res);
    }
    
}
