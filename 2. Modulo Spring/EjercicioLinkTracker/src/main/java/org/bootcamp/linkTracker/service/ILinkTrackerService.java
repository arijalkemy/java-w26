package org.bootcamp.linkTracker.service;

import org.bootcamp.linkTracker.dto.LinkRequestDTO;
import org.bootcamp.linkTracker.dto.LinkResponseDTO;

import java.util.Optional;

public interface ILinkTrackerService {
    public LinkResponseDTO createLink(LinkRequestDTO link);
    public String findLinkById(String id, Optional<String> pass);
    public void incrementVisitCounter(String id);
    public Integer getVisitCounter(String id);
    public String deleteLink(String id);
}
