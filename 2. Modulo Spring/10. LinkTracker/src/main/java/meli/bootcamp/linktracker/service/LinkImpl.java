package meli.bootcamp.linktracker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import meli.bootcamp.linktracker.dto.RequestLinkDTO;
import meli.bootcamp.linktracker.dto.MetricsLinkDTO;
import meli.bootcamp.linktracker.dto.NewLinkDTO;
import meli.bootcamp.linktracker.dto.ResponseLinkDTO;
import meli.bootcamp.linktracker.entity.Link;
import meli.bootcamp.linktracker.exception.NoPasswordException;
import meli.bootcamp.linktracker.exception.NotFoundException;
import meli.bootcamp.linktracker.exception.PasswordErrorException;
import meli.bootcamp.linktracker.repository.LinkRepository;
import meli.bootcamp.linktracker.service.interfaces.ILink;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LinkImpl implements ILink {
    private final LinkRepository linkRepository;
    private final ObjectMapper objectMapper;

    @Override
    public NewLinkDTO createLink(RequestLinkDTO requestLinkDTO) {
        Link newLink = objectMapper.convertValue(requestLinkDTO, Link.class);
        int size = linkRepository.findAll().size();
        newLink.setId(size + 1);
        newLink.setActive(true);
        linkRepository.save(newLink);
        return objectMapper.convertValue(newLink, NewLinkDTO.class);
    }

    @Override
    public ResponseLinkDTO redirect(Integer id, String password) {
        Link link = linkRepository.findById(id);
        if (link == null) {
            throw new NotFoundException("Link not found");
        }
        if (!link.getActive()) {
            throw new NotFoundException("Link is not active");
        }
        if(!(link.getPassword() == null) && password == null){
            throw new NoPasswordException("No password provided");
        }

        if(!(link.getPassword() == null) && !(link.getPassword().equals(password))){
            throw new PasswordErrorException("Password does not match");
        }

        int count = link.getRedirectionCount() != null ? link.getRedirectionCount() + 1 : 1;
        link.setRedirectionCount(count);


        return objectMapper.convertValue(link, ResponseLinkDTO.class);
    }

    @Override
    public MetricsLinkDTO getMetricsLink(Integer id) {
        Link link = linkRepository.findById(id);
        if (link == null) {
            throw new NotFoundException("Link not found");
        }

        return objectMapper.convertValue(link, MetricsLinkDTO.class);
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
