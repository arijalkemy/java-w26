package org.example.linktracker.service;

import org.example.linktracker.dto.ResponseIdlinkTrackerDTO;
import org.example.linktracker.dto.ResponseLinkTrackerDTO;
import org.example.linktracker.dto.ResponseRedirectLinkDTO;
import org.example.linktracker.entity.LinkTrackerEntity;

import java.util.UUID;

public interface ILinkTrackerService {
    ResponseIdlinkTrackerDTO saveLink (ResponseLinkTrackerDTO link);
    ResponseRedirectLinkDTO redirecLink (UUID linkId);
    ResponseRedirectLinkDTO metricLink (UUID linkId);
    boolean deleteLink (UUID linkId);
}
