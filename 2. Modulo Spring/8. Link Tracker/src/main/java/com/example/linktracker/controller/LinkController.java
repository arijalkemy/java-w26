package com.example.linktracker.controller;

import com.example.linktracker.dto.LinkDTO;
import com.example.linktracker.service.IlinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    IlinkService linkService;

    @PostMapping("create")
    public LinkDTO create(@RequestBody LinkDTO link) {
        return linkService.create(link);
    }

    @GetMapping("{linkId}")
    public void redirect(@PathVariable Integer linkId, HttpServletResponse response) throws IOException {
        LinkDTO link = linkService.redirect(linkId);
        if (link != null){
            response.sendRedirect(link.getLink());
        } else {
            response.sendError(404);
        }
    }

    @GetMapping(value = "link/{linkId}", params = {"password"})
    public void redirect(@PathVariable Integer linkId, @RequestParam("password") String password, HttpServletResponse response) throws IOException {
        LinkDTO link = linkService.redirect(linkId, password);
        if (link != null){
            response.sendRedirect(link.getLink());
        } else {
            response.sendError(404);
        }
    }

    @GetMapping("metrics/{linkId}")
    public LinkDTO metrics(@PathVariable Integer linkId) throws IOException {
        return linkService.metrics(linkId);
    }

    @PostMapping("invalidate/{linkId}")
    public void invalidate(@PathVariable Integer linkId) throws IOException {
        linkService.invalidate(linkId);
    }
}
