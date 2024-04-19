package com.example.linkTracker.service.impl;

import com.example.linkTracker.dto.NewLinkDto;
import com.example.linkTracker.dto.StatisticsLinkDto;
import com.example.linkTracker.exceptions.NotFoundException;
import com.example.linkTracker.model.Link;
import com.example.linkTracker.repository.impl.TrackerRepository;
import com.example.linkTracker.service.ITrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.StringJoiner;

@Service
public class TrackerServiceImpl implements ITrackerService {

    @Autowired
    TrackerRepository trackerRepository;


    @Override
    public NewLinkDto saveNewLink() {
        List<Link> links = trackerRepository.getAll();
        Link newLink = new Link(Integer.valueOf(links.size()).toString(), true, 0 );
        trackerRepository.save(newLink);
        return new NewLinkDto(newLink);
    }

    @Override
    public boolean redirect(String id) {
        return false;
    }

    @Override
    public StatisticsLinkDto getStatistics(String id) {
        return null;
    }

    @Override
    public void invalidateLink(String id) {

    }
}
