package org.example.linktracer.controller;

import org.apache.coyote.Response;
import org.example.linktracer.dto.LinkMetricsDto;
import org.example.linktracer.dto.LinkResponseDto;
import org.example.linktracer.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {
    @Autowired
    ILinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<LinkResponseDto> link(@RequestParam String password) {
        return new ResponseEntity<>(linkService.generateLink(password), HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<String> getLink(@PathVariable String linkId) {
        return new ResponseEntity<>(linkService.redirect(linkId), HttpStatus.OK);
    }

    @GetMapping("/link/metrics/{linkId}")
    public ResponseEntity<LinkMetricsDto> getLinkMetrics(@PathVariable String linkId) {
        return new ResponseEntity<>(linkService.getMetrics(linkId), HttpStatus.OK);
    }

    @PutMapping("/link/invalidate/{linkId}")
    public ResponseEntity<String> invalidateLink(@PathVariable String linkId) {
        return new ResponseEntity<>(linkService.invalidateLink(linkId), HttpStatus.OK);
    }
}
