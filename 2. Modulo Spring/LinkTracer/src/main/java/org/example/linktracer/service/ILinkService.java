package org.example.linktracer.service;

import org.example.linktracer.dto.LinkMetricsDto;
import org.example.linktracer.dto.LinkResponseDto;


public interface ILinkService {
    LinkResponseDto generateLink(String password);
    String redirect(String linkId);
    LinkMetricsDto getMetrics(String linkId);
    String invalidateLink(String linkId);
}
