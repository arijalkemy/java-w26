package com.example.linkTracker.controller;

import com.example.linkTracker.service.ITrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/link")
public class TrackerController {

    @Autowired
    ITrackerService trackerService;

    @PostMapping()
    public ResponseEntity<?> createLinkWithPassword(@RequestParam String password) {
        return new ResponseEntity<>( trackerService.saveNewLink(password), HttpStatus.CREATED );
    }

    @GetMapping("/{id}")
    public RedirectView redirectLinkWithPassword(@PathVariable String id, @RequestParam String password) {
        trackerService.redirect(id, password);
        return new RedirectView("/link/view/" + id);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<?> getLink(@PathVariable String id) {
        return new ResponseEntity<>("ID: " + id, HttpStatus.OK);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<?> redirectMetrics(@PathVariable String id ) {
        return new ResponseEntity<>( trackerService.getStatistics(id), HttpStatus.OK );
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<?> invalidateLink(@PathVariable String id) {
        trackerService.invalidateLink(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT );
    }
}
