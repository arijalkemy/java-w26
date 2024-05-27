package org.example.movieshql.controller;


import org.example.movieshql.services.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/series")
public class SerieController {
    @Autowired
    ISerieService serieService;

    @GetMapping("/byNumTem/{num_temp}")
    public ResponseEntity<?> getListSeriesWithMoreThanNTemp(@PathVariable Integer num_temp){
        return  ResponseEntity.status(HttpStatus.OK).body(serieService.listSeriesWithMoreThanNTemp(num_temp));
    }

    @GetMapping("/byNameActor/{actor_name}")
    public ResponseEntity<?> listAllEpisodesByActorName(@PathVariable String actor_name){
        return  ResponseEntity.status(HttpStatus.OK).body(serieService.listAllEpisodesByActorName(actor_name));
    }

}
