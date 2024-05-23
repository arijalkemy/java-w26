package com.practica.miniseries.controller;

import com.practica.miniseries.model.MiniSerie;
import com.practica.miniseries.service.IMiniserieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/miniseries")
public class MiniSeriesController {

    private IMiniserieService miniserieService;

    @GetMapping("/AllSeries")
    public ResponseEntity<List<MiniSerie>> getAllSeries(){
        List<MiniSerie> listSeries = miniserieService.getSeries();
        return ResponseEntity.ok().body(listSeries);
    }

    @PostMapping("/AddSerie")
    public ResponseEntity<String> addSerie(@RequestBody MiniSerie miniSerie){
        miniserieService.saveSerie(miniSerie);
        //en caso de expandir trasladar a service, es solo de prueba
        String successMsg = "MiniSerie added correctly";
        return ResponseEntity.ok().body(successMsg);
    }

    @DeleteMapping("/DeleteSerie")
    public ResponseEntity<String> removeSerie(@RequestParam long id){
        miniserieService.deleteSerie(id);
        //en caso de expandir trasladar a service, es solo de prueba
        String successMsg = "MiniSerie removed correctly";
        return ResponseEntity.ok().body(successMsg);
    }

    @GetMapping("/FindSerie")
    public ResponseEntity<MiniSerie> getSerieById(@RequestParam long id){
        MiniSerie serie = miniserieService.findSerie(id);
        return ResponseEntity.ok().body(serie);
    }

    @PutMapping("/Edit/{id}")
    public ResponseEntity<MiniSerie> updateSerie(@PathVariable long id,
                                 @RequestParam ("name") String newName,
                                 @RequestParam ("rating") Double newRating,
                                 @RequestParam ("awards") Integer newAwards){
        MiniSerie serie = miniserieService.findSerie(id);
        //esto deberia ir en el service pero es de ejemplo
        serie.setName(newName);
        serie.setRating(newRating);
        serie.setAmountOfAwards(newAwards);
        miniserieService.saveSerie(serie);
        return ResponseEntity.ok().body(serie);
    }
}
