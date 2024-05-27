package meli.bootcamp.movies.controllers;

import meli.bootcamp.movies.services.ISerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/series")
public class SeriesController {

    private final ISerieService serieService;

    public SeriesController(ISerieService serieService) {
        this.serieService = serieService;
    }

    // Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
    @GetMapping("/temporadasGreaterThan/{cantTemporadas}")
    public ResponseEntity<?> getSeriesByTemporadasGreaterThan(
            @PathVariable Integer cantTemporadas
    ) {
        return new ResponseEntity<>(
                this.serieService.getSeriesByTemporadasGreaterThan(cantTemporadas),
                HttpStatus.OK
        );
    }

}
