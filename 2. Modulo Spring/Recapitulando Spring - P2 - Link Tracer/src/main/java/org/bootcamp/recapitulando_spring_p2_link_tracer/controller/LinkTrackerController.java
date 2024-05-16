package org.bootcamp.recapitulando_spring_p2_link_tracer.controller;

import org.bootcamp.recapitulando_spring_p2_link_tracer.dto.LinkRequestDTO;
import org.bootcamp.recapitulando_spring_p2_link_tracer.dto.LinkResponseDTO;
import org.bootcamp.recapitulando_spring_p2_link_tracer.service.ILinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@RestController
@RequestMapping("/link")
public class LinkTrackerController {
    @Autowired
    ILinkTrackerService linkTrackerService;

    @PostMapping("")

    ResponseEntity<LinkResponseDTO> createLink(@RequestBody LinkRequestDTO link) {
        LinkResponseDTO linkResponseDTO = linkTrackerService.createLink(link);
        return ResponseEntity.ok(linkResponseDTO);
    }

    @DeleteMapping("/invalidate/{linkId}")
    ResponseEntity<String> invalidateLink(@PathVariable String linkId) {
        String message = linkTrackerService.deleteLink(linkId);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{linkId}")
    @ResponseStatus(value = HttpStatus.SEE_OTHER)
    public RedirectView getLink(
            @PathVariable String linkId,
            @RequestParam("pass") Optional<String> pass
    ) {
        String l = linkTrackerService.findLinkById(linkId, pass);
        return new RedirectView("/link/redirect/" + l);
    }

    @GetMapping("/redirect/{publicUrl}")
    ResponseEntity<String> getPublicLink(@PathVariable String publicUrl) {
        linkTrackerService.incrementVisitCounter(publicUrl);
        return ResponseEntity.ok(publicUrl);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> getMetrics(@PathVariable String linkId) {
        Integer visits = linkTrackerService.getVisitCounter(linkId);
        return ResponseEntity.ok(visits);
    }
}
