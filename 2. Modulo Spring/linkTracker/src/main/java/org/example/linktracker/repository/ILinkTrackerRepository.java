package org.example.linktracker.repository;

import org.example.linktracker.dto.ResponseIdlinkTrackerDTO;
import org.example.linktracker.entity.LinkTrackerEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ILinkTrackerRepository {
    LinkTrackerEntity saveLink (LinkTrackerEntity link);
    List<LinkTrackerEntity> redirectLink (UUID linkId);
    List<LinkTrackerEntity> metricLink (UUID linkId);
    boolean deleteLink (UUID linkId);

}
