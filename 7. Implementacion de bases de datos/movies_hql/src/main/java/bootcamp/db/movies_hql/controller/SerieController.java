package bootcamp.db.movies_hql.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.db.movies_hql.model.Serie;
import bootcamp.db.movies_hql.service.SerieService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/series")
public class SerieController {
    
    private final SerieService serieService;

    public SerieController(SerieService serieService){
        this.serieService = serieService;
    }

    @GetMapping
    public ResponseEntity<List<Serie>> getAll() {
        return ResponseEntity.ok(serieService.searchAll());
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Serie> getSerieByGenre(@PathVariable("title") String title){
        return ResponseEntity.ok(serieService.searchByTitle(title));
    }
    
}
