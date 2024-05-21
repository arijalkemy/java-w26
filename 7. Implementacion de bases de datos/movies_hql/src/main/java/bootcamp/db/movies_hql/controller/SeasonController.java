package bootcamp.db.movies_hql.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.db.movies_hql.model.Season;
import bootcamp.db.movies_hql.service.SeasonService;

@RestController
@RequestMapping("/season")
public class SeasonController {
    
    private final SeasonService seasonService;

    public SeasonController(SeasonService seasonService){
        this.seasonService = seasonService;
    }

    @GetMapping
    public ResponseEntity<List<Season>> getAll(){
        return ResponseEntity.ok(seasonService.searchAll());
    }
}
