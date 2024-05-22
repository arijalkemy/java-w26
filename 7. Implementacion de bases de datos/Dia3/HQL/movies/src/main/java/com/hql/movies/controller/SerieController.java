package com.hql.movies.controller;

import com.hql.movies.model.Episode;
import com.hql.movies.model.Serie;
import com.hql.movies.service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series/")
public class SerieController {

    @Autowired
    ISerieService serieService;

    @GetMapping("seasons/{amount_seasons}")  //revisar que todas las series tienen 0 seasons
    public List<Serie> findSerieBySeasonsGreaterThan(@PathVariable("amount_seasons") int seasons) {
        return serieService.findSerieByAmountSeasonsGreaterThan(seasons);
    }

    @GetMapping("episode/{actor_id}")  //revisar porque los episodios no tienen serie_id
    public List<Episode> findEpisodeByActorId(@PathVariable("actor_id") int actorId) {
        return serieService.findEpisodeByActorId(actorId);
    }
}
