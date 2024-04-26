package org.example.linktracker.util;

import org.example.linktracker.dto.out.LinkResponseDto;
import org.example.linktracker.dto.out.LinkWithMetricsResponseDto;
import org.example.linktracker.model.Link;

public class LinkMapper {

    public static LinkResponseDto toDto(Link link) {

        return new LinkResponseDto(link.getLinkId(), link.getTargetUrl());
    }

    public static LinkWithMetricsResponseDto toDtoWithMetrics(Link link) {

        return new LinkWithMetricsResponseDto(
            link.getLinkId(), link.getTargetUrl(), link.getHitCount()
        );
    }
}
