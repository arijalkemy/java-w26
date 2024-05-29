package com.w26.movies.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.w26.movies.demo.service.interfaces.IEpisodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/episode")
public class EpisodeController {
    
    @Autowired
    IEpisodeService episodeService;    


    @GetMapping("/by_actor/{id}")
    public ResponseEntity<?> getMethodName(@PathVariable Integer id) {
        return ResponseEntity.ok().body(episodeService.findEpisodeByActor(id)); 
    }
    
}
