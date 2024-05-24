package org.example.movies_hql.controller;

import lombok.RequiredArgsConstructor;
import org.example.movies_hql.dtos.responses.SeriesDto;
import org.example.movies_hql.service.interfaces.ISeriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
@RequiredArgsConstructor
public class SeriesController {
    private final ISeriesService service;

    @GetMapping
    public ResponseEntity<List<SeriesDto>> getSeriesByFilter(
            @PathVariable Integer temp
    ){
        return null;
    }
}
