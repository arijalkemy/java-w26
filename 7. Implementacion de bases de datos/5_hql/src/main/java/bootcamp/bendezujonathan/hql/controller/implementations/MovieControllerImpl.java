package bootcamp.bendezujonathan.hql.controller.implementations;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.bendezujonathan.hql.controller.interfaces.MovieController;
import bootcamp.bendezujonathan.hql.dto.response.MovieResponse;
import bootcamp.bendezujonathan.hql.service.interfaces.MoviesService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MovieControllerImpl implements MovieController {
    
    private final MoviesService service;

    @Override
    public ResponseEntity<List<MovieResponse>> getAllWithActorsOverRating(double rating) {
        List<MovieResponse> res = service.findAllByActorsRating(rating);
        return ResponseEntity.ok(res);
    }

    

}
