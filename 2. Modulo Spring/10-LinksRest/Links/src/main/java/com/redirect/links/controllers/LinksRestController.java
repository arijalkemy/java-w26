package com.redirect.links.controllers;


import com.redirect.links.dto.request.LinkRequestDTO;
import com.redirect.links.dto.response.LinkResponseDTO;
import com.redirect.links.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/links")
public class LinksRestController {

    @Autowired
    ILinkService linkService;


    @PostMapping("/add")
    public ResponseEntity<LinkResponseDTO> addLink(@RequestBody LinkRequestDTO link){
        return ResponseEntity.ok().body(linkService.addURL(link));
    }

    @GetMapping("linkid/{linkId}/password")
    public RedirectView redirect(@PathVariable Integer linkId, @RequestParam String password){
        String link = linkService.redirectURL(linkId, password);
        return new RedirectView(link);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> metricsURL(@PathVariable Integer linkId){
        return ResponseEntity.ok().body(linkService.metricsURL(linkId));
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<String> invalidateURL(@PathVariable Integer linkId){
        return ResponseEntity.ok().body(linkService.invalidateURL(linkId));
    }

}
