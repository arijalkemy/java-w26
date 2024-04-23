package com.demospring.linktacker.repository;

import com.demospring.linktacker.entity.Link;

public interface IUryRepository {
    void addLink(Link link);
    Link findLinkById(int id, boolean request);
    int metricsLink(int id);
    void deleteLinkById(int id);
}
