package com.spring.linktracker.controller;

import com.spring.linktracker.service.ILinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
public class MetricsController {

    @Autowired
    ILinksService linksService;

    @GetMapping("/{linkId}")
    ResponseEntity<Integer> getLinkMetrics(@PathVariable Integer linkId) {
        return new ResponseEntity<>(this.linksService.getLinkMetrics(linkId), HttpStatus.OK);
    }


}
