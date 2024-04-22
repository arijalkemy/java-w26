package com.link.tracker.controller;

import com.link.tracker.dto.LinkDTO;
import com.link.tracker.service.LinkTrackerService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class LinkTrackerController {

    @Autowired
    LinkTrackerService linkTrackerService;

    @PostMapping("/link")
    public LinkDTO postNewLink(@RequestBody LinkDTO linkDTO) {
        return linkTrackerService.createNewLink(linkDTO);
    }

    @GetMapping("link/{linkId}")
    public void redirect(@PathVariable Integer linkId, HttpServletResponse response) throws IOException {
        LinkDTO link = linkTrackerService.redirect(linkId);
        if (link != null){
            response.sendRedirect(link.getLink());
        } else {
            response.sendError(404);
        }
    }

    @GetMapping(value = "link/{linkId}", params = {"password"})
    public void redirect(@PathVariable Integer linkId, @RequestParam("password") String password, HttpServletResponse response) throws IOException {
        LinkDTO link = linkTrackerService.redirect(linkId, password);
        if (link != null){
            response.sendRedirect(link.getLink());
        } else {
            response.sendError(404);
        }
    }

    @GetMapping("metrics/{linkId}")
    public LinkDTO metrics(@PathVariable Integer linkId) throws IOException {
        return linkTrackerService.metrics(linkId);
    }

    @PostMapping("invalidate/{linkId}")
    public void invalidate(@PathVariable Integer linkId) throws IOException {
        linkTrackerService.invalidate(linkId);
    }
}
