package org.example.linktracker.controller;

import org.example.linktracker.dto.CreateLinkResponseDTO;
import org.example.linktracker.dto.LinkDTO;
import org.example.linktracker.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/links")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @PostMapping
    public CreateLinkResponseDTO createLink(@RequestParam String url, @RequestParam Optional<String> password) {
        return linkService.createLink(url, password.orElse(null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> redirectLink(@PathVariable Integer id, @RequestParam Optional<String> password) {
        String redirectUrl = linkService.getRedirectUrl(id, password);
        return ResponseEntity.status(302).header("Location", redirectUrl).build();
    }

    @GetMapping("/metrics/{id}")
    public LinkDTO getLinkMetrics(@PathVariable Integer id) {
        return linkService.getLinkMetrics(id);
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<Void> invalidateLink(@PathVariable Integer id) {
        linkService.invalidateLink(id);
        return ResponseEntity.noContent().build();
    }
}
