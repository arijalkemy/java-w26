package org.example.integradorlinktracker.service;

import org.example.integradorlinktracker.dto.LinkDto;
import org.example.integradorlinktracker.dto.LinkMetricsDto;
import org.example.integradorlinktracker.entity.Link;

public interface ILinkService <K> {
    Link createLink(LinkDto linkDto);
    Link redirect(int linkId, String password);
    LinkMetricsDto getLinkMetrics(int linkId);
    void invalidateLink(int linkId);


}
