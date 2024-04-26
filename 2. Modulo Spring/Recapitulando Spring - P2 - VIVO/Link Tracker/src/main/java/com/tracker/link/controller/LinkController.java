package com.tracker.link.controller;

import com.tracker.link.dto.ContadorResponseDTO;
import com.tracker.link.dto.LinkResponseDTO;
import com.tracker.link.service.ILinkService;
import com.tracker.link.service.impl.LinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class LinkController {
    ILinkService linkService;

    @PostMapping("/link/create")
    public ResponseEntity<LinkResponseDTO> createLink(@RequestParam(required = false) String password, @RequestBody String url) {
        return ResponseEntity.ok(linkService.createLink(url, password));
    }

    @GetMapping("/link/{linkid}")
    public void redirect(HttpServletResponse response, @PathVariable int linkid) throws IOException {

        String url = linkService.getLink(linkid);
        if (url != null) {
            response.sendRedirect(url);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Link not found");
        }
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<ContadorResponseDTO> getMetrics(@PathVariable int linkid) {
        return ResponseEntity.ok(linkService.getMetrics(linkid));
    }

    @PostMapping("/invalidate/{linkID}")
    public ResponseEntity<String> invalidate(@PathVariable int linkid) {
        return ResponseEntity.ok(linkService.invalidate(linkid));
    }

}
