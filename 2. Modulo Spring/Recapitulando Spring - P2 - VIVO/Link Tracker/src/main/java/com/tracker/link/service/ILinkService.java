package com.tracker.link.service;

import com.tracker.link.dto.ContadorResponseDTO;
import com.tracker.link.dto.LinkResponseDTO;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface ILinkService {
    List<LinkResponseDTO> allLinks();
    LinkResponseDTO createLink(String url, String password);

    String getLink(int id);

    ContadorResponseDTO getMetrics(int linkID);

    String invalidate(int linkid);

}
