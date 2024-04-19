package com.meli.LinkTracker.controller;

import com.meli.LinkTracker.dto.LinkDto;
import com.meli.LinkTracker.dto.LinkIdDto;
import com.meli.LinkTracker.dto.UrlDto;
import com.meli.LinkTracker.model.Link;
import com.meli.LinkTracker.service.ILinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private ILinkService service;

    @PostMapping("/")
    public ResponseEntity<LinkIdDto> saveLink(@RequestBody UrlDto url){
        return new ResponseEntity<>(service.saveLink(url), HttpStatus.CREATED);
    }

    @GetMapping("/{linkId}")
    public void redirect(@PathVariable String linkId, HttpServletResponse response){
        service.redirect(linkId, response);
    }

    @GetMapping("/numberOfRedirects/{linkId}")
    public ResponseEntity<LinkDto> getNumberOfRedirects(@PathVariable String linkId){
        return ResponseEntity.ok(service.getNumberOfRedirects(linkId));
    }
}
