package com.w26.linktracker.controller;

import com.w26.linktracker.dto.LinkMetricsCalls;
import com.w26.linktracker.service.IGetMetricsLink;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
public class MetricsController {
    final IGetMetricsLink serviceMetrics;

    public MetricsController(IGetMetricsLink serviceMetrics)
    {
        this.serviceMetrics = serviceMetrics;
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<?> getMetricsById(@PathVariable Integer linkId){
        LinkMetricsCalls response = serviceMetrics.getMetricsById(linkId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
