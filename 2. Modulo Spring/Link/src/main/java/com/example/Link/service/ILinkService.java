package com.example.Link.service;
import com.example.Link.dto.LinkDTO;
public interface ILinkService {
    LinkDTO createLink(String url);
    LinkDTO getLinkDTO(Integer id);
    String redirect(Integer id);
    void invalidateLink(Integer id);
}
