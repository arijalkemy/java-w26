package org.practicaspring.links.controller;

import org.practicaspring.links.dto.LinkRequestDTO;
import org.practicaspring.links.model.Link;
import org.practicaspring.links.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    ILinkService linkService;

    @PostMapping()
    public ResponseEntity<Long> createLink(@RequestBody LinkRequestDTO linkDTO, @RequestParam(required = false) String password) {
        Long id = linkService.createLink(linkDTO, password);
        return ResponseEntity.status(201).body(id);
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<?> getLink(@PathVariable Long linkId, @RequestParam(required = false) String password) {
        Link link = linkService.getLink(linkId, password);
        HttpHeaders headers = new HttpHeaders();
        try{
            headers.setLocation(new URI(link.getURL()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }
}
