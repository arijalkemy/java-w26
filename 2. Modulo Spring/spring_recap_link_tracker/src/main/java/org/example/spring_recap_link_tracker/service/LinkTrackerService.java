package org.example.spring_recap_link_tracker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.spring_recap_link_tracker.dto.CreateLinkDTO;
import org.example.spring_recap_link_tracker.dto.InvalidateLinkDTO;
import org.example.spring_recap_link_tracker.dto.LinkMetricsDTO;
import org.example.spring_recap_link_tracker.dto.LinkResponseDTO;
import org.example.spring_recap_link_tracker.entity.LinkTrack;
import org.example.spring_recap_link_tracker.exception.BadRequestException;
import org.example.spring_recap_link_tracker.exception.NotFoundException;
import org.example.spring_recap_link_tracker.repository.ILinkTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LinkTrackerService implements ILinkTrackerService {
    @Autowired
    ILinkTrackerRepository linkTrackerRepository;

    public LinkResponseDTO createLink(CreateLinkDTO newLinkData){
        Pattern pattern = Pattern.compile("(https:\\/\\/www\\.|http:\\/\\/www\\.|https:\\/\\/|http:\\/\\/)?[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})(\\.[a-zA-Z]{2,})?\\/[a-zA-Z0-9]{2,}|((https:\\/\\/www\\.|http:\\/\\/www\\.|https:\\/\\/|http:\\/\\/)?[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})(\\.[a-zA-Z]{2,})?)|(https:\\/\\/www\\.|http:\\/\\/www\\.|https:\\/\\/|http:\\/\\/)?[a-zA-Z0-9]{2,}\\.[a-zA-Z0-9]{2,}\\.[a-zA-Z0-9]{2,}(\\.[a-zA-Z0-9]{2,})?");
        Matcher matcher = pattern.matcher(newLinkData.getLink());
        if (!matcher.matches()) {
            throw new BadRequestException("El link no es válido");
        }
        UUID uuid = UUID.randomUUID();
        String linkId = uuid.toString();
        LinkTrack newLink = new LinkTrack(
                linkId,
                newLinkData.getLink(),
                0,
                true,
                newLinkData.getPassword()
        );
        linkTrackerRepository.createNewLink(newLink);
        return new LinkResponseDTO(linkId);
    }

    @Override
    public LinkMetricsDTO getMetrics(String linkId) {
        LinkTrack linkTrack = linkTrackerRepository.getLinkById(linkId);
        if (linkTrack == null) {
            throw new NotFoundException("No se encontró ningún link con ese id");
        }
        return new LinkMetricsDTO(linkTrack.getRedirectCount());
    }

    public InvalidateLinkDTO invalidateLink(String linkId) {
        LinkTrack linkTrack = linkTrackerRepository.getLinkById(linkId);
        if (linkTrack == null) {
            throw new NotFoundException("No se encontró ningún link con ese id");
        }
        linkTrack.setEnabled(false);
        linkTrackerRepository.invalidateLink(linkTrack);
        return new InvalidateLinkDTO(linkTrack.getLinkId(), "Link invalidado");
    }
}
