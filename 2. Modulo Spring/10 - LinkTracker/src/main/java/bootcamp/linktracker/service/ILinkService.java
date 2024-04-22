package bootcamp.linktracker.service;

import bootcamp.linktracker.dto.LinkDTO;

public interface ILinkService {
    LinkDTO createLink(String originalUrl, String password);
    String redirectLink(int linkId, String password);
    int getRedirectCount(int linkId);
    void invalidateLink(Integer linkId);
}
