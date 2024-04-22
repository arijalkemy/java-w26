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
    public NewLinkDto saveNewLink( String password ) {
        List<Link> links = trackerRepository.getAll();
        Link newLink = new Link(Integer.valueOf(links.size()).toString(), true, 0 );
        newLink.setPassword(password);
        trackerRepository.save(newLink);
        System.out.println(newLink.toString());
        return new NewLinkDto(newLink);
    }

    @Override
    public void redirect(String id) {
        Link link = trackerRepository.findById(id);
        if( link == null || !link.getValid() || !( link.getPassword() == null ) ){
            throw new NotFoundException("Thi id: " + id + " is not found");
        }
        boolean sum = trackerRepository.sumRedirect(id);
        if( !sum ){
            throw new NotFoundException("Thi id: " + id + " is not found");
        }
    }

    @Override
    public void redirect(String id, String password) {
        Link link = trackerRepository.findById(id);
        if( link == null || !link.getValid() || !link.getPassword().equals(password) ){
            throw new NotFoundException("Error while redirecting");
        }
        boolean sum = trackerRepository.sumRedirect(id);
        if( !sum ){
            throw new NotFoundException("Thi id: " + id + " is not found");
        }
    }

    @Override
    public StatisticsLinkDto getStatistics(String id) {
        Link findLink = trackerRepository.findById(id);

        if( findLink == null ){
            throw new NotFoundException("Thi id: " + id + " is not found");
        }
        return new StatisticsLinkDto(findLink);
    }

    @Override
    public void invalidateLink(String id) {
        boolean invalidate = trackerRepository.invalidateLink(id);
        if( !invalidate ){
            throw new NotFoundException("Thi id: " + id + " is not found");
        }
    }
}
