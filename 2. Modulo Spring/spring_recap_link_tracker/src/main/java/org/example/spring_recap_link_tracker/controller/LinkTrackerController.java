package org.example.spring_recap_link_tracker.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.example.spring_recap_link_tracker.dto.CreateLinkDTO;
import org.example.spring_recap_link_tracker.dto.InvalidateLinkDTO;
import org.example.spring_recap_link_tracker.dto.LinkMetricsDTO;
import org.example.spring_recap_link_tracker.dto.LinkResponseDTO;
import org.example.spring_recap_link_tracker.service.ILinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class LinkTrackerController {
    @Autowired
    ILinkTrackerService linkTrackerService;

    @PostMapping("/link")
    @ResponseBody
    public ResponseEntity<LinkResponseDTO> createLink(@RequestBody CreateLinkDTO newLinkData) {
        LinkResponseDTO responseDTO = linkTrackerService.createLink(newLinkData);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/link/{linkId}")
    public void getLink(@PathVariable String linkId, @RequestParam String password, HttpServletResponse servletResponse) throws IOException {
        String redirectUrl = linkTrackerService.getLink(linkId, password);
        try{
            servletResponse.sendRedirect(redirectUrl);
            linkTrackerService.updateLinkRedirect(linkId);
        } catch (IOException ex) {
            servletResponse.sendError(HttpStatus.BAD_REQUEST.value());
        }
    }

    @GetMapping("/metrics/{linkId}")
    @ResponseBody
    public ResponseEntity<LinkMetricsDTO> getMetrics(@PathVariable String linkId) {
        LinkMetricsDTO metricsDTO = linkTrackerService.getMetrics(linkId);
        return ResponseEntity.status(HttpStatus.OK).body(metricsDTO);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<InvalidateLinkDTO> invalidateLink(@PathVariable String linkId) {
        InvalidateLinkDTO response = linkTrackerService.invalidateLink(linkId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
