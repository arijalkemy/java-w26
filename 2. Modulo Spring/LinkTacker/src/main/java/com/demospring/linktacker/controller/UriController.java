package com.demospring.linktacker.controller;

import com.demospring.linktacker.dto.LinkIdDTO;
import com.demospring.linktacker.dto.LinkRequestDTO;
import com.demospring.linktacker.entity.Link;
import com.demospring.linktacker.service.IUriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class UriController {
    @Autowired
    IUriService uriService;

    @PostMapping("/create")
    public ResponseEntity createUri(@RequestBody LinkRequestDTO link, @RequestParam String password) {
        return ResponseEntity.status(201).body(uriService.addLink(link, password));
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity getLink(@PathVariable int linkId, @RequestParam String password){
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(uriService.findLinkById(linkId, password)));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity getMetricsById(@PathVariable int linkId) {
        return ResponseEntity.status(200).body(uriService.metricsLink(linkId));
    }

    @DeleteMapping("/invalidate/{linkId}")
    public ResponseEntity deleteLink(@PathVariable int linkId) {
        uriService.deleteLinkById(linkId);
        return ResponseEntity.status(201).body("Link deleted successfully");
    }
}
