package com.spring.linktracker.service;

import com.spring.linktracker.dto.LinkRequestDTO;
import com.spring.linktracker.dto.LinkResponseDTO;

public interface ILinksService {

    LinkResponseDTO createLink(LinkRequestDTO linkRequest, String password);

    String redirectLink(Integer linkId, String password);

    Integer getLinkMetrics(Integer linkId);

    void invalidateLink(Integer linkId);

}
