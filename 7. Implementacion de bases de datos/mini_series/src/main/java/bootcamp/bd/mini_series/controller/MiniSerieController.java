package bootcamp.bd.mini_series.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.bd.mini_series.model.MiniSerie;
import bootcamp.bd.mini_series.service.MiniSerieService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/miniserie")
public class MiniSerieController {
    
    private final MiniSerieService miniSerieService;

    public MiniSerieController(MiniSerieService miniSerieService){
        this.miniSerieService = miniSerieService;
    }

    @GetMapping("")
    public ResponseEntity<List<MiniSerie>> getAllMiniSerieEntity() {
        return ResponseEntity.ok(miniSerieService.searchAll());
    }
    
}
