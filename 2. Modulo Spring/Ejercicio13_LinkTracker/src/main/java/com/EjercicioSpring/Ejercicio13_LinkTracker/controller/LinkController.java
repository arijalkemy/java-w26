package com.EjercicioSpring.Ejercicio13_LinkTracker.controller;

import com.EjercicioSpring.Ejercicio13_LinkTracker.dto.LinkIdResponseDTO;
import com.EjercicioSpring.Ejercicio13_LinkTracker.dto.LinkRequestDTO;
import com.EjercicioSpring.Ejercicio13_LinkTracker.dto.LinkResponseDTO;
import com.EjercicioSpring.Ejercicio13_LinkTracker.service.interfaces.ILinkService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {

    @Autowired
    ILinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<LinkIdResponseDTO> createLinkId(@RequestBody LinkRequestDTO linkRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(linkService.createLink(linkRequestDTO));
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirect(@PathVariable Integer linkId, @RequestParam String password) {
        String url = linkService.redirect(linkId, password);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(url);
        redirectView.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
        return redirectView;
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkResponseDTO> getMetricsById(@PathVariable Integer linkId) {
        return ResponseEntity.status(HttpStatus.OK).body(linkService.getMetrics(linkId));
    }

    @PatchMapping("/invalidate/{linkId}")
    public ResponseEntity<Void> invalidateLink(@PathVariable Integer linkId) {
        linkService.invalidateLink(linkId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
