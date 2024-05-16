package org.example.linktracker.service;


import org.example.linktracker.dto.ResponseIdlinkTrackerDTO;
import org.example.linktracker.dto.ResponseLinkTrackerDTO;
import org.example.linktracker.dto.ResponseRedirectLinkDTO;
import org.example.linktracker.entity.LinkTrackerEntity;
import org.example.linktracker.exception.NotFoundException;
import org.example.linktracker.repository.ILinkTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LinkTrackerServiceImpl implements ILinkTrackerService{
    @Autowired
    ILinkTrackerRepository linkTrackerRepository;

    @Override
    public ResponseIdlinkTrackerDTO saveLink(ResponseLinkTrackerDTO link) {
        ResponseIdlinkTrackerDTO responseIdlinkTrackerDTO = new ResponseIdlinkTrackerDTO();
        LinkTrackerEntity linkTrackerEntity = new LinkTrackerEntity(link.getLink(), link.getPassword());

        responseIdlinkTrackerDTO.setId(linkTrackerRepository.saveLink(linkTrackerEntity).getId());

        return responseIdlinkTrackerDTO;
    }

    @Override
    public ResponseRedirectLinkDTO redirecLink(UUID linkId) {

        ResponseRedirectLinkDTO responseRedirectLinkDTO = new ResponseRedirectLinkDTO();

        List<LinkTrackerEntity> linkTrackerEntity  = linkTrackerRepository.redirectLink(linkId);

        if(linkTrackerEntity.isEmpty()){
            throw new NotFoundException("link not found");
        }

        linkTrackerEntity.get(0).sumaCounter();
        responseRedirectLinkDTO.setLink(linkTrackerEntity.get(0).getLink());
        responseRedirectLinkDTO.setCouter(linkTrackerEntity.get(0).getCounter());

        return responseRedirectLinkDTO;
    }

    @Override
    public ResponseRedirectLinkDTO metricLink(UUID linkId) {

        ResponseRedirectLinkDTO responseRedirectLinkDTO = new ResponseRedirectLinkDTO();

        List<LinkTrackerEntity> linkTrackerEntity  = linkTrackerRepository.redirectLink(linkId);

        if(linkTrackerEntity.isEmpty()){
            throw new NotFoundException("metric not found");
        }

        responseRedirectLinkDTO.setLink(linkTrackerEntity.get(0).getLink());
        responseRedirectLinkDTO.setCouter(linkTrackerEntity.get(0).getCounter());

        return responseRedirectLinkDTO;
    }

    @Override
    public boolean deleteLink(UUID linkId) {

        return linkTrackerRepository.deleteLink(linkId);
    }
}
