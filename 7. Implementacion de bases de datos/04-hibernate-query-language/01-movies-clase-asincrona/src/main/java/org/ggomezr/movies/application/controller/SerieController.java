package org.ggomezr.movies.application.controller;

import org.ggomezr.movies.application.service.impl.SerieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/series")
public class SerieController {

    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping("/seasons/{seasons}")
    public ResponseEntity<?> findAllSeriesWithMoreThanSeasons(@PathVariable Integer seasons) {
        return ResponseEntity.ok(serieService.getAllSeriesWithMoreThanSeasons(seasons));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<?> findAllSeriesWhereTitleIs(@PathVariable String title) {
        return ResponseEntity.ok(serieService.findAllSeriesWhereTitleIs(title));
    }
}
