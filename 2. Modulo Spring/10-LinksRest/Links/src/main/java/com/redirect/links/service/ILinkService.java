package com.redirect.links.service;


import com.redirect.links.dto.request.LinkRequestDTO;
import com.redirect.links.dto.response.LinkResponseDTO;
import org.springframework.stereotype.Service;

public interface ILinkService {

    LinkResponseDTO addURL(LinkRequestDTO link);

    String redirectURL(Integer id, String password);

    Integer metricsURL(Integer id);

    String invalidateURL(Integer id);

}
