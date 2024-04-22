package meli.bootcamp.linktracker.controller;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.linktracker.dto.MetricsLinkDTO;
import meli.bootcamp.linktracker.dto.NewLinkDTO;
import meli.bootcamp.linktracker.dto.RequestLinkDTO;
import meli.bootcamp.linktracker.dto.ResponseLinkDTO;
import meli.bootcamp.linktracker.exception.NoPasswordException;
import meli.bootcamp.linktracker.exception.PasswordErrorException;
import meli.bootcamp.linktracker.service.LinkImpl;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class LinkController {

    private final LinkImpl linkService;

    @PostMapping("/link")
    public ResponseEntity<NewLinkDTO> link(@RequestBody RequestLinkDTO link) {
        return ResponseEntity.status(HttpStatus.CREATED).body(linkService.createLink(link));
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> linkRedirection(@PathVariable Integer linkId, @RequestParam(required = false) String password) {
        ResponseLinkDTO linkDTO = linkService.redirect(linkId, password);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(linkDTO.getUrl()));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<MetricsLinkDTO> linkMetrics(@PathVariable Integer linkId) {
        return ResponseEntity.ok(linkService.getMetricsLink(linkId));
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable Integer linkId) {
        linkService.invalidateLink(linkId);
        return ResponseEntity.ok("Link invalidated successfully.");
    }
}
