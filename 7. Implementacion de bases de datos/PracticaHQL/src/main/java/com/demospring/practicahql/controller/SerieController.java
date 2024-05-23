package com.demospring.practicahql.controller;

import com.demospring.practicahql.service.ISerieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serie")
@AllArgsConstructor
public class SerieController {
    private final ISerieService serieService;

    @GetMapping("/cantSeasons/{cantSeasons}")
    public ResponseEntity<?> getSerieByCantSeasonsOver(@PathVariable int cantSeasons) {
        return new ResponseEntity<>(serieService.findSerieByCantSeasonsOver(cantSeasons), HttpStatus.OK);
    }
}
