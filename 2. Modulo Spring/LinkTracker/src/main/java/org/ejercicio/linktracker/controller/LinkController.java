package org.ejercicio.linktracker.controller;

import org.ejercicio.linktracker.dto.LinkRequestDto;
import org.ejercicio.linktracker.dto.LinkResponseDto;
import org.ejercicio.linktracker.dto.MetricsRedirectionDto;
import org.ejercicio.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping()
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @PostMapping("link")
    public ResponseEntity<LinkResponseDto> addLink(@RequestBody LinkRequestDto linkRequestDto) {
        return new ResponseEntity<>(linkService.createLink(linkRequestDto),HttpStatus.CREATED);
    }

    @GetMapping("link/{linkId}")
    public ResponseEntity<?> getRedirectionLink(@PathVariable UUID linkId, @RequestParam String password) {
        return new ResponseEntity<>(linkService.redirectLinkAction(linkId, password),HttpStatus.SEE_OTHER);
    }

    @GetMapping("metrics/{linkId}")
    public ResponseEntity<MetricsRedirectionDto> getRedirectionLink(@PathVariable UUID linkId) {
        return new ResponseEntity<>(linkService.getMetricsById(linkId),HttpStatus.OK);
    }

    @DeleteMapping("invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable UUID linkId) {
        linkService.invalidateLink(linkId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
