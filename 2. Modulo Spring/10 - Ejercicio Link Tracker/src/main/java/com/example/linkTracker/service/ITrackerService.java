package com.example.linkTracker.service;

import com.example.linkTracker.dto.NewLinkDto;
import com.example.linkTracker.dto.StatisticsLinkDto;
import com.example.linkTracker.model.Link;

import java.util.List;

public interface ITrackerService {

    NewLinkDto saveNewLink();

    NewLinkDto saveNewLink( String password );

    void redirect( String id );

    void redirect( String id, String password );

    StatisticsLinkDto getStatistics( String id);

    void invalidateLink( String id );
}
