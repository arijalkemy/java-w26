package org.example.linktraker.service;

import org.example.linktraker.dto.request.LinkCrearRequestDto;
import org.example.linktraker.dto.response.LinkCrearResponseDto;
import org.example.linktraker.dto.response.LinkMetricasResponseDto;

public interface ILinkService {
    LinkCrearResponseDto addLink(LinkCrearRequestDto link);
    String redirectLink(int linkId, String password);
    LinkMetricasResponseDto getMetricas(int linkId);
    void invalidarLink(int linkId, boolean validate);
}
