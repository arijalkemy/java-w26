package com.bootcamp.miniserie.controller;

import com.bootcamp.miniserie.dto.ResponseDTO;
import com.bootcamp.miniserie.service.IMiniSerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.bootcamp.miniserie.dto.MiniSerieDTO;

@RestController
@RequestMapping("/miniseries")
public class MiniSerieController {

    private IMiniSerieService miniSerieService;

    public MiniSerieController(IMiniSerieService miniSerieService) {
        this.miniSerieService = miniSerieService;
    }

    @GetMapping("/")
    public ResponseEntity<List<MiniSerieDTO>> getMiniSeries() {
        return ResponseEntity.ok().body(miniSerieService.getMiniSeries());
    }

    @PostMapping("/")
    public ResponseEntity<ResponseDTO> saveMiniSerie(@RequestBody MiniSerieDTO miniSerieDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(miniSerieService.saveMiniSerie(miniSerieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteMiniSerie(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(miniSerieService.deleteMiniSerie(id));
    }

    @PutMapping("/")
    public ResponseEntity<ResponseDTO> updateMiniSerie(@RequestBody MiniSerieDTO miniSerieDto) {
        return ResponseEntity.ok().body(miniSerieService.updateMiniSerie(miniSerieDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MiniSerieDTO> getMiniSerie(@PathVariable long id) {
        return ResponseEntity.ok().body(miniSerieService.findMiniSerie(id));
    }

}
