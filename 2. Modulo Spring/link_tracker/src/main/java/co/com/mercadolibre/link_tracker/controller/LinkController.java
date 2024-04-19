package co.com.mercadolibre.link_tracker.controller;

import co.com.mercadolibre.link_tracker.dto.LinkDto;
import co.com.mercadolibre.link_tracker.service.ILinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @PostMapping("/create")
    public ResponseEntity<?> createLink(@RequestBody LinkDto linkDto) {
        return ResponseEntity.ok(linkService.create(linkDto));
    }

    @GetMapping("/link/{id}")
    public void redirect(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        LinkDto linkDto = linkService.redirect(id);
        if (linkDto == null) {
            response.sendError(404);
        } else {
            response.sendRedirect(linkDto.getOriginalUrl());
        }
    }

    @GetMapping(value = "/link/{id}", params = {"password"})
    public void redirect(@PathVariable Integer id, @RequestParam("password") String password, HttpServletResponse response) throws IOException {
        LinkDto linkDto = linkService.redirect(id, password);
        if (linkDto == null) {
            response.sendError(404);
        } else {
            response.sendRedirect(linkDto.getOriginalUrl());
        }
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> metrics(@PathVariable Integer linkId) {
        return ResponseEntity.ok(linkService.metrics(linkId));
    }

    @PostMapping("/invalidate/{id}")
    public void invalidate(@PathVariable Integer id) {
        linkService.invalidate(id);
    }
}
