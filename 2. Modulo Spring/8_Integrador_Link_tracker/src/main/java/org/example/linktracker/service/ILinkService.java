package org.example.linktracker.service;

import org.example.linktracker.dto.in.LinkRequestDto;
import org.example.linktracker.dto.out.LinkResponseDto;
import org.example.linktracker.dto.out.LinkWithMetricsResponseDto;

public interface ILinkService {

    LinkResponseDto createLink(LinkRequestDto targetUrl);

    String getTargetUrlForLinkId(String linkId);

    LinkWithMetricsResponseDto getLinkWithMetrics(String linkId);

    void invalidateLink(String linkId);
}
