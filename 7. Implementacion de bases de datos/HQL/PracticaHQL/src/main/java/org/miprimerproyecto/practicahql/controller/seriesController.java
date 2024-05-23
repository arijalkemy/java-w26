package org.miprimerproyecto.practicahql.controller;

import org.miprimerproyecto.practicahql.service.imp.seriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/series")
public class seriesController {

    @Autowired
    private seriesService seriesService;

    @GetMapping("/seasons/{seasons}")
    public String findSeriesWithSeasonsGreaterThan(@PathVariable Integer seasons) {
        return seriesService.findSeriesWithSeasonsGreaterThan(seasons).toString();
    }
}
