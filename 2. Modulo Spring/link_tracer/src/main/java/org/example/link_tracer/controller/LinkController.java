package org.example.link_tracer.controller;

import org.example.link_tracer.dto.LinkRequestDTO;
import org.example.link_tracer.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@RestController
public class LinkController {
    @Autowired
    ILinkService linkService;

    @PostMapping("/new")
    public ResponseEntity<?> postNewLink(@RequestBody LinkRequestDTO newLink){
        return ResponseEntity.ok(linkService.newLink(newLink));
    }
    @GetMapping("/link/{id}")
    public ResponseEntity<?> getRedirectLink(@PathVariable Integer id) throws MalformedURLException, URISyntaxException {
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).location(linkService.redirect(id)).build();
    }
    @GetMapping(value="/link/{id}", params = "password")
    public ResponseEntity<?> getRedirectLinkWithPassword(@PathVariable Integer id, @RequestParam String password) throws MalformedURLException, URISyntaxException {
        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT).location(linkService.redirect(id,password)).build();
    }
    @GetMapping("/metrics/{id}")
    public ResponseEntity<?> getMetricsLink(@PathVariable Integer id){
        return ResponseEntity.ok(linkService.metricsLink(id));
    }
    @PostMapping("/invalidate/{id}")
    public ResponseEntity<?> postInvalidateLink(@PathVariable Integer id){
        return ResponseEntity.ok(linkService.disbleLink(id));
    }
    @PostMapping("/validate/{id}")
    public ResponseEntity<?> postValidateLink(@PathVariable Integer id){
        return ResponseEntity.ok(linkService.enableLink(id));
    }

}
