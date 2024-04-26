package org.example.linktracker.controller;

import org.example.linktracker.dto.in.LinkRequestDto;
import org.example.linktracker.dto.out.LinkResponseDto;
import org.example.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private ILinkService linkService;


    @PostMapping
    public ResponseEntity<LinkResponseDto> createLink(@RequestBody LinkRequestDto linkRequestDto) {

        return ResponseEntity.ok(
            linkService.createLink(linkRequestDto)
        );
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<Void> followLink(@PathVariable String linkId) {

        String targetUrl = linkService.getTargetUrlForLinkId(linkId);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, targetUrl);

        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @GetMapping("{linkId}/metrics")
    public ResponseEntity<?> getMetricsForLink(@PathVariable String linkId) {

        return ResponseEntity.ok(
            linkService.getLinkWithMetrics(linkId)
        );
    }

    @PostMapping("/{linkId}/invalidate")
    public ResponseEntity<?> invalidateLink(@PathVariable String linkId) {

        linkService.invalidateLink(linkId);

        return ResponseEntity.noContent().build();
    }
}
