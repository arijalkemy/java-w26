package bootcamp.bendezujonathan.hql.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootcamp.bendezujonathan.hql.dto.response.ActorMovieResponse;
import bootcamp.bendezujonathan.hql.dto.response.ActorResponse;

@RequestMapping("/actors")
public interface ActorController {
    
    @GetMapping(value = "/with-fav-movie")
    ResponseEntity<List<ActorResponse>> getAllWithFavMovie();


    @GetMapping(value = "", params = "rating")
    ResponseEntity<List<ActorResponse>> getAllOverRating(@RequestParam double rating);

    @GetMapping(value = "", params = "movie")
    ResponseEntity<List<ActorMovieResponse>> getAllByMovie(@RequestParam String movie);

}
