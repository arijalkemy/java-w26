package com.example.Link.controller;
import com.example.Link.service.LinkService;
import com.example.Link.dto.LinkDTO;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
@Repository
@RestController("/link")
public class LinkController {
    private final LinkService linkService;
    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }
    @PostMapping("/create")
    public ResponseEntity<LinkDTO> createLink(@RequestBody String url) {
        LinkDTO link = linkService.createLink(url);
        return ResponseEntity.ok(link);
    }
    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkDTO> getLinkDTO(@PathVariable Integer linkId){
        LinkDTO linkDTO = linkService.getLinkDTO(linkId);
        if(linkDTO != null){
            return ResponseEntity.ok(linkDTO);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<Void> invalidateLink(@PathVariable Integer linkId){
        linkService.invalidateLink(linkId);
        return ResponseEntity.noContent().build();
    }
}
