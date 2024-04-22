package com.javabootcamp.linktracker.controller;

import com.javabootcamp.linktracker.dto.LinkDtoOut;
import com.javabootcamp.linktracker.exception.PasswordNotIdentifiedException;
import com.javabootcamp.linktracker.service.LinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.web.servlet.view.RedirectView;

import javax.swing.text.html.parser.Entity;

@RestController
public class LinkTrackerController {

    @Autowired
    LinkTrackerService linkTrackerService;

    // Add a new Link to the
    @PostMapping("createLink/{linkUrl}")
    public ResponseEntity<String>  addLinkToTrack(@PathVariable String linkUrl, @RequestParam String password){
        if(password!=null&&password.length()>=4){
            int linkID = linkTrackerService.addLink(linkUrl,password);
            return ResponseEntity.status(HttpStatus.CREATED).body("Url added to tracker con el siguiente ID: "+linkID);
        }
        throw new PasswordNotIdentifiedException("No password identified");
    }

    // Redirect a new link
    @GetMapping("/link/{linkId}")
    public RedirectView redirectUrl(@PathVariable String linkId){
        String UrlRedirection = linkTrackerService.getRedirectLink(Integer.parseInt(linkId));
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/"+UrlRedirection);
        return redirectView;
    }

    // Get metrics from a link
    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkDtoOut> getUrlMetrics(@PathVariable int linkId){return ResponseEntity.ok(linkTrackerService.getMetricsLink(linkId));
    }

    // Invalidatelink
    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<String> invalidateLink(@PathVariable int linkId){
        linkTrackerService.invalidateLink(linkId);
        return ResponseEntity.ok("Link invalidated");
    }

}
