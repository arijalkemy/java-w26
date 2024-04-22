package com.example.demo.service;

import com.example.demo.dto.LinkDto;

public interface ILinkTackerService {

    Long createLink(LinkDto linkDto, String password);
    String getOriginalUrl(Long linkId);
    int getRedirectionCount(Long linkId);
    boolean invalidateLink(Long linkId, String password);

}
