package com.ejercicio.linktracker.controller;

import com.ejercicio.linktracker.DTO.LinkDTO;
import com.ejercicio.linktracker.DTO.MetricsResponseDTO;
import com.ejercicio.linktracker.DTO.PostResponseDTO;
import com.ejercicio.linktracker.service.interfaces.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import static org.springframework.http.HttpStatus.*;

@RestController
public class LinkController {

    @Autowired
    ILinkService linkService;

    @PostMapping("/links")
    public ResponseEntity<PostResponseDTO> createLink(@RequestBody LinkDTO linkDTO) {
        return ResponseEntity.status(OK).body(
                linkService.createLink(linkDTO)
        );
    }

    @GetMapping("/links/{linkId}")
    public RedirectView redirectToLink(@PathVariable int linkId) {
        return new RedirectView(linkService.getUrl(linkId), true);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<MetricsResponseDTO> redirectsMetric(@PathVariable int linkId) {
        return ResponseEntity.status(OK).body(
                new MetricsResponseDTO(linkService.getRedirects(linkId))
        );
    }
}
