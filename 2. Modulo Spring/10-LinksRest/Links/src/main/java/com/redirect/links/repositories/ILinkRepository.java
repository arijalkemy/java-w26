package com.redirect.links.repositories;

import com.redirect.links.entities.Link;

public interface ILinkRepository {

    Integer addLink(Link link);

    Link showLink(Integer id, String password);

    Link giveLinkNoPassword(Integer id);

    void invalidateLink(Integer id);
}
