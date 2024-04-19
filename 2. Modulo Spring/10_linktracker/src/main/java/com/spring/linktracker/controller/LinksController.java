package com.spring.linktracker.controller;

import com.spring.linktracker.dto.LinkRequestDTO;
import com.spring.linktracker.dto.LinkResponseDTO;
import com.spring.linktracker.service.ILinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinksController {

    @Autowired
    ILinksService linksService;

    @GetMapping("link/{linkId}")
    RedirectView redirectLink(@PathVariable Integer linkId, @RequestParam(required = false) String password) {
        RedirectView redirectView = new RedirectView(this.linksService.redirectLink(linkId, password));
        redirectView.setStatusCode(HttpStatus.PERMANENT_REDIRECT);
        return redirectView;
    }

    @PostMapping("link")
    ResponseEntity<LinkResponseDTO> createLink(
            @RequestBody LinkRequestDTO link,
            @RequestParam(required = false) String password
    ) {
        return new ResponseEntity<>(this.linksService.createLink(link, password), HttpStatus.CREATED);
    }

    @GetMapping("/invalidate/{linkId}")
    ResponseEntity<?> invalidateLink(@PathVariable Integer linkId) {
        this.linksService.invalidateLink(linkId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
