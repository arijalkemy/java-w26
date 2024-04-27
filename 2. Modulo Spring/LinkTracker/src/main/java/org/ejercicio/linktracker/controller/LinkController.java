package org.ejercicio.linktracker.controller;

import org.ejercicio.linktracker.dto.LinkRequestDto;
import org.ejercicio.linktracker.dto.LinkResponseDto;
import org.ejercicio.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @PostMapping
    public ResponseEntity<LinkResponseDto> addLink(@RequestBody LinkRequestDto linkRequestDto) {
        return new ResponseEntity<>(linkService.createLink(linkRequestDto),HttpStatus.CREATED);
    }

    @GetMapping("{linkId}")
    public ResponseEntity<?> getRedirectionLink(@PathVariable UUID linkId, @RequestParam String password) {
        return new ResponseEntity<>(linkService.redirectLinkAction(linkId, password),HttpStatus.SEE_OTHER);
    }
}
