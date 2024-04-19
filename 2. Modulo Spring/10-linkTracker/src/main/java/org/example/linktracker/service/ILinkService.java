package org.example.linktracker.service;

import jakarta.servlet.http.HttpServletResponse;
import org.example.linktracker.dto.IdLinkDTO;
import org.example.linktracker.dto.LinkDTO;

import java.io.IOException;

public interface ILinkService {
    IdLinkDTO create(String url);
    IdLinkDTO create(String url, String password);
    void redirect(String id, HttpServletResponse response) throws IOException;
    LinkDTO getCantRedirects(String id);
    LinkDTO invalidateLink(String id);
}
