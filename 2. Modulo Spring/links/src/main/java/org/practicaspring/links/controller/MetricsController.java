package org.practicaspring.links.controller;

import org.practicaspring.links.service.ILinkMetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
public class MetricsController {
    @Autowired
    ILinkMetricsService linkMetricsService;

    @GetMapping("/{linkId}")
    public ResponseEntity<Integer> checkMetrics(@PathVariable Long linkId) {
        return ResponseEntity.ok(linkMetricsService.checkMetrics(linkId));
    }
}
