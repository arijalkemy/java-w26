package org.ggomezr.miniseries.controller;

import org.ggomezr.miniseries.dto.MiniSerieDTO;
import org.ggomezr.miniseries.exception.MiniSerieNotFoundException;
import org.ggomezr.miniseries.model.MiniSerie;
import org.ggomezr.miniseries.service.MiniSerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("miniseries")
public class MiniSerieController {

    private final MiniSerieService miniSerieService;

    public MiniSerieController(MiniSerieService miniSerieService) {
        this.miniSerieService = miniSerieService;
    }

    @PostMapping()
    public ResponseEntity<?> createMiniSerie(@RequestBody MiniSerieDTO miniSerieDTO){
        return new ResponseEntity<>(miniSerieService.createMiniserie(miniSerieDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMiniSerieById(@PathVariable Long id) throws MiniSerieNotFoundException {
        return new ResponseEntity<>(miniSerieService.getMiniSerieById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMiniSerie(@RequestBody MiniSerieDTO miniSerieDTO, @PathVariable Long id) throws MiniSerieNotFoundException {
        return new ResponseEntity<>(miniSerieService.updateMiniSerie(miniSerieDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMiniSerie(@PathVariable Long id) throws MiniSerieNotFoundException {
        return new ResponseEntity<>(miniSerieService.deleteMiniSerie(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAllMiniSeries(){
        return new ResponseEntity<>(miniSerieService.getAllMiniSeries(), HttpStatus.OK);
    }
}
