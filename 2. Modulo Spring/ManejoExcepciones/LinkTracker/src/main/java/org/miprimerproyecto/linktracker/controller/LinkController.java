package org.miprimerproyecto.linktracker.controller;

import org.miprimerproyecto.linktracker.dto.LinkDTO;
import org.miprimerproyecto.linktracker.dto.MetricsDTO;
import org.miprimerproyecto.linktracker.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {

    @Autowired
    LinkService linkService;

    @PostMapping("/link/create")
    public ResponseEntity<LinkDTO> createLink(@RequestBody String originalUrl,
                                              @RequestParam(required = false) String password){
        LinkDTO createdLink = linkService.createLink(originalUrl, password);
        return ResponseEntity.ok(createdLink);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<Void> redirect(@PathVariable String linkId,
                                         @RequestParam(required = false) String password) {
        boolean isValid = linkService.validateLink(linkId, password);
        if (!isValid) {
            return ResponseEntity.notFound().build();
        }
        String originalUrl = linkService.getOriginalUrl(linkId);
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header(HttpHeaders.LOCATION, originalUrl).build();
    }

    @GetMapping("/link/metrics/{linkId}")
    public ResponseEntity<MetricsDTO> getMetrics(@PathVariable String linkId) {
        MetricsDTO metrics = linkService.getLinkMetrics(linkId);
        return ResponseEntity.ok(metrics);
    }

    @PostMapping("/link/invalidate/{linkId}")
    public ResponseEntity<Void> invalidateLink(@PathVariable String linkId) {
        linkService.invalidateLink(linkId);
        return ResponseEntity.ok().build();
    }
}
