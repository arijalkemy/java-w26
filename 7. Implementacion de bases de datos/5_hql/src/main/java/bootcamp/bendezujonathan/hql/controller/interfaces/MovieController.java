package bootcamp.bendezujonathan.hql.controller.interfaces;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootcamp.bendezujonathan.hql.dto.response.MovieResponse;

@RequestMapping("/movies")
public interface MovieController {
    
    @GetMapping("/with-actors-over")
    ResponseEntity<List<MovieResponse>> getAllWithActorsOverRating(@RequestParam double rating);


}
