package org.ggomezr.movies.application.controller;

import org.ggomezr.movies.application.service.impl.ActorService;
import org.ggomezr.movies.application.service.impl.EpisodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {

    private final EpisodeService episodeService;

    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping("/actor/{actor}")
    public ResponseEntity<?> findAllEpisodesWhereActorIsPresent(@PathVariable String actor) {
        return ResponseEntity.ok(episodeService.getAllEpisodesWhereActorIsPresent(actor));
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<?> findAllEpisodesWhichRatingIsGreaterThan(@PathVariable Float rating) {
        return ResponseEntity.ok(episodeService.getAllEpisodesWhichRatingIsGreaterThan(rating));
    }
}
