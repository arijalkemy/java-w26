package org.miprimerproyecto.practicahql.controller;

import org.miprimerproyecto.practicahql.service.imp.episodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/episode")
public class episodeController {

    @Autowired
    private episodeService episodeService;

    @GetMapping("/actor/{actor}")
    public ResponseEntity<?> findEpisodesByActor(@PathVariable String actor) {
        return ResponseEntity.ok(episodeService.findEpisodesByActor(actor));
    }
}
