package com.example.linktracker.service;

import com.example.linktracker.dto.LinkDTO;

public interface IlinkService {
    LinkDTO create(LinkDTO link);

    LinkDTO redirect(Integer linkId);

    LinkDTO redirect(Integer linkId, String password);

    LinkDTO metrics(Integer linkId);

    void invalidate(Integer linkId);
}
