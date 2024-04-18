package org.practicaspring.links.controller;

import org.practicaspring.links.service.ILinkInvalidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invalidate")
public class LinkInvalidationController {
    @Autowired
    ILinkInvalidationService linkInvalidationService;

    @DeleteMapping("/{linkId}")
    public ResponseEntity<?> deleteLink(@PathVariable Long linkId) {
        linkInvalidationService.invalidate(linkId);
        return ResponseEntity.ok().build();
    }
}
