package com.example.HQL.controller;

import com.example.HQL.dto.response.EpisodeResponseDto;
import com.example.HQL.dto.response.SeriesResponseDto;
import com.example.HQL.service.ISerieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/series")
public class SerieController {
    private final ISerieService serieService;

    @GetMapping("/has-more-seasons-than")
    public ResponseEntity<List<SeriesResponseDto>> getAllWithMoreSeasonsThan(
        @RequestParam(required = true, name = "min_seasons") Integer minSeasons
    ) {
        return new ResponseEntity<>(
            serieService.searchAllWithMoreSeasonsThan(minSeasons),
            HttpStatus.OK
        );
    }

    @GetMapping("/episodes/{actorName}")
    public ResponseEntity<List<EpisodeResponseDto>> getAllEpisodesWithActor(
        @PathVariable String actorName
    ) {
        return new ResponseEntity<>(
            serieService.searchAllEpisodesWithActor(actorName),
            HttpStatus.OK
        );
    }
}
