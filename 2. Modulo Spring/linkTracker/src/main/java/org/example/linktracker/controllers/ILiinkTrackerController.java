package org.example.linktracker.controllers;


import org.example.linktracker.dto.ResponseIdlinkTrackerDTO;
import org.example.linktracker.dto.ResponseLinkTrackerDTO;
import org.example.linktracker.dto.ResponseRedirectLinkDTO;
import org.example.linktracker.exception.NotFoundException;
import org.example.linktracker.service.ILinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.UUID;

@RestController
public class ILiinkTrackerController {
    @Autowired
    ILinkTrackerService linkTrackerService;

    @PostMapping("/link")
     ResponseIdlinkTrackerDTO saveLink(@RequestBody ResponseLinkTrackerDTO link) {

        return linkTrackerService.saveLink(link);
    }

    @GetMapping("/link/{linkId}")
    public RedirectView getLink(@PathVariable UUID linkId) {
        //return "redirect:" + linkTrackerService.redirecLink(linkId).getLink();
        return new RedirectView ("/link/" + linkTrackerService.redirecLink(linkId).getLink());
    }

    @GetMapping("/metrics/{linkId}")
    public String getMetrics(@PathVariable UUID linkId) {
        return "numero de redirecciones:" + linkTrackerService.metricLink(linkId).getCouter();
    }

    @DeleteMapping("/invalidate/{linkId}")
    public String invalidateLink(@PathVariable UUID linkId) {
        if(!linkTrackerService.deleteLink(linkId)){
            throw new NotFoundException("Link not found");
        }
        return "link eliminado correctamente";
    }
}
