package org.example.testjpahql.controller;

import lombok.RequiredArgsConstructor;
import org.example.testjpahql.service.IEpisodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/episodes")
@RequiredArgsConstructor
public class EpisodeController {

    private final IEpisodeService episodeService;

    @GetMapping("/actor")
    @ResponseBody
    public ResponseEntity<?> getEpisodesWithActor(@RequestParam String name, @RequestParam String lastName){
        return ResponseEntity.ok(episodeService.getEpisodeWithActor(name,lastName));
    }

}
