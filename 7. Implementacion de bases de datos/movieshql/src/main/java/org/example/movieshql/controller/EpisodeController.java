package org.example.movieshql.controller;

import org.example.movieshql.service.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {
    @Autowired
    IEpisodeService episodeService;

    @GetMapping("/actor/{id}")
    ResponseEntity<?> retrienveEpisodeas(@PathVariable Integer id){
        return ResponseEntity.ok(episodeService.getEpisodesByActor(id));
    }
}
