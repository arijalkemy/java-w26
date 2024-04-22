package bootcamp.linktracker.controller;

import bootcamp.linktracker.dto.LinkDTO;
import bootcamp.linktracker.exceptions.LinkNotFoundException;
import bootcamp.linktracker.service.LinkServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkTrackerController {
    LinkServiceImpl linkService;

    public LinkTrackerController(LinkServiceImpl linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link/create")
    public LinkDTO createLink(@RequestParam String originalUrl, @RequestParam(required = false) String password) {
        return linkService.createLink(originalUrl, password);
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirectLink(@PathVariable Integer linkId, @RequestParam(required = false) String password) {
        String redirectUrl = linkService.redirectLink(linkId,password);
        if(redirectUrl != null){
            return new RedirectView("https://www.google.com/");
        } else{
            throw new LinkNotFoundException("No se encuentra el link: " + linkId);
        }
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> getRedirectCount(@PathVariable int linkId) {
        int redirectCount = linkService.getRedirectCount(linkId);
        if (redirectCount != -1) {
            return ResponseEntity.ok(redirectCount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<String> invalidateLink(@PathVariable Integer linkId){
        linkService.invalidateLink(linkId);
        return ResponseEntity.ok("El enlace con ID " + linkId + " ha sido invalidado exitosamente.");
    }
}
