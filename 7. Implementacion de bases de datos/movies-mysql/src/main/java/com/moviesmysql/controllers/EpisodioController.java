package com.moviesmysql.controllers;

import com.moviesmysql.services.IEpisodiosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/episodios")
public class EpisodioController {

    private final IEpisodiosService episodioService;

    public EpisodioController(IEpisodiosService episodioService) {
        this.episodioService = episodioService;
    }

    // Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
    @GetMapping("/actor/{actorId}")
    public ResponseEntity<?> getEpisodiosByActor(@PathVariable Long actorId) {
        return new ResponseEntity<>(
                this.episodioService.getEpisodiosByActor(actorId),
                HttpStatus.OK
        );
    }

}
