package org.meli.ejercicio6_p4_d1_seriesparte2_mysql.controller;

import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.dto.EpisodeDTO;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.dto.SerieDto;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.service.Iservice.IActorService;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.service.Iservice.ISerieService;
import org.meli.ejercicio6_p4_d1_seriesparte2_mysql.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SeriesController {
    @Autowired
    private ISerieService seriesService;

    //Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
    @GetMapping("/seasons")
    public ResponseEntity<List<SerieDto>> getAllSeries(@RequestParam Integer seasons) {
        return new ResponseEntity<>(seriesService.getAllSeries(seasons), HttpStatus.OK);
    }

    //Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
    @GetMapping("/seasons/actors")
    public ResponseEntity<List<EpisodeDTO>> getAllEpisodes(@RequestParam String actor) {
        return new ResponseEntity<>(seriesService.getAllEpisodes(actor), HttpStatus.OK);
    }
}
