package org.example.testjpahql.controller;

import lombok.RequiredArgsConstructor;
import org.example.testjpahql.service.IActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/actor")
@RequiredArgsConstructor
public class ActorController {

    private final IActorService actorService;

    @GetMapping("/favourite")
    @ResponseBody
    public ResponseEntity<?> getActorsWithFavouriteMovie(){
        return ResponseEntity.ok(actorService.getActorsWithFavouriteMovie());
    }

    @GetMapping("/rating/{rating}")
    @ResponseBody
    public ResponseEntity<?> getActorsWithRatingGreaterThan(@PathVariable BigDecimal rating){
        return ResponseEntity.ok(actorService.getActorsWithRatingGreaterThan(rating));
    }

    @GetMapping("/movie/{title}")
    @ResponseBody
    public ResponseEntity<?> getActorsInMovie(@PathVariable String title){
        return ResponseEntity.ok(actorService.getActorsInMovie(title));
    }

}
