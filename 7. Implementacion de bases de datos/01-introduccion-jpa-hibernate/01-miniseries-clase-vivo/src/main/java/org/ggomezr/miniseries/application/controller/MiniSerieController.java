package org.ggomezr.miniseries.application.controller;

import org.ggomezr.miniseries.domain.dto.MiniSerieDTO;
import org.ggomezr.miniseries.domain.exception.NotFoundException;
import org.ggomezr.miniseries.application.service.impl.MiniSerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
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
    public ResponseEntity<?> getMiniSerieById(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(miniSerieService.getMiniSerieById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMiniSerie(@RequestBody MiniSerieDTO miniSerieDTO, @PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(miniSerieService.updateMiniSerie(miniSerieDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMiniSerie(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(miniSerieService.deleteMiniSerie(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAllMiniSeries(){
        return new ResponseEntity<>(miniSerieService.getAllMiniSeries(), HttpStatus.OK);
    }
}
