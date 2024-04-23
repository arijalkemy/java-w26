package org.ggomezr.linktracker.application.controller;

import org.ggomezr.linktracker.application.service.impl.LinkService;
import org.ggomezr.linktracker.domain.dto.LinkDTO;
import org.ggomezr.linktracker.domain.dto.MetricsDTO;
import org.ggomezr.linktracker.domain.entity.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LinkController {

    @Autowired
    private LinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<?> createLink(@RequestBody LinkDTO linkDTO) {
        return new ResponseEntity<>(linkService.createLink(linkDTO), HttpStatus.CREATED);
    }

    @GetMapping("/links")
    public ResponseEntity<?> getAllLinks(){
        return new ResponseEntity<>(linkService.getAllLinks(), HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> redirect(@PathVariable String linkId, @RequestParam(required = false) String password) {
        return new ResponseEntity<>(linkService.redirect(linkId, password), HttpStatus.OK);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> getMetrics(@PathVariable String linkId) {
        return new ResponseEntity<>(linkService.getMetrics(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable String linkId) {
        return new ResponseEntity<>(linkService.invalidateLink(linkId), HttpStatus.OK);
    }
}
