package org.implementaciondb.ejercicio5_movies_hql.controller;

import org.implementaciondb.ejercicio5_movies_hql.model.dto.EpisodeDto;
import org.implementaciondb.ejercicio5_movies_hql.service.interfaces.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {

    @Autowired
    private IEpisodeService episodeService;

    /**
     * Consigna: 7
     * Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
     *
     * @param actorId
     */
    @GetMapping("/actors/{actor_id}")
    public ResponseEntity<List<EpisodeDto>> getEpisodesWithActor(@PathVariable(name = "actor_id") Long actorId) {
        return new ResponseEntity<>(episodeService.findEpisodesWithActor(actorId), HttpStatus.OK);
    }

    /**
     * Listar todos los episodios de una serie específica donde trabaja un actor específico
     *
     * @param serieId
     * @param actorId
     * @return
     */
    @GetMapping("/serie/{serie_id}/actor/{actor_id}")
    public ResponseEntity<List<EpisodeDto>> findEpisodesBySerieAndActor(
            @PathVariable(name = "serie_id") Long serieId,
            @PathVariable(name = "actor_id") Long actorId
    ) {
        return new ResponseEntity<>(episodeService.getEpisodesBySerieAndActor(serieId, actorId), HttpStatus.OK);
    }

}
