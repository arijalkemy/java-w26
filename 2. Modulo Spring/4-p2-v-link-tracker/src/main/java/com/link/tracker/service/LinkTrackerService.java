package com.link.tracker.service;

import com.link.tracker.dto.LinkDTO;

public interface LinkTrackerService {

    LinkDTO createNewLink(LinkDTO linkDTO);

    LinkDTO redirect(Integer linkId);

    LinkDTO redirect(Integer linkId, String password);

    LinkDTO metrics(Integer linkId);

    void invalidate(Integer linkId);
}
