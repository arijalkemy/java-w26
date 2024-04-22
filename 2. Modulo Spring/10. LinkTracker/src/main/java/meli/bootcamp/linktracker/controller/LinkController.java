package meli.bootcamp.linktracker.controller;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.linktracker.dto.LinkMetricsDTO;
import meli.bootcamp.linktracker.dto.NewLinkDTO;
import meli.bootcamp.linktracker.dto.LinkRequestDTO;
import meli.bootcamp.linktracker.dto.LinkResponseDTO;
import meli.bootcamp.linktracker.service.LinkServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class LinkController {

    private final LinkServiceImpl linkService;

    @PostMapping("/link")
    public ResponseEntity<NewLinkDTO> link(@RequestBody LinkRequestDTO link) {
        return ResponseEntity.status(HttpStatus.CREATED).body(linkService.createLink(link));
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> linkRedirection(@PathVariable Integer linkId, @RequestParam(required = false) String password) {
        LinkResponseDTO linkDTO = linkService.redirect(linkId, password);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(linkDTO.getUrl()));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkMetricsDTO> linkMetrics(@PathVariable Integer linkId) {
        return ResponseEntity.ok(linkService.getMetricsLink(linkId));
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable Integer linkId) {
        linkService.invalidateLink(linkId);
        return ResponseEntity.ok("Link invalidated successfully.");
    }
}
