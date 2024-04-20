package com.w26.linktracker.controller;

import com.w26.linktracker.dto.InvalidationLinkResult;
import com.w26.linktracker.dto.LinkCreation;
import com.w26.linktracker.dto.LinkResultCreation;
import com.w26.linktracker.service.IInvalidateLinkService;
import com.w26.linktracker.service.IPostLink;
import com.w26.linktracker.service.IRedirecctionLinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.http.HttpClient;

@RestController
public class LinkController {

    final IPostLink servicePostLink;
    final IInvalidateLinkService serviceInvalidateLink;
    final IRedirecctionLinkService serviceRedirection;

    public LinkController(IPostLink servicePostLink, IInvalidateLinkService serviceInvalidateLink, IRedirecctionLinkService serviceRedirection) {
        this.servicePostLink = servicePostLink;
        this.serviceInvalidateLink = serviceInvalidateLink;
        this.serviceRedirection = serviceRedirection;
    }

    @PostMapping("/link")
    public ResponseEntity<?> postLink(@RequestBody LinkCreation linkCreation, @RequestParam String password)
    {
        LinkResultCreation response = servicePostLink.createLink(linkCreation, password);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirectLink(@PathVariable Integer linkId)
    {
        String url = serviceRedirection.redirectTo(linkId);
        RedirectView rw = new RedirectView();
        rw.setUrl(url);
        return rw;
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable Integer linkId)
    {
        InvalidationLinkResult response   = serviceInvalidateLink.invalidateLinkById(linkId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
