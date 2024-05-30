package com.mercadolibre.moviesHQL.controller;

import com.mercadolibre.moviesHQL.model.entity.Episode;
import com.mercadolibre.moviesHQL.service.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episode")
public class EpisodeController {
    @Autowired
    IEpisodeService episodeService;

    @GetMapping("/actor/{number}")
    public ResponseEntity<List<Episode>> findAllByWorkingActorEquals(@PathVariable Integer number) {
        return ResponseEntity.status(HttpStatus.OK).body(episodeService.findAllByWorkingActorEquals(number));
    }
}
