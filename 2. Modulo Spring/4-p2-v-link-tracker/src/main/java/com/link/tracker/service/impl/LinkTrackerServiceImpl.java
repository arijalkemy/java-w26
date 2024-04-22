package com.link.tracker.service.impl;

import com.link.tracker.dto.LinkDTO;
import com.link.tracker.repository.LinkRepository;
import com.link.tracker.service.LinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkTrackerServiceImpl implements LinkTrackerService {

    @Autowired
    LinkRepository linkRepository;

    @Override
    public LinkDTO createNewLink(LinkDTO linkDTO){
        return linkRepository.save(linkDTO);
    }

    @Override
    public LinkDTO redirect(Integer linkId) {
        Optional<LinkDTO> link = linkRepository.findLinkByLinkId(linkId);
        link.ifPresent(this::sumMetric);
        return link.orElse(null);
    }

    @Override
    public LinkDTO redirect(Integer linkId, String password) {
        Optional<LinkDTO> link = linkRepository.findLinkByLinkId(linkId);
        LinkDTO result = null;
        if (link.isPresent())
            result = checkLinkAndPassword(password, link.get());
        return result;
    }

    private LinkDTO checkLinkAndPassword(String password, LinkDTO linkDTO) {
        LinkDTO result = null;
        if (linkDTO.getPassword() != null && linkDTO.getPassword().equals(password)){
            result = linkDTO;
            sumMetric(linkDTO);
        }
        return result;
    }

    private void sumMetric(LinkDTO linkDTO) {
        linkDTO.sumCount();
        linkRepository.save(linkDTO);
    }

    @Override
    public LinkDTO metrics(Integer linkId) {
        Optional<LinkDTO> link = linkRepository.findLinkByLinkId(linkId);
        return link.orElse(null);
    }

    @Override
    public void invalidate(Integer linkId) {
        Optional<LinkDTO> link = linkRepository.findLinkByLinkId(linkId);
        link.ifPresent(linkRepository::delete);
    }



}
