package org.miprimerproyecto.practicahql.controller;

import org.miprimerproyecto.practicahql.service.imp.actorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor")
public class actorController {

    @Autowired
    private actorService actorService;

    @GetMapping("/list")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(actorService.findActorsWithFavoriteMovie());
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<?> findActorsWithRatingGreaterThan(@PathVariable Double rating) {
        return ResponseEntity.ok(actorService.findActorsWithRatingGreaterThan(rating));
    }

    @GetMapping("/movie/{title}")
    public ResponseEntity<?> findActorsByMovieTitle(@PathVariable String title) {
        return ResponseEntity.ok(actorService.findActorsByMovieTitle(title));
    }
}
