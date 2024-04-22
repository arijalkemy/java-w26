package org.example.linktraker.controller;

import org.example.linktraker.dto.request.LinkRedireccionRequestDto;
import org.example.linktraker.dto.request.ValidarLinkRequestDto;
import org.example.linktraker.dto.request.LinkCrearRequestDto;
import org.example.linktraker.dto.response.LinkCrearResponseDto;
import org.example.linktraker.dto.response.LinkMetricasResponseDto;
import org.example.linktraker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class LinkController {
    @Autowired
    ILinkService linkService;

    @PostMapping
    public ResponseEntity<LinkCrearResponseDto> agregarLink(@RequestBody LinkCrearRequestDto link) {
        return ResponseEntity.ok(linkService.addLink(link));
    }

    @PostMapping("/link/{linkId}")
    public ResponseEntity<?> redireccionarLink(@PathVariable int linkId, @RequestBody LinkRedireccionRequestDto link) {
        String url = linkService.redirectLink(linkId, link.getPassword());
        return ResponseEntity.status(HttpStatus.FOUND).location(
                URI.create(url)
        ).build();
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkMetricasResponseDto> getLinkMetrica(@PathVariable int linkId) {
        return ResponseEntity.ok(linkService.getMetricas(linkId));
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidarLink(@RequestBody ValidarLinkRequestDto link, @PathVariable int linkId) {
        linkService.invalidarLink(linkId, link.isValidar());
        return ResponseEntity.ok(link.isValidar() ? "link validado" : "link invalidado");
    }
}
