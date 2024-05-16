package org.example.linktracker.repository;

import org.example.linktracker.entity.LinkTrackerEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class LinkTrackerRepository implements ILinkTrackerRepository {

    private static final List<LinkTrackerEntity> linkTrackerEntityList = new ArrayList<>();

    @Override
    public LinkTrackerEntity saveLink(LinkTrackerEntity link) {
        linkTrackerEntityList.add(link);
        return link;
    }

    @Override
    public List<LinkTrackerEntity> redirectLink(UUID linkId) {

        List<LinkTrackerEntity> linkTrackerEntity = linkTrackerEntityList.stream().filter(link -> link.getId().equals(linkId)).collect(Collectors.toList());
        return linkTrackerEntity;
    }

    @Override
    public List<LinkTrackerEntity> metricLink(UUID linkId) {
        List<LinkTrackerEntity> linkTrackerEntity = linkTrackerEntityList.stream().filter(link -> link.getId().equals(linkId)).collect(Collectors.toList());
        return linkTrackerEntity;
    }

    @Override
    public boolean deleteLink(UUID linkId) {
        return linkTrackerEntityList.removeIf(linkTrackerEntity -> linkTrackerEntity.getId().equals(linkId));
    }

}