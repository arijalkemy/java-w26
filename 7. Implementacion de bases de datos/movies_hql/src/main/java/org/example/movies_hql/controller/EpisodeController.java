package org.example.movies_hql.controller;

import lombok.RequiredArgsConstructor;
import org.example.movies_hql.model.EpisodesEntity;
import org.example.movies_hql.service.interfaces.IEpisodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episodes")
@RequiredArgsConstructor
public class EpisodeController {
    private final IEpisodeService service;

    @GetMapping
    public ResponseEntity<List<EpisodesEntity>> getEpisodesByActor(
            @PathVariable String actor
    ){
        return null;
    }
}
