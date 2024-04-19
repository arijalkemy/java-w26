package com.meli.LinkTracker.service;

import com.meli.LinkTracker.dto.LinkDto;
import com.meli.LinkTracker.dto.LinkIdDto;
import com.meli.LinkTracker.dto.UrlDto;
import jakarta.servlet.http.HttpServletResponse;

public interface ILinkService {
    LinkIdDto saveLink(UrlDto url);

    void redirect(String linkId, HttpServletResponse response);

    LinkDto getNumberOfRedirects(String linkId);
}
