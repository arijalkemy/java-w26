package com.example.demo.controller;

import com.example.demo.dto.LinkDto;
import com.example.demo.service.ILinkTackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LinkTackerController {

    ILinkTackerService linkService;

    @Autowired
    public LinkTackerController(ILinkTackerService linkService) {
        this.linkService = linkService;
    }

    @PostMapping
    public ResponseEntity<Long> createLink(@RequestBody LinkDto linkDto, @RequestParam(required = false) String password) {
        Long linkId = linkService.createLink(linkDto, password);
        return ResponseEntity.status(HttpStatus.CREATED).body(linkId);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<Void> redirectLink(@PathVariable Long linkId) {
        String originalUrl = linkService.getOriginalUrl(linkId);
        return ResponseEntity.status(HttpStatus.FOUND).header("Location", originalUrl).build();
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> getLinkRedirectionCount(@PathVariable Long linkId) {
        int redirectionCount = linkService.getRedirectionCount(linkId);
        return ResponseEntity.ok(redirectionCount);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<String> invalidateLink(@PathVariable Long linkId, @RequestParam String password) {
        boolean invalidated = linkService.invalidateLink(linkId, password);
        if (invalidated) {
            return ResponseEntity.ok("Link invalidated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password.");
        }
    }
}
