package org.bootcamp.linktracer.controller;

import jakarta.validation.Valid;
import org.bootcamp.linktracer.dto.LinkDTO;
import org.bootcamp.linktracer.dto.ResponseDTO;
import org.bootcamp.linktracer.dto.response.LinkResponseDTO;
import org.bootcamp.linktracer.service.LinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping
public class LinkController {

    private LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<LinkResponseDTO> saveLink(@RequestBody @Valid LinkDTO linkDTO){
        return ResponseEntity.ok().body(linkService.saveLink(linkDTO));
    }

    @GetMapping("/link/{id}")
    public RedirectView redirectLink(@PathVariable @Valid Integer id,
                                               @RequestParam @Valid String password){
        return new RedirectView(linkService.getRedirect(id, password));
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<LinkResponseDTO> getMetricsLink(@PathVariable Integer id){
        return ResponseEntity.ok().body(linkService.getLinkMetrics(id));
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<ResponseDTO> invalidateLink(@PathVariable Integer id){
        return ResponseEntity.ok().body(linkService.invalidateLink(id));
    }

}
