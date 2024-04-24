package org.example.integradorlinktracker.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.example.integradorlinktracker.dto.LinkDto;
import org.example.integradorlinktracker.dto.LinkMetricsDto;
import org.example.integradorlinktracker.entity.Link;
import org.example.integradorlinktracker.service.impl.LinkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class LinkController {

    private final LinkServiceImpl linkService;

    @Autowired
    public LinkController(LinkServiceImpl linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<Link> createLink(@RequestBody LinkDto linkDto) {
        Link createdLink = linkService.createLink(linkDto);
        return new ResponseEntity<>(createdLink, HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<Void> redirect(@PathVariable("linkId") String linkId,
                                         @RequestParam("password") String password) {
        int linkIdInt = Integer.parseInt(linkId);

        Link redirectedLink = linkService.redirect(linkIdInt, password);
        if (redirectedLink != null) {
            return new ResponseEntity<>(HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkMetricsDto> getLinkMetrics(@PathVariable int linkId) {
        LinkMetricsDto metricsDto = linkService.getLinkMetrics(linkId);
        return new ResponseEntity<>(metricsDto, HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<Void> invalidateLink(@PathVariable int linkId) {
        linkService.invalidateLink(linkId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}




