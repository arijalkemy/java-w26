package org.example.spring_recap_link_tracker.service;

import org.example.spring_recap_link_tracker.dto.CreateLinkDTO;
import org.example.spring_recap_link_tracker.dto.InvalidateLinkDTO;
import org.example.spring_recap_link_tracker.dto.LinkMetricsDTO;
import org.example.spring_recap_link_tracker.dto.LinkResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface ILinkTrackerService {
    public LinkResponseDTO createLink(CreateLinkDTO newLinkData);
    public LinkMetricsDTO getMetrics(String linkId);
    public InvalidateLinkDTO invalidateLink(String linkId);
}
