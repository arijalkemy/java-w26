package com.demospring.practicahql.controller;

import com.demospring.practicahql.service.impl.EpisodeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/episode")
@AllArgsConstructor
public class EpisodeController {
    private final EpisodeService episodeService;

    @GetMapping("/actor")
    public ResponseEntity<?> getEpisodesByActorName(@RequestParam String firstName, @RequestParam String lastName) {
        return new ResponseEntity<>(episodeService.findEpisodesByActorName(firstName, lastName), HttpStatus.OK);
    }
}
