package org.bootcamp.recapitulando_spring_p2_link_tracer.service;

import org.bootcamp.recapitulando_spring_p2_link_tracer.dto.LinkRequestDTO;
import org.bootcamp.recapitulando_spring_p2_link_tracer.dto.LinkResponseDTO;

import java.util.Optional;

public interface ILinkTrackerService {
    public LinkResponseDTO createLink(LinkRequestDTO link);
    public String findLinkById(String id, Optional<String> pass);
    public void incrementVisitCounter(String id);
    public Integer getVisitCounter(String id);
    public String deleteLink(String id);
}
