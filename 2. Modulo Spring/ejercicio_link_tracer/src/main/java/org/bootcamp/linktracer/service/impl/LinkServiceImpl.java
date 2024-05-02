package org.bootcamp.linktracer.service.impl;

import org.bootcamp.linktracer.dto.LinkDTO;
import org.bootcamp.linktracer.dto.ResponseDTO;
import org.bootcamp.linktracer.dto.response.LinkResponseDTO;
import org.bootcamp.linktracer.entity.Link;
import org.bootcamp.linktracer.exception.NotFoundException;
import org.bootcamp.linktracer.exception.UnauthorizedException;
import org.bootcamp.linktracer.mapper.LinkMapper;
import org.bootcamp.linktracer.repository.LinkRepository;
import org.bootcamp.linktracer.service.LinkService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkServiceImpl implements LinkService {

    LinkRepository linkRepository;

    public LinkServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }


    @Override
    public LinkResponseDTO saveLink(LinkDTO linkDTO) {
        return LinkResponseDTO.builder()
                .linkId(linkRepository.save(
                        LinkMapper.linkDTOToLink(linkDTO)).getId())
                .build();
    }

    @Override
    public String getRedirect(Integer id, String password) {
        Link link = getLinkById(id);

        validatedLink(link);

        if (password == null || !password.equals(link.getPassword()))
            throw new UnauthorizedException("The credentials are not valid.");

        link.setVisitAmount(link.getVisitAmount() + 1);

        return linkRepository.save(link).getUrl();
    }

    @Override
    public LinkResponseDTO getLinkMetrics(Integer id) {
        Link link = getLinkById(id);

        return LinkResponseDTO.builder()
                .visitAmount(link.getVisitAmount())
                .build();
    }

    @Override
    public ResponseDTO invalidateLink(Integer id) {
        Link link = getLinkById(id);

        if(Boolean.TRUE.equals(link.getValidUrl())){
            link.setValidUrl(Boolean.FALSE);
            linkRepository.save(link);
        }
        return new ResponseDTO("Link successfully invalidated.");
    }

    private void validatedLink(Link link) {
        if (link == null || !link.getValidUrl())
            throw new NotFoundException("The link is invalid or has been removed.");
    }

    private Link getLinkById(Integer id) {
        Optional<Link> linkOptional = linkRepository.findById(id);

        if (linkOptional.isEmpty())
            throw new NotFoundException("No link information was found with the id " + id);

        return linkOptional.get();
    }
}
