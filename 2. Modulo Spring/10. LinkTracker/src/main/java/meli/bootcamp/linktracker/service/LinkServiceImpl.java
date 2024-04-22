package meli.bootcamp.linktracker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import meli.bootcamp.linktracker.dto.LinkRequestDTO;
import meli.bootcamp.linktracker.dto.LinkMetricsDTO;
import meli.bootcamp.linktracker.dto.NewLinkDTO;
import meli.bootcamp.linktracker.dto.LinkResponseDTO;
import meli.bootcamp.linktracker.entity.Link;
import meli.bootcamp.linktracker.exception.ForbiddenException;
import meli.bootcamp.linktracker.exception.UnauthorizedException;
import meli.bootcamp.linktracker.exception.NotFoundException;
import meli.bootcamp.linktracker.repository.LinkRepository;
import meli.bootcamp.linktracker.service.interfaces.ILinkService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LinkServiceImpl implements ILinkService {
    private final LinkRepository linkRepository;
    private final ObjectMapper objectMapper;

    @Override
    public NewLinkDTO createLink(LinkRequestDTO linkRequestDTO) {
        Link newLink = objectMapper.convertValue(linkRequestDTO, Link.class);
        int size = linkRepository.findAll().size();
        newLink.setId(size + 1);
        newLink.setActive(true);
        linkRepository.save(newLink);
        return objectMapper.convertValue(newLink, NewLinkDTO.class);
    }

    @Override
    public LinkResponseDTO redirect(Integer id, String password) {
        Link link = linkRepository.findById(id);
        if (link == null) {
            throw new NotFoundException("Link not found");
        }
        if (!link.getActive()) {
            throw new ForbiddenException("Link is not active");
        }
        if(!(link.getPassword() == null) && password == null){
            throw new UnauthorizedException("No password provided");
        }

        if(!(link.getPassword() == null) && !(link.getPassword().equals(password))){
            throw new UnauthorizedException("Password does not match");
        }

        int count = link.getRedirectionCount() != null ? link.getRedirectionCount() + 1 : 1;
        link.setRedirectionCount(count);


        return objectMapper.convertValue(link, LinkResponseDTO.class);
    }

    @Override
    public LinkMetricsDTO getMetricsLink(Integer id) {
        Link link = linkRepository.findById(id);
        if (link == null) {
            throw new NotFoundException("Link not found");
        }

        return objectMapper.convertValue(link, LinkMetricsDTO.class);
    }

    @Override
    public void invalidateLink(Integer id) {
        Link link = linkRepository.findById(id);
        if (link == null) {
            throw new NotFoundException("Link not found");
        }
        link.setActive(false);
    }
}
