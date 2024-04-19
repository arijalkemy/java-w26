package com.example.linkTracker.service;

import com.example.linkTracker.dto.NewLinkDto;
import com.example.linkTracker.dto.StatisticsLinkDto;
import com.example.linkTracker.model.Link;

import java.util.List;

public interface ITrackerService {

    NewLinkDto saveNewLink();

    boolean redirect( String id );

    StatisticsLinkDto getStatistics( String id);

    void invalidateLink( String id );
}
